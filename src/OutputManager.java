import java.util.Scanner;
/**
 * @name OutputManager
 * @brief Controls the user output post-simulation
 * */
public class OutputManager {
    private Analyzer analyst;
    private String prompt = "Select an output format:\n" +
                                  "\t1) Ending position\n" +
                                  "\t2) Highest point\n" +
                                  "\t3) Max speed\n" +
                                    "\t4) Quit";

    public OutputManager(Analyzer a){
        analyst=a;
    }

    public void promptUser(){
        System.out.println(prompt);

        double[][] positions = analyst.getPositions();
        double[][] velocities = analyst.getVelocities();

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1) {
            double xpos = positions[0][positions[0].length-1];
            double ypos = positions[1][positions[1].length-1];

            System.out.println("("+xpos+" meters, "+ypos+" meters )\n");

            promptUser();

        } else if (choice == 2) {
            double[] ypos = positions[1];
            double max = 0;

            for(double i:ypos){
                if(i>max)max=i;
            }

            System.out.println(max + " meters\n");

            promptUser();

        } else if (choice == 3) {
            double max = 0;

            for(int i=0; i<velocities[0].length;i++){
                double vsq = Math.pow(velocities[0][i],2) + Math.pow(velocities[1][i],2);
                if(Math.pow(vsq,0.5) > max) max = Math.pow(vsq,0.5);
            }

            System.out.println(max + " m/s\n");

            promptUser();

        } else {

        }
    }
}
