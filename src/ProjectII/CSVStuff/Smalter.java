package ProjectII.CSVStuff;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Smalter {
    private SplittableRandom random;

    public Smalter(){
        random = new SplittableRandom();
    }

    /**
     * Salts the values in the output ArrayList
     * @param saltValue    How much you want to be subtracted or added to each data point
     */
    public void salter(ArrayList<Double> outputs, int saltValue){
        //Declare the integer we're going to be salting with and whether it's negative or positive.
        int saltInt;
        int negativeOrPositive;

        //Loop through entire ArrayList and salt each data point
        for (int i = 0; i < outputs.size(); i++) {

            //I genuinely have no idea why the nextInt method is underlined in red. It still runs fine.
            negativeOrPositive = random.nextInt(2);   //Generate random numbers for the two local variables
            saltInt = random.nextInt(saltValue);

            //Set a 50% chance of the salt value being negative or positive.
            if(negativeOrPositive == 0){
                saltInt *= -1;
            }
            outputs.set(i, outputs.get(i) + saltInt);
        }
    }

    /**
     * Smooths the given dataset.
     *
     * @param range         How far to the left and right of the index you want to go for the rolling average
     * @param smoothCount   How many times you want to repeat the smoothing process
     */
    public void smoother(ArrayList<Double> outputs, int range, int smoothCount){
        //this is the base method, determines range and how many times we're smoothing this
        for (int j = 0; j < smoothCount; j++){
            for (int i = 0; i < outputs.size(); i++){
                outputs.set(i, calculatePointAverage(i, range, outputs));
            }
        }
    }

    /**
     * Calculates the average needed in a specific index for the smoother.
     *
     * @param currentY  The value of the index currently being worked on
     * @param range     The range specified from the smoother
     * @param outputs   The dataset being smoothed
     * @return          The average of the designated "group" of values that will go in the desired index
     */
    public double calculatePointAverage(int currentY, int range, ArrayList<Double> outputs){
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
            endingY = outputs.size() - 1;    //-1 since it'll be 1 greater since index starts at 0
        }

        for (int i = beginningY; i <= endingY; i++){
            total += outputs.get(i);
        }

        //Calculate average, +1 to denominator since endingY - beginningY results in a difference one less than needed
        avg = total/(endingY - beginningY + 1);
        return avg;
    }

    /**
     * Handles the issue of the values on each end of the dataset being skewed due to not having enough values on the
     * left and right for a proper rolling average by simply removing them.
     *
     * @param outputs   The Array List you would like to give a haircut
     */
    public void cutOffEnds(ArrayList<Double> outputs, int range){
        for (int i = 0; i < range; i++){
            outputs.remove(0);
            outputs.remove(outputs.size() - 1);
        }
    }
}
