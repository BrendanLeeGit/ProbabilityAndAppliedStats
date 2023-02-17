package SameBirthday;

public class CalcProbabilityTester {
    public static void main(String[] args){
        CalcProbability c = new CalcProbability(27);
        System.out.println("Chance of a repeated birthday with 27 people: " + c.calculateProbability(10000));
        System.out.println("Chance calculated with hypothesis: " + c.hypothesisFormula(27));
    }
}
