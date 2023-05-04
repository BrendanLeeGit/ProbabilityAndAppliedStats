package ProjectII.PlottingDataApacheAndFreeCharts;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.SplittableRandom;

public class Model implements Subject{
    //Using equation slope y = mx + b
    private ArrayList<Double> outputs;
    private ArrayList<Double> inputs;
    private FileWriter fileWriter;

    private Observer observer;
    private DefaultCategoryDataset dataset;
    private JFreeChart dataChart;

    private int fileNameIncrement;
    private SplittableRandom spliRand;

    public Model(){
        outputs = new ArrayList<>();
        inputs = new ArrayList<>();
        fileNameIncrement = 0;
        spliRand = new SplittableRandom();
    }

    /**
     * Takes in a range of inputs and adds the outputs to the outputs ArrayList.
     *
     * @param x1        Lower bound of input values
     * @param x2        Upper bound of input values
     * @param increment How much you want your x to increase by for each run
     * @param m         Slope
     * @param b         Starting Y-axis
     */
    public void buildOutputArrayList(double x1, double x2, double increment, double m, double b){
        double result = 1;
        //
        while (Double.compare(x1, x2) <= 0){
            result = x1 * m + b;
            outputs.add(result);
            inputs.add(x1);
            x1 += increment;
        }
    }

    /**
     * Salts the values in the output ArrayList. This is basically the same as the salter from the CSVStuff directory.
     *
     * @param saltValue    How much you want to be subtracted or added to each data point
     */
    public void salt(int saltValue){
        if (saltValue != 0){
            //Declare the integer we're going to be salting with and whether it's negative or positive.
            int saltInt;
            int negativeOrPositive;

            //Loop through entire ArrayList and salt each data point
            for (int i = 0; i < outputs.size(); i++) {

                //I genuinely have no idea why the nextInt method is underlined in red. It still runs fine.
                negativeOrPositive = spliRand.nextInt(2);   //Generate random numbers for the two local variables
                saltInt = spliRand.nextInt(saltValue);

                //Set a 50% chance of the salt value being negative or positive.
                if(negativeOrPositive == 0){
                    saltInt *= -1;
                }
                outputs.set(i, outputs.get(i) + saltInt);
            }
        }

    }

    /**
     * Smooth the graph values using the DescriptiveStatistics class from Apache Commons.
     *
     * @param smoothRange   The size of the DescriptiveStatistics window.
     * @param smoothCount
     */
    public void smooth(int smoothRange, int smoothCount){
        for (int j = 0; j < smoothCount; j++){

            //create the window with a range of 5
            DescriptiveStatistics descStat = new DescriptiveStatistics(smoothRange);

            //The index that is set needs to be the one in the middle of the rolling average
            for (int i = 0; i < outputs.size(); i++){
                descStat.addValue(outputs.get(i));
                if (i >= smoothRange/2) {
                    outputs.set(i - (smoothRange / 2), descStat.getMean());
                }
            }
        }

        /*
        Need to cut off the beginning and ends of the x values since the rolling window doesn't seem to account for
        the fact that the ends need to be treated differently due to the lack of surrounding values. Below is the
        haircut implementation.
         */
        for (int i = 0; i < smoothRange; i++){
            outputs.remove(0);
            outputs.remove(outputs.size() - 1);
        }

    }

    /**
     * Builds the data set from the outputs array list for use in graph creation.
     */
    public void buildDataSet(){
        dataset = new DefaultCategoryDataset();
        for (int i = 0; i < outputs.size(); i++) {
            dataset.addValue(outputs.get(i), "outputs", inputs.get(i));
        }
    }

    /**
     * Takes the generated dataset and builds a line chart from the information.
     */
    public void buildLineChart(){
        dataChart = ChartFactory.createLineChart(
                "Function Output","x",
                "y", dataset, PlotOrientation.VERTICAL,
                true,true,false);
    }

    /**
     * This is a band-aid solution to the file updating problem. By changing the name each time,
     * Intellij reads it as an entirely new file and uses the updated information correctly.
     *
     * @return  The new incremented file name
     */
    private String fileNameBuilder(){
        return "C:\\ProbabilityAndAppliedStats\\LineChart" + fileNameIncrement++ + ".jpeg";
    }

    /**
     * Saves the line chart as a JPEG in the directory in order to change the icon of the JLabel displaying the graph.
     * After notifying observers that the model has changed, it then deletes the file to remove clutter and prevent the
     * issue of file changes being unrecognized.
     *
     * @throws IOException
     */
    public void saveLineChart() throws IOException {
        File fileLineChart = new File(fileNameBuilder());
        ChartUtilities.saveChartAsJPEG( fileLineChart, dataChart, 650 , 480);

        //Let View know that the model has changed
        notifyObservers();

        //Delete the newly created file
        fileLineChart.delete();
    }

    /**
     * Saves the generated LineChart.jpeg to the directory.
     *
     * @throws IOException
     */
    public void exportChart() throws IOException {
        File fileLineChart = new File("C:\\ProbabilityAndAppliedStats\\LineChart.jpeg");
        ChartUtilities.saveChartAsJPEG( fileLineChart, dataChart, 650 , 480);
    }

    public void resetArrayLists(){
        outputs.clear();
        inputs.clear();
    }

    /**
     * Generates a new image icon of the graph and returns it.
     *
     * @return  The new ImageIcon of the graph.
     */
    public ImageIcon getImage(){
        return new ImageIcon("C:\\ProbabilityAndAppliedStats\\LineChart" + (fileNameIncrement - 1) + ".jpeg");
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        observer.update(getImage());
    }
}
