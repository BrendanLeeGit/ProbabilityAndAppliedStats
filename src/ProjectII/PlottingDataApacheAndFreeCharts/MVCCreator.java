package ProjectII.PlottingDataApacheAndFreeCharts;
import java.io.IOException;

public class MVCCreator {
    public void run() throws IOException {
        Model functionOutput = new Model();
        Controller controller = new Controller(functionOutput);
        View view = new View(controller, functionOutput);
        functionOutput.registerObserver(view);
        view.run();
    }
}
