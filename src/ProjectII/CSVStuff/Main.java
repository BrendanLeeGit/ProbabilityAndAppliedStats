package ProjectII.CSVStuff;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FunctionOutput functionOutput = new FunctionOutput();
        functionOutput.run(0, 1000, 1, 5, 6);

        //The smalter isn't required to run the program, there just won't be a FinalCSV.csv produced
        functionOutput.runSmalter(5000, 10, 10);
    }
}
