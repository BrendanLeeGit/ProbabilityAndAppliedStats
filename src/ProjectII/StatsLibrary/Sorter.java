package ProjectII.StatsLibrary;
import java.util.ArrayList;

public class Sorter {
    /**
     * Sorts inputted ArrayList of doubles into ascending order
     * @param inputArrayList    The inputted ArrayList that needs to be sorted
     */
    public void sort(ArrayList<Double> inputArrayList){
        //initialize first value as the starting point and lowest number so far
        int startingIndex = 0;
        double smallestValue;
        int smallestValueIndex;

        //Begin loop to sort, keep going index by index until you reach the end of the ArrayList
        while(startingIndex < inputArrayList.size() - 1) {
            smallestValue = (inputArrayList.get(startingIndex));
            smallestValueIndex = startingIndex;
            //Finds the smallest number and its index
            for (int i = startingIndex; i < inputArrayList.size() - 1; i++) {
                if (inputArrayList.get(i + 1) <= smallestValue){
                    smallestValue = inputArrayList.get(i + 1);
                    smallestValueIndex = i + 1;
                }
            }
            //Moves the smallest number to the left where it should be
            inputArrayList.remove(smallestValueIndex);
            inputArrayList.add(startingIndex, smallestValue);
            //Increments index so we don't go over the already sorted portion again
            startingIndex++;
        }
    }
}
