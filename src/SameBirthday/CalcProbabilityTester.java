package SameBirthday;

public class CalcProbabilityTester {
    public static void main(String[] args){
        CalcProbability c = new CalcProbability(27);
        c.populatePeople();
        System.out.println(c.calculateProbability(10000));
        System.out.println(c.hypothesisFormula(27));
    }
}
