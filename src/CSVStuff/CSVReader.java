package CSVStuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CSVReader {
    File file;
    Scanner scan;
    ArrayList<Double> inputs;
    ArrayList<Double> outputs;

    public CSVReader(String fileName) throws FileNotFoundException {
        scan = new Scanner(new File(fileName)).useDelimiter(",|\\n");
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    /**
     * Iterates through .csv
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
}
