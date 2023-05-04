package ProjectII.PlottingDataApacheAndFreeCharts;

import java.io.IOException;

public class Controller implements ControllerInterface {
    Model model;
    public Controller(Model model){
        this.model = model;
    }

    @Override
    public void plot(String x1, String x2, String increment, String m, String b, String saltValue, String smoothRange,
                     String smoothCount) throws IOException {
        model.buildOutputArrayList(Double.parseDouble(x1), Double.parseDouble(x2), Double.parseDouble(increment),
                Double.parseDouble(m), Double.parseDouble(b));

        model.salt(Integer.parseInt(saltValue));
        model.smooth(Integer.parseInt(smoothRange), Integer.parseInt(smoothCount));

        model.buildDataSet();
        model.buildLineChart();
        model.saveLineChart();
    }

    @Override
    public void export() throws IOException {
        model.exportChart();
    }

    @Override
    public void clear(){
        model.resetArrayLists();
    }
}
