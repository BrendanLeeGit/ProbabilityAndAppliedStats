package SetOperationsAndStatsLibrary;
import java.util.ArrayList;
import java.util.Objects;
import java.math.BigInteger;

public class StatsLibrary {

    /**
     * Returns the mean of the inputted arraylist.
     *
     * @param inputNumbers  the inputted ArrayList you want the mean of
     * @return              mean of the ArrayList
     */
    public double mean(ArrayList<Double> inputNumbers){
        double sum = 0;
        //Iterate through ArrayList adding each element to the sum
        for(double singleElement : inputNumbers){
            sum = sum + singleElement;
        }
        return sum / inputNumbers.size();
    }

    /**
     * Returns the mode of the inputted arraylist.
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

    /**
     * Returns median of the inputted ArrayList.
     * Sorts the ArrayList as well, so need a different method if you want to keep the original intact.
     *
     * @param inputNumbers The ArrayList you want the median of
     * @return             The median of the ArrayList
     */
    public double median(ArrayList<Double> inputNumbers){
        //Begin by sorting ArrayList
        //Note: To make a method that doesn't mess with the original AL, simply copy elements to a new AL with a loop
        Sorter sort = new Sorter();
        sort.sort(inputNumbers);
        //If the ArrayList size is even, take the average of the middle two indices' values
        if (inputNumbers.size() % 2 == 0){
            int leftHalf = inputNumbers.size() / 2 - 1;
            int rightHalf = leftHalf + 1;
            return ((inputNumbers.get(leftHalf) + inputNumbers.get(rightHalf)) / 2);
        }
        //If it's odd, just select the index in the middle
        int index = inputNumbers.size() / 2;
        return inputNumbers.get(index);
    }

    /**
     * Finds the standard deviation of an inputted ArrayList of Doubles.
     *
     * @param someList The ArrayList you want the standard deviation for
     * @return         The standard deviation of the inputted ArrayList
     */
    public double standardDeviation(ArrayList<Double> someList){
        //Find mean of the ArrayList
        double mean = mean(someList);
        //Follow the equation
        double sumOfSquares = 0;
        for (double d : someList){
            d = d - mean;
            sumOfSquares = sumOfSquares + d * d;
        }
        return Math.sqrt(sumOfSquares/(double)(someList.size() - 1));
    }

    /**
     * Return the probability for a combinations problem.
     * Reminder that combinations is used when the order doesn't actually matter.
     * Generally problems require that you divide one result of a combination(n, r) call by another one.
     *
     * @param n Number of distinct objects total
     * @param r The amount of objects being taken
     * @return  Returns the decimal probability of the specific event occurring
     */
    public String combinations(int n, int r){
        return (factorial(n).divide((factorial(r).multiply(factorial(n-r))))).toString();
    }

    /**
     * Returns the probability for a permutations problem.
     * Reminder that permutations is used when the order does matter.
     *
     * @param n Number of distinct objects total
     * @param r The amount of objects being taken
     * @return  Returns the decimal probability of the specific event occurring
     */
    public String permutations(int n, int r){
        return factorial(n).divide((factorial(n-r))).toString();
    }

    /**
     * Finds the value of the factorial of a number
     * Ex. 6! becomes factorial(6)
     *
     * @param n the integer you want the factorial of
     * @return  Returns the resulting factorial as a BigInteger
     */
    public BigInteger factorial(int n){
        //no need to go through a loop if n is 0
        if (n == 0){
            return BigInteger.valueOf(n);
        }
        BigInteger result = BigInteger.valueOf(1);
        for(int i = n; i > 0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Finds the... you guessed it. Binomial distribution!
     * This is for an exact number of wanted successes. See the binomialDistribution() with four parameters to handle
     * a "at most" or "at least" case.
     *
     * @param n Number of trials
     * @param y Number of wanted successes
     * @param p Chance of a success
     * @return  Probability of this situation occuring.
     */
    public double binomialDistribution(int n, int y, double p){
        double q = 1 - p;
        return Double.parseDouble(combinations(n, y)) * Math.pow(p, y) * Math.pow(q, n - y);
    }

    /**
     * Here lies the binomial distribution that handles those "at most" cases
     * n1 and n2 act as the range for the binomial distributions that need to added together
     * For example, for a problem like "at most 3", n1 would be 1 and n2 would be 3.
     * If it's a problem for "at least", find the complement of the "at most" that this method returns.
     * AKA, subtract this result from 1.
     *
     * @param n The number of trials
     * @param y1 The lesser endpoint of the interval of successes
     * @param y2 The greater endpoint of the interval of successes
     * @param p The chance of success
     * @return Returns the percentage chance of this situation occurring
     */

    public double binomialDistribution(int n, int y1, int y2, double p){
        double result = 0;
        //safe guard for if someone enters in a higher y2, though throwing an exception would likely be better
        if (y2 < y1){
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        //call the original binomialDistribution method multiple times and add up the results
        for (int i = y1; i <= y2; i++){
            result += binomialDistribution(n, i, p);
        }
        return result;
    }

    public double geometricDistribution(int y, double p){
        double q = 1 - p;
        return Math.pow(q, y - 1) * p;
    }
}
