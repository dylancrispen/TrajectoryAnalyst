




import java.util.*;

/**
 * @name Analyzer
 * @brief Performs all simulation calculations
 * @detail Analyzer performs a basic trajectory analysis ignoring drag for a given
 * length of time. For now, the user chooses the max length of time.
 * */
public class Analyzer {
    private double[] xpositions;
    private double[] ypositions;
    private double[] xvelocities;
    private double[] yvelocities;

    private PropertyManager pm;

    private double time_scale;
    private int max_time;

    Analyzer(double dt, PropertyManager propertyManager) {
        time_scale = dt;
        pm = propertyManager;

        max_time = getMaxTime();

        int ARRAY_SIZE = (int)(max_time/dt);
        if(ARRAY_SIZE<=0) ARRAY_SIZE=10;

        xpositions = new double[ARRAY_SIZE];
        ypositions = new double[ARRAY_SIZE];
        xvelocities = new double[ARRAY_SIZE];
        yvelocities = new double[ARRAY_SIZE];
    }


    public void initializeSimulation(){
        xpositions[0] = 0.0;
        ypositions[0] = 0.0;
        Arrays.fill(xvelocities, pm.getValue("Vx_0"));
        yvelocities[0] = pm.getValue("Vy_0");
    }

    public void runSimulation(){
        for(int i=1; i < xpositions.length; i++){
            double x_0 = xpositions[i-1];
            xpositions[i]=x_0+xvelocities[i]*time_scale;

            double y_0 = ypositions[i-1];
            double vy_0 = yvelocities[i-1];

            double accel = -9.81;

            yvelocities[i]=vy_0+accel*time_scale;
            ypositions[i]=y_0+yvelocities[i]*time_scale;
        }
    }


    private int getMaxTime(){
        Scanner input = new Scanner(System.in);
        System.out.println("How long would you like the simulation to run for? (seconds)");
        int max_time = input.nextInt();

        if(max_time>0){
            return max_time;
        } else {
            throw new IllegalArgumentException("ERROR: Max time must be greater than 0");
        }
    }

    public double[][] getPositions(){
        return new double[][]{xpositions,ypositions};
    }

    public double[][] getVelocities(){
        return new double[][]{xvelocities,yvelocities};
    }

}
