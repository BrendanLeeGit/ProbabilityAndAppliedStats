package ProjectII.CSVStuff;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionOutput {
    //Using equation slope y = mx + b
    ArrayList<Double> outputs;
    ArrayList<Double> inputs;
    FileWriter fileWriter;

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
    public void buildFile() throws IOException {
        //Create FileWriter object that creates an output csv file
        fileWriter = new FileWriter("output.csv");
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
        buildOutputArrayList(x, x2, increment, m, b);
        buildFile();

        CSVReader csvreader = new CSVReader("output.csv");
        csvreader.goThroughCSV();
        csvreader.printArrayLists();

        System.out.println("Salted list:");
        csvreader.salter(30);
        csvreader.printArrayLists();

        System.out.println("Smoothed list:");
        csvreader.smoother(5,1);
        csvreader.printArrayLists();
    }
}
