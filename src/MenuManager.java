import java.util.Scanner;


/**
 * @name MenuManager
 * @brief Controls the user input for the beginning stages of the simulation
 * @detail MenuManager is a singleton class primarily used to fill the
 * properties contained in the PropertyManager field.
 * */
public class MenuManager {
    //Singleton Pointer
    private static MenuManager menu_instance = null;

    //Private variables
    private static PropertyManager properties;

    //String prompts
    private String menu = "Please select a ball for the simulation:" +
            "\n\t1) Soccer Ball" +
            "\n\t2) Baseball";
    private String prompt1 = "Enter the initial velocity in the x-direction (m/s):";
    private String prompt2 = "Enter the initial velocity in the y-direction (m/s):";

    //Constants: masses in kilograms, radii in meters
    private final double MASS_SOCCER = 0.43;
    private final double RADIUS_SOCCER = 0.11;
    private final double MASS_BASEBALL = 0.145;
    private final double RADIUS_BASEBALL = 0.07265;

    /**
     * @brief Sets the properties of the PropertyManager field
     * @detail Using java.util.Scanner, the MenuManager gives the user two preset
     * projectiles with which it sets its parameters. It also takes input for initial
     * velocity for a 2-D simulation.
     * @return The initialized property object
     */
    public PropertyManager setProperties() {
        printMenu();

        Scanner in = new Scanner(System.in);
        int choice = -1;

        choice = in.nextInt();
        if(choice == 1) {
            properties = new PropertyManager(MASS_SOCCER, RADIUS_SOCCER);

        } else if (choice == 2) {
            properties = new PropertyManager(MASS_BASEBALL, RADIUS_BASEBALL);

        } else {
            System.out.println("That choice is not supported. Please try again\n\n");
            setProperties();
        }

        System.out.println(prompt1);
        double init_x = in.nextDouble();
        properties.setValue("Vx_0",init_x);

        System.out.println(prompt2);
        double init_y = in.nextDouble();
        properties.setValue("Vy_0",init_y);

        System.out.println(properties.toString());

        return properties;
    }


    private MenuManager(){
        System.out.println("Creating new Menu Manager");
    }


    public static MenuManager instance() {
        if(menu_instance == null){
            menu_instance = new MenuManager();
        }
        return menu_instance;
    }


    private void printMenu(){
        System.out.println(menu);
    }
}
