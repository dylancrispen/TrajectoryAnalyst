public class PropertyManager {
    private double MASS;
    private double RADIUS;
    private double Vx_0;
    private double Vy_0;

    PropertyManager(double m, double r){
        MASS = m; RADIUS = r;
    }

    public void setValue(String tag, double value){
        if(tag.equals("mass")){
            MASS = value;
        } else if(tag.equals("radius")) {
            RADIUS = value;
        } else if(tag.equals("Vx_0")){
            Vx_0 = value;
        } else if(tag.equals("Vy_0")){
            Vy_0 = value;
        } else {
            throw new IllegalArgumentException("ERROR: tag not found");
        }
    }

    public double getValue(String tag){
        if(tag.equals("mass")){
            return MASS;
        } else if(tag.equals("radius")) {
            return RADIUS;
        } else if(tag.equals("Vx_0")){
            return Vx_0;
        } else if(tag.equals("Vy_0")){
            return Vy_0;
        } else {
            throw new IllegalArgumentException("ERROR: tag not found");
        }
    }

    public String toString(){
        return "Mass: " + MASS + " kg\n" +
                "Radius: " + RADIUS + " m\n" +
                "Vx_0 = " + Vx_0 + " m/s\n" +
                "Vy_0 = " + Vy_0 + " m/s\n";
    }
}
