import java.util.ArrayList;

public class Sorter {
    //Pretty inefficient, does the job tho lol
    public void sort(ArrayList<Double> inputArrayList){

        //initialize first value as the starting point and lowest number so far
        int startingIndex = 0;
        double smallestValue;
        int smallestValueIndex = 0;

        while(startingIndex < inputArrayList.size()) {
            smallestValue = (inputArrayList.get(startingIndex));
            smallestValueIndex = startingIndex;
            //finds the index of the smallest number
            for (int i = startingIndex; i < inputArrayList.size() - 1; i++) {
                if (inputArrayList.get(i + 1) <= inputArrayList.get(i)){
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
