package SameBirthday;

import java.util.HashMap;
import java.util.Random;
public class CalcProbability {
    Person[] people;
    HashMap<Integer, Boolean> day;

    public CalcProbability(int peopleCount){
        people = new Person[peopleCount];
        day = new HashMap<>();
        resetDayCount();
    }

    public void resetDayCount(){
        for (int i = 0; i < 365; i++){
            day.put(i, false);
        }
    }

    public void populatePeople(){
        Random rand = new Random();
        for (int i = 0; i < 27; i++){
            people[i] = new Person(rand.nextInt(365));
        }
    }

    public double calculateProbability(int runs){
        double repeats = 0;
        for (int i = 0; i < runs; i++) {
            resetDayCount();
            populatePeople();
            for (Person x : people) {
                if (!day.get(x.getDay())) {
                    day.put(x.getDay(), true);
                } else {
                    repeats++;
                    break;
                }
            }
        }
        return repeats/runs;
    }

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
         */
        double result = 1;
        for (int i = 0; i < people - 1; i++){
            result *= (double)(364 - i)/(double)365;
        }
        return result * -1 + 1;
    }
}
