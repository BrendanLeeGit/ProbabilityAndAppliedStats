package ProjectII.StatsLibrary;

public class Main {
    public static void main(String[] args) {
        StatsLibrary stat = new StatsLibrary();
        StatsLibraryTester statTest = new StatsLibraryTester(stat);
        statTest.testEverything();
    }
}
