package ProjectII.CSVStuff;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FinalCSVPrinter {
    private ArrayList<ArrayList<Double>> listHolder;
    private FileWriter fileWriter;
    private ArrayList<Double> inputs;

    public FinalCSVPrinter(ArrayList<Double> inputs){
        listHolder = new ArrayList<>();
        this.inputs = inputs;

    }

    /**
     * Clones an ArrayList and adds the clone to listHolder.
     *
     * @param outputs   The ArrayList you would like to add.
     */
    public void addList(ArrayList<Double> outputs){
        //Need to clone the array before adding it, else it'll just be adding a new reference
        ArrayList<Double> clone = (ArrayList<Double>) outputs.clone();
        listHolder.add(clone);

    }

    /**
     * Uses FileWriter to generate the .csv file with the proper outputs.
     *
     * @throws IOException
     */
    public void buildFile(String fileName) throws IOException {
        //Create FileWriter object that creates an output csv file
        fileWriter = new FileWriter(fileName);

        //Make sure the column headers adjust for listHolder size
        String header = "x,";
        for (int i = 1; i < listHolder.size() + 1; i++){
            header += "y" + i + ",";
        }
        header += "\n";
        fileWriter.write(header);

        String row = ""; //for use in constructing a string representing a row of any length

        //Write the entire outputs ArrayList on the file
        for (int i = 0; i < listHolder.get(0).size(); i++){
            row = inputs.get(i) + ",";

            //Build row string with a loop by concatenating each output list
            for (ArrayList<Double> doubles : listHolder) {
                row += doubles.get(i) + ",";
            }
            row += "\n";

            fileWriter.write(row);
        }

        //Close the file to avoid issues.
        fileWriter.close();
    }
}
