package ProjectI.SameBirthday;

import java.util.HashMap;
import java.util.Random;
public class CalcProbability {
    private Person[] people;
    private HashMap<Integer, Boolean> day;

    /**
     * Initializes the hashmap for birthdays and the array of people.
     * @param peopleCount   The amount of people whose birthdays you're testing
     */
    public CalcProbability(int peopleCount){
        people = new Person[peopleCount];
        day = new HashMap<>();
    }

    /**
     * Sets all hashmap values from 0-364 to false.
     */
    private void resetDayCount(){
        for (int i = 0; i < 365; i++){
            day.put(i, false);
        }
    }

    /**
     * Assigns a random integer from 0-364 to each index in people[].
     */
    private void populatePeople(){
        Random rand = new Random();
        for (int i = 0; i < people.length; i++){
            people[i] = new Person(rand.nextInt(365));
        }
    }

    /**
     * Does the actual work of calculating the probability.
     *
     * @param runs  How many times you want to repeat the experiment for a more accurate percentage
     * @return      Returns the percentage as a double of how often a run resulted in a repeated birthday
     */
    public double calculateProbability(int runs){
        double repeats = 0;
        for (int i = 0; i < runs; i++) {
            //need to reset the people and the day count for every run to simulate a new group of people each time
            resetDayCount();
            populatePeople();
            //go through entire person array, set each person's birthday int to true on the hashmap
            for (Person x : people) {
                if (!day.get(x.getDay())) {
                    day.put(x.getDay(), true);
                } else {
                    //if someone's birthday is already true, there's a repeat, increment repeats and break loop
                    repeats++;
                    break;
                }
            }
        }
        return repeats/runs;
    }

    /**
     * This method is simply to test whether my hypothesis about the formula was correct or not.
     * Ideally it would use BigDecimal to give a more exact answer, but as a way to test my hypothesis it works fine.
     *
     * @param people    The number of people in the experiment
     * @return          The approximate percentage chance that there will be a repeated birthday with the inputted
     *                      amount of people
     */
    public double hypothesisFormula(int people){
        /*
        I'm speculating that you can calculate the percentage with: 364!/(365^(numberOfPeople))
            The logic behind it is that with two people, you have a 364/365 chance of a repeating birthday
            With three, you have a 363/365 since the first two for sure don't have the same birthday
            With four, it's 362/365 etc etc.
            Simply multiply the events of the increasing number of people, as the nontaken days shrink
            one by one.
            However, I don't feel like using BigDecimal, so instead of just using the above formula
            I do the division by 365 in each step to keep values small.
            There will be some inaccuracy, but it shouldn't make too much of a difference.
         */
        double result = 1;
        for (int i = 0; i < people - 1; i++){
            result *= (double)(364 - i)/(double)365;
        }
        return result * -1 + 1;
    }
}
