package SetOperationsAndStatsLibrary;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StatsLibraryTester stat = new StatsLibraryTester();
        stat.testEverything();

        //build new arraylist to test custom sort
        ArrayList<Double> sortTestArrayList = new ArrayList<>();

        sortTestArrayList.add((double)3);
        sortTestArrayList.add((double)7);
        sortTestArrayList.add((double)5);
        sortTestArrayList.add((double)2);
        sortTestArrayList.add((double)3);
        sortTestArrayList.add((double)7);
        sortTestArrayList.add((double)5);
        sortTestArrayList.add((double)2);
        sortTestArrayList.add((double)10);
        sortTestArrayList.add((double)2);
        sortTestArrayList.add((double)25);

        Sorter sort = new Sorter();
        sort.sort(sortTestArrayList);
        for (Double aDouble : sortTestArrayList) {
            System.out.println(aDouble);
        }

    }
}
