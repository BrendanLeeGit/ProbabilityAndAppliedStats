package SameBirthday;

public class CalcProbabilityTester {
    public static void main(String[] args){
        CalcProbability c = new CalcProbability(23);
        System.out.println(c.calculateProbability(90000000));
        System.out.println(c.hypothesisFormula(23));
        /*
        Answer to 2.20:
            a. There's a 33.3% chance of a door having the prize
            b.
                i. 33.3%
                ii. She won't get the prize.
                iii. She'll get the prize.
                iv. 66.75%
                v. Switch to the other curtain.
         */
    }
}
