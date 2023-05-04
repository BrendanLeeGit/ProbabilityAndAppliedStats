package ProjectII.PlottingDataApacheAndFreeCharts;

import java.io.IOException;

public interface ControllerInterface {
    public void plot(String x1, String x2, String increment, String m, String b, String saltValue, String smoothRange,
                     String smoothCout) throws IOException;
    public void export() throws IOException;
    public void clear();

}
