import java.awt.*;

/**
 *
 *
 *
 *
 *
 */
public class ProgramDriver {
    private static ProgramDriver driver_instance = null;

    private PropertyManager properties;
    private MenuManager menu;

    private ProgramDriver(){
        System.out.println("Creating ProgramDriver");
        menu = MenuManager.instance();
    }

    public static ProgramDriver instance(){
        if(driver_instance == null){
            driver_instance = new ProgramDriver();
        }
        return driver_instance;
    }


    public void execute() {
        System.out.println("Executing Trajectory Program...\n");

        properties = menu.setProperties();

        Analyzer analyzer = new Analyzer(0.1 , properties);
        analyzer.initializeSimulation();
        analyzer.runSimulation();

        OutputManager output = new OutputManager(analyzer);
        output.promptUser();
    }




}
