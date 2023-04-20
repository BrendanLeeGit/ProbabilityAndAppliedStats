package ProjectII.StatsLibrary;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.lang.Math;

public class StatsLibrary {
    final double e = 2.7182818;
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
     * Returns the probability of an event happening with hypergeometric distribution.
     * This is used when a problem consists of selecting n items from a population
     * without replacement. Additionally, all selections must be equally likely.
     *
     * @param N Total objects
     * @param n How many objects are being chosen
     * @param r How many of a certain object type there are
     * @param y How many of r do we want
     * @return  BigDecimal of the probability of the event occurring
     */
    public BigDecimal hypergeometricDistribution(int N, int n, int r, int y){
        //Going to structure it as the numerator and denominator then properly divide
        BigDecimal numerator =  new BigDecimal(combinations(r, y));
        numerator = numerator.multiply(new BigDecimal(combinations(N - r, n - y)));
        BigDecimal denominator = new BigDecimal(combinations(N, n));

        //rounds to the fifth decimal place, adjust scale below if needed
        return numerator.divide(denominator, 5, RoundingMode.HALF_UP);
    }

    /**
     * Returns the probability of an event occurring with Poisson Distribution.
     * This distribution corresponds to a model where incidents occur independently
     * in continuous time at a constant rate.
     * Ex. # of phone calls every hour for a business.
     *
     * @param lambda The rate of a success
     * @param y      How many successes you're looking for
     * @return       Probabiltity of the proposed event occurring
     */
    public double poissonDistribution(double lambda, int y){
        /*
        I was going to use BigDecimal for this as well, but it seems there's no exponent function in it
        that allows anything other than an int in the class. Though, it seems the Cornell University Library
        has an implementation that does allow it.
         */
        return (Math.pow(lambda, y) / factorial(y).doubleValue() * Math.pow(e, lambda * -1));
    }

    public double chebyshevsTheorem(double lowerBound, double upperBound, double mean, double standardDeviation){

    }

}
