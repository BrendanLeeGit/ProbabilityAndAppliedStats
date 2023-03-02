package CSVStuff;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionOutput {
    //wanna use equation slope y = mx + b
    ArrayList<Double> outputs;
    ArrayList<Double> inputs;

    FileWriter fileWriter;
    public FunctionOutput(){
        outputs = new ArrayList<>();
        inputs = new ArrayList<>();
    }

    public void buildOutputArrayList(double x1, double x2, double increment, double m, double b){
        double result = 1;
        while (Double.compare(x1, x2) == 1 || Double.compare(x1,x2) < 0){
            result = x1 * m + b;
            outputs.add(result);
            inputs.add(x1);
            x1 += increment;
        }
    }

    public void buildFile() throws IOException {
        fileWriter = new FileWriter("output.csv");
        fileWriter.write("x,y\n");
        for (int i = 0; i < outputs.size(); i++){
            fileWriter.write(inputs.get(i) + "," + outputs.get(i) + "\n");
        }
        fileWriter.close();
    }

    public ArrayList<Double> getOutputArrayList(){
        return outputs;
    }

    /**
     *
     * @param x  minimum range 
     * @param x2 maximum range
     * @param increment
     * @param m
     * @param b
     * @throws IOException
     */
    public void run(double x, double x2, double increment, double m, double b) throws IOException {
        buildOutputArrayList(x, x2, increment, m, b);
        buildFile();

        CSVReader csvreader = new CSVReader("output.csv");
        csvreader.goThroughCSV();
        csvreader.printArrayLists();
    }
}
