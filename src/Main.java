/**
 * @author Brendan
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StatsLibraryTester stat = new StatsLibraryTester();
        stat.populateArrayList();
        stat.testStandardDeviation();
        stat.testComplement();
        stat.testIntersection();
        stat.testUnion();
        stat.testMMM();
        //build new arraylist to test custom sort
        ArrayList<Double> sortTestArrayList = new ArrayList<>();
        sortTestArrayList.add((double)3);
        sortTestArrayList.add((double)7);
        sortTestArrayList.add((double)5);
        sortTestArrayList.add((double)2);
        sortTestArrayList.add((double)3);
        Sorter sort = new Sorter();
        sort.sort(sortTestArrayList);
        for (Double aDouble : sortTestArrayList) {
            System.out.println(aDouble);
        }
        StatsLibrary sta = new StatsLibrary();
        System.out.println(sta.factorial(10));
        System.out.println(sta.permutations(6, 2));
        System.out.println(sta.combinations(6, 2));

    }
}
