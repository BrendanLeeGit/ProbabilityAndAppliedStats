package ProjectII.CSVStuff;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionOutput {
    //Using equation slope y = mx + b
    private ArrayList<Double> outputs;
    private ArrayList<Double> inputs;
    private FileWriter fileWriter;
    private CSVReader csvreader;

    public FunctionOutput(){
        outputs = new ArrayList<>();
        inputs = new ArrayList<>();
    }

    /**
     * Takes in a range of inputs and adds the outputs to the outputs ArrayList.
     *
     * @param x1        Lower bound of input values
     * @param x2        Upper bound of input values
     * @param increment How much you want your x to increase by for each run
     * @param m         Slope
     * @param b         Starting Y-axis
     */
    public void buildOutputArrayList(double x1, double x2, double increment, double m, double b){
        double result = 1;
        //
        while (Double.compare(x1, x2) == 1 || Double.compare(x1,x2) < 0){
            result = x1 * m + b;
            outputs.add(result);
            inputs.add(x1);
            x1 += increment;
        }
    }

    /**
     * Uses FileWriter to generate the .csv file with the proper outputs.
     *
     * @throws IOException
     */
    public void buildFile(String fileName) throws IOException {
        //Create FileWriter object that creates an output csv file
        fileWriter = new FileWriter(fileName);
        fileWriter.write("x,y\n");

        //Write the entire outputs ArrayList on the file
        for (int i = 0; i < outputs.size(); i++){
            fileWriter.write(inputs.get(i) + "," + outputs.get(i) + "\n");
        }

        //Close the file to avoid issues.
        fileWriter.close();
    }

    /**
     * Getter for the outputs ArrayList.
     * @return  the outputs ArrayList
     */
    public ArrayList<Double> getOutputArrayList(){
        return outputs;
    }

    /**
     * Setter for the outputs ArrayList.
     * @param outputs   The new ArrayList you would like outputs to be set to
     */
    public void setOutputArrayList(ArrayList<Double> outputs){
        this.outputs = outputs;
    }

    /**
     * The run method. Drives the entire program forwards using the template pattern.
     *
     * @param x          Minimum range
     * @param x2         Maximum range
     * @param increment  How much you want your x to increase by for each run
     * @param m          Slope
     * @param b          Y-axis start
     * @throws IOException
     */
    public void run(double x, double x2, double increment, double m, double b) throws IOException {
        //Create CSV with the x and y values
        buildOutputArrayList(x, x2, increment, m, b);
        buildFile("InitialCSV.csv");

        //Read CSV and enter them into the CSVReader object
        csvreader = new CSVReader("InitialCSV.csv");
        csvreader.goThroughCSV();
    }

    /**
     * This method controls the salting and smoothing of the dataset. It salts the list and then smoothes it
     * according to the parameters.
     *
     * @param saltValue     The maximum value a single index can be salted by
     * @param smoothRange   How far to the left and right the rolling average will consider
     * @param smoothCount   How many times the dataset will be smoothed
     * @throws IOException
     */
    public void runSmalter(int saltValue, int smoothRange, int smoothCount) throws IOException {
        //Create FinalCVSPrinter, since we'll be adding the array lists as we run the program
        FinalCSVPrinter finalCSVPrinter = new FinalCSVPrinter(inputs);

        //Add the initial output array list before manipulating it
        finalCSVPrinter.addList(csvreader.getOutputs());

        //Smalter = SMelter + sALTER
        //Salt the list
        Smalter smalter = new Smalter();
        smalter.salter(csvreader.getOutputs(), saltValue);
        finalCSVPrinter.addList(csvreader.getOutputs());

        //Smooth the list
        smalter.smoother(csvreader.getOutputs(), smoothRange, smoothCount);
        finalCSVPrinter.addList(csvreader.getOutputs());

        //Smooth the list but remove some values at the beginning and end depending on the range
        smalter.cutOffEnds(csvreader.getOutputs(), 3);

        //Finally build the file with every list combined, except for the haircut output list
        finalCSVPrinter.buildFile("FinalCSV.csv");
    }
}
