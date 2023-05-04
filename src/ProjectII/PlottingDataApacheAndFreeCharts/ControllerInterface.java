package ProjectII.PlottingDataApacheAndFreeCharts;

import java.io.IOException;

public interface ControllerInterface {
    void plot(String x1, String x2, String increment, String m, String b, String saltValue, String smoothRange,
              String smoothCout) throws IOException;
    void export() throws IOException;
    void clear();
}
