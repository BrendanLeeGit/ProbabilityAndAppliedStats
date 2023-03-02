package SetOperationsAndStatsLibrary;
import java.util.ArrayList;
public class StatsLibraryTester {
    SetOperator<Double> so;
    ArrayList<Double> fullSet;
    ArrayList<Double> a;
    ArrayList<Double> b;
    ArrayList<Double> answer;
    StatsLibrary stat;

    public StatsLibraryTester(){
        so = new SetOperator<>();
        stat = new StatsLibrary();
        fullSet = new ArrayList<>();
    }

    /**
     * Tests every single function built into the library that matters.
     */
    public void testEverything(){
        populateArrayList();
        testMMM();
        testStandardDeviation();
        testComplement();
        testIntersection();
        testUnion();
        testCombination(2, 5);
        testPermutation(2,5);
        testFactorial();
        testBinomialDistribution();
        testGeometricDistribution();
    }

    /**
     * Clears the ArrayLists in the object and adds default tester values to them instead
     */
    public void populateArrayList(){
        if(!fullSet.isEmpty()) {
            fullSet.clear();
        }
        for (int i = 10; i > 0; i--){
            fullSet.add((double)i);
        }
        //Insert subset examples from in class: a = {2, 4, 6}, b = {1, 2, 5, 7, 9}
        a = new ArrayList<>();
        a.add((double)2);
        a.add((double)4);
        a.add((double)6);
        b = new ArrayList<>();
        b.add((double)1);
        b.add((double)2);
        b.add((double)5);
        b.add((double)7);
        b.add((double)9);
    }

    /**
     * Sets ArrayLists a, b, and fullSet to the inputted ArrayLists
     * This method does NOT create new ArrayLists, it only passes the references
     *
     * @param a         A subset of the full set
     * @param b         A subset of the full set
     * @param fullSet   The full complete set of numbers
     */
    public void setArrayLists(ArrayList<Double> a, ArrayList<Double> b, ArrayList<Double> fullSet){
        this.a = a;
        this.b = b;
        this.fullSet = fullSet;
    }

    public void testUnion(){
        System.out.println("Testing Union:");
        answer = so.union(a, b);
        for (Double value : answer) {
            System.out.println(value);
        }
    }

    public void testComplement(){
        System.out.println("Testing Complement:");
        answer = so.complement(fullSet, a);
        for (Double aDouble : answer) {
            System.out.println(aDouble);
        }
    }

    public void testIntersection(){
        System.out.println("Testing Intersection:");
        answer = so.intersection(a, b);
        for (Double aDouble : answer) {
            System.out.println(aDouble);
        }
    }

    public void testMMM(){
        System.out.println("Testing Mean Median and Mode:");
        System.out.println("Mean: " + stat.mean(fullSet));
        System.out.println("Median: " + stat.median(fullSet));
        System.out.println("Mode: " + stat.mode(fullSet));
    }

    public void testStandardDeviation(){
        System.out.println("Standard Deviation: " + stat.standardDeviation(fullSet));

    }

    public void testCombination(int n, int r){
        System.out.println("Combinations: " + stat.combinations(6, 2));
    }

    public void testPermutation(int n, int r){
        System.out.println("Permutations: " + stat.permutations(6, 2));
    }

    public void testFactorial(){
        System.out.println("Factorial: " + stat.factorial(100));
    }

    public void testBinomialDistribution(){
        System.out.println("Basic Binomial Distribution: " + stat.binomialDistribution(10, 4, .15));
        System.out.println("BD for \"at least\" cases: " + stat.binomialDistribution(10, 1, 4, .15));
    }

    public void testGeometricDistribution(){
        System.out.println("Geometric distribution: " + stat.geometricDistribution(2,.01));
    }
}
