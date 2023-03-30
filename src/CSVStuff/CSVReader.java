package CSVStuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class CSVReader {
    Scanner scan;
    ArrayList<Double> inputs;
    ArrayList<Double> outputs;
    Random random;

    public CSVReader(String fileName) throws FileNotFoundException {
        scan = new Scanner(new File(fileName)).useDelimiter(",|\\n");
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        random = new Random();
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

    /**
     * Salts the values in the output ArrayList
     * @param saltValue
     */
    public void salter(int saltValue){
        for (int i = 0; i < outputs.size(); i++) {
            outputs.set(i, outputs.get(i) + random.nextInt(saltValue));
        }
    }


    public void smoother(int range, int smoothCount){
        //this is the base method, determines range and how many times we're smoothing this
        for (int j = 0; j < smoothCount; j++){
            for (int i = 0; i < outputs.size(); i++){
                outputs.set(i, calculatePointAverage(i, range));
            }
        }
    }

    public double calculatePointAverage(int currentY, int range){
        //this is likely just gonna be called over and over again for each point
        int beginningY = currentY - range;
        int endingY = currentY + range;
        double total = 0;
        double avg;

        //avoid index out of bounds error, change any negative index to 0
        if (beginningY < 0){
            beginningY = 0;
        }

        //similarly, change any index above the max to just the range
        if (endingY >= outputs.size()){
            endingY = outputs.size() - 1;//-1 since it'll be 1 greater bc index starts at 0
        }

        for (int i = beginningY; i <= endingY; i++){
            total += outputs.get(i);
        }
        avg = total/(endingY - beginningY);

        return avg;
    }
}
