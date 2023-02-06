package SetOperationsAndStatsLibrary;
import java.util.ArrayList;
public class Sorter {
    /**
     * Sorts inputted ArrayList of doubles into ascending order
     * @param inputArrayList
     */
    public void sort(ArrayList<Double> inputArrayList){
        //initialize first value as the starting point and lowest number so far
        int startingIndex = 0;
        double smallestValue;
        int smallestValueIndex = 0;

        while(startingIndex < inputArrayList.size() - 1) {
            smallestValue = (inputArrayList.get(startingIndex));
            smallestValueIndex = startingIndex;
            //finds the index of the smallest number
            for (int i = startingIndex; i < inputArrayList.size() - 1; i++) {
                if (inputArrayList.get(i + 1) <= smallestValue){
                    smallestValue = inputArrayList.get(i + 1);
                    smallestValueIndex = i + 1;
                }
            }
            //Moves the smallest number to the left where it should be
            inputArrayList.remove(smallestValueIndex);
            inputArrayList.add(startingIndex, smallestValue);
            startingIndex++;
        }
    }
}
