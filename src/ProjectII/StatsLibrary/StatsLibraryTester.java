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
        testChebyshevsTheorem();
    }

    public void testHypergeometricDistribution(){
        System.out.println("Hypergeometric Distribution test: " + stat.hypergeometricDistribution(20, 5, 6, 4));
    }

    public void testPoissonDistribution(){
        System.out.println("Poisson Distribution test: " + stat.poissonDistribution(6, 5));
    }

    public void testChebyshevsTheorem(){
        System.out.println("Chebyshevs test: " + stat.chebyshevsTheorem(123,179,151, 14));
    }
}



