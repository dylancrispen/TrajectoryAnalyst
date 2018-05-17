import java.awt.*;

/**
 * @name ProgramDriver
 * @brief Controls the execution order of the program
 * @detail ProgramDriver is a singleton class with one public method, execute().
 * Execute creates and manages the other objects in the program and passes data between
 * objects as needed.
 * */
public class ProgramDriver {
    //Singleton pointer
    private static ProgramDriver driver_instance = null;

    //Private variables
    private PropertyManager properties;
    private MenuManager menu;

    /**
     * @brief Default ctor
     * @detail Only called by the instance() method.=
     */
    private ProgramDriver(){
        System.out.println("Creating ProgramDriver");
    }

    //Standard Singleton instance method
    public static ProgramDriver instance(){
        if(driver_instance == null){
            driver_instance = new ProgramDriver();
        }
        return driver_instance;
    }

    /**
     * @brief Execute method
     * @Detailed Responsible for controllng execution flow for the program.
     * Begins by creating a MenuManager and using it to set the properties
     * for the simulation. Then creates an analyzer and sets the time-step,
     * and uses it to simulate the trajectory. Finally creates an OutputManager
     * to control data output.
     */
    public void execute() {
        System.out.println("Executing Trajectory Program...\n");

        menu = MenuManager.instance();
        properties = menu.setProperties();

        Analyzer analyzer = new Analyzer(0.1 , properties);
        analyzer.initializeSimulation();
        analyzer.runSimulation();

        OutputManager output = new OutputManager(analyzer);
        output.promptUser();
    }




}
