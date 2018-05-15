import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuManager {
    private static MenuManager menu_instance = null;
    private static PropertyManager properties;

    private String menu = "Please select a ball for the simulation:" +
            "\n\t1) Soccer Ball" +
            "\n\t2) Baseball";

    //Constants: masses in kilograms, radii in meters
    private final double MASS_SOCCER = 0.43;
    private final double RADIUS_SOCCER = 0.11;
    private final double MASS_BASEBALL = 0.145;
    private final double RADIUS_BASEBALL = 0.07265;


    private MenuManager(){
        System.out.println("Creating new Menu Manager");
    }


    public static MenuManager instance(){
        if(menu_instance == null){
            menu_instance = new MenuManager();
        }
        return menu_instance;
    }


    private void printMenu(){
        System.out.println(menu);
    }


    public PropertyManager setProperties(){
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

        return properties;
    }


}
