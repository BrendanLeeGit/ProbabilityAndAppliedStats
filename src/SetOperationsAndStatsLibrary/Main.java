package SetOperationsAndStatsLibrary;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StatsLibraryTester stat = new StatsLibraryTester();
        //stat.testEverything();

        StatsLibrary s = new StatsLibrary();
        System.out.println(s.factorial(8));
        System.out.println(s.factorial(90));
        System.out.println(s.factorial(100));
        System.out.println(s.factorial(110));
        System.out.println(s.factorial(120));
        //System.out.println(s.combinations())



    }
}
