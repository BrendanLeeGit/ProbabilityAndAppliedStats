import java.util.ArrayList;
import java.util.Random;
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

    public void populateArrayList(){
        if(!fullSet.isEmpty()) {
            fullSet.clear();
        }
        for (int i = 10; i > 0; i--){
            fullSet.add((double)i);
        }
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
        StatsLibrary stat = new StatsLibrary();
        System.out.println("Mean: " + stat.mean(fullSet));
        System.out.println("Median: " + stat.median(fullSet));
        System.out.println("Mode: " + stat.mode(fullSet));
    }
    public void testStandardDeviation(){
        System.out.println("Standard Deviation: " + stat.standardDeviation(fullSet));

    }

}
