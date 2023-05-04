package ProjectII.PlottingDataApacheAndFreeCharts;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Random;

/**
 * Going to test using a window and calculating the average of that window for the rolling average smoother
 */
public class TestingSmoother {
    public static void main(String[] args){
        double[] testArray = new double[100];
        double[] smoothedArray = new double[100];
        Random r = new Random();

        //populate the intitial array
        for (int i = 0; i < 100; i++){
            testArray[i] = r.nextDouble() * 100;
            System.out.println(testArray[i]);
        }

        //create the window with a range of 5
        DescriptiveStatistics descStat = new DescriptiveStatistics(5);

        for (int i = 0; i < 100; i++){
            descStat.addValue(testArray[i]);
            smoothedArray[i] = descStat.getMean();
        }

        System.out.println("\nSmoothed array:");
        for (int i = 0; i < 100; i++){
            System.out.println(smoothedArray[i]);
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Poop", "poo");

    }
}
