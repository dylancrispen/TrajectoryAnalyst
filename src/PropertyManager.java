public class PropertyManager {
    private double MASS;
    private double RADIUS;
    private final double DENSITY_AIR = 1.225; //kg/m^3
    private final double Cd = 1.00; //Assume drag coefficient = 1. laminar conditions

    PropertyManager(double m, double r){
        MASS = m; RADIUS = r;
    }

    public double getValue(String tag){
        if(tag == "mass"){
            return MASS;
        } else if(tag.equals("radius")) {
            return RADIUS;
        } else if(tag.equals("rho")) {
            return DENSITY_AIR;
        } else if(tag.equals("Cd")){
            return Cd;
        } else {
            throw new IllegalArgumentException("ERROR: tag not found");
        }
    }
}
