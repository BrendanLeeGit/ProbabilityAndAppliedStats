package SetOperationsAndStatsLibrary;
import java.util.*;
public class StatsLibrary {

    /**
     * Returns the mean of the inputted arraylist
     *
     * @param inputNumbers  the inputted ArrayList you want the mean of
     * @return              mean of the ArrayList
     */
    public double mean(ArrayList<Double> inputNumbers){
        double sum = 0;
        for(double singleElement : inputNumbers){
            sum = sum + singleElement;
        }
        return sum / inputNumbers.size();
    }

    /**
     * Returns the mode of the inputted arraylist
     *
     * @param inputNumbers  the inputted ArrayList you want the mean of
     * @return              mode of the ArrayList
     */
    public Double mode(ArrayList<Double> inputNumbers){
        //Keep track of distinct numbers and the occurrence of each
        ArrayList<Integer> occurrences = new ArrayList<>();
        ArrayList<Double> distinctDoubles = new ArrayList<>();

        //initialize first index so the loops can begin
        distinctDoubles.add(inputNumbers.get(0));
        occurrences.add(0);

        //go through set, incrementing occurrences of each distinct number and adding as needed
        for (Double inputNumber : inputNumbers) {
            for (int j = 0; j < distinctDoubles.size(); j++) {
                if (Objects.equals(inputNumber, distinctDoubles.get(j))) {
                    occurrences.set(j, occurrences.get(j) + 1);
                    break;
                }
            }
            distinctDoubles.add(inputNumber);
            occurrences.add(1);
        }

        //see which # has the most occurrences
        int highestOccurrenceIndex = 0;
        for (int i = 0; i < distinctDoubles.size() - 1; i++){
            if (occurrences.get(i + 1) > occurrences.get(i)){
                highestOccurrenceIndex = i + 1;
            }
        }

        //if multiple numbers have same # of occurrences, then there's no mode and return null
        int repetitionCount = 0;
        for (Integer occurrence : occurrences) {
            if (Double.compare(occurrences.get(highestOccurrenceIndex), occurrence) == 0) {
                repetitionCount++;
            }
        }

        //if it repeats more than once then there's no mode
        if (repetitionCount > 1){
            return null;
        }

        return distinctDoubles.get(highestOccurrenceIndex);
    }

    public double median(ArrayList<Double> inputNumbers){
        Sorter sort = new Sorter();
        //Collections.sort(inputNumbers);   //Collections sort
        sort.sort(inputNumbers); //personal sort
        if (inputNumbers.size() % 2 == 0){
            int leftHalf = inputNumbers.size() / 2 - 1;
            int rightHalf = leftHalf + 1;
            return ((inputNumbers.get(leftHalf) + inputNumbers.get(rightHalf)) / 2);
        }
        int index = inputNumbers.size() / 2;
        return inputNumbers.get(index);
    }

    public double standardDeviation(ArrayList<Double> someList){
        double mean = mean(someList);
        double sumOfSquares = 0;
        for (double d : someList){
            d = d - mean;
            sumOfSquares = sumOfSquares + d * d;
        }
        return Math.sqrt(sumOfSquares/(double)(someList.size() - 1));
    }

    public double combinations(int n, int r){
        return (factorial(n) / (factorial(r) * factorial(n-r)));
    }

    public double permutations(int n, int r){
        return (factorial(n) / (factorial(n-r)));
    }

    public double factorial(int n){
        double result = 1;
        for(int i = n; i > 0; i--){
            result *= i;
        }
        return result;
    }
}
