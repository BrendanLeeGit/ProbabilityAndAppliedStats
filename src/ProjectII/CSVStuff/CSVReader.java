package ProjectII.CSVStuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class CSVReader {
    private Scanner scan;
    private ArrayList<Double> inputs;
    private ArrayList<Double> outputs;
    private Random random;

    public CSVReader(String fileName) throws FileNotFoundException {
        scan = new Scanner(new File(fileName)).useDelimiter(",|\\n");
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        random = new Random();
    }

    /**
     * Iterates through .csv and stores the values.
     */
    public void goThroughCSV(){
        scan.nextLine();
        while (scan.hasNextLine()){
            inputs.add(Double.valueOf(scan.next()));
            outputs.add(Double.valueOf(scan.next()));
            scan.nextLine();
        }
    }

    /**
     * Prints out the inputs and outputs ArrayLists.
     */
    public void printArrayLists(){
        for (int i = 0; i < outputs.size(); i++){
            System.out.println(inputs.get(i) + " " + outputs.get(i));
        }
    }

    /**
     * Basic getter.
     *
     * @return  The outputs array list
     */
    public ArrayList<Double> getOutputs(){
        return outputs;
    }

}
