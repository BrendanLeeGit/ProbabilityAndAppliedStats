package ProjectII.StatsLibrary;


public class StatsLibraryTester {

    private StatsLibrary stat;

    public StatsLibraryTester(StatsLibrary stat){
        this.stat = stat;
    }

    /**
     * Tests every single function built into the library that matters.
     */
    public void testEverything(){
        testHypergeometricDistribution();
        testPoissonDistribution();
    }

    public void testHypergeometricDistribution(){
        System.out.println(stat.hypergeometricDistribution(20, 5, 6, 4));
    }

    public void testPoissonDistribution(){
        System.out.println(stat.poissonDistribution(6, 5));
    }
}



