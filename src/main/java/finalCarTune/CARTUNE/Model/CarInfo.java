package finalCarTune.CARTUNE.Model;

public class CarInfo {

    // Attributes
    private int city_mpg;
    private String carClass;
    private int combination_mpg;
    private int cylinders;
    private double displacement;
    private String drive;
    private String fuel_type;
    private int highway_mpg;
    private String make;
    private String model;
    private String transmission;
    private int year;
    private String color; // added for color field
    private String type; // added for type field

    

    @Override
    public String toString() {
        return "CarInfo{" +
                "city_mpg=" + city_mpg +
                ", carClass='" + carClass + '\'' +
                ", combination_mpg=" + combination_mpg +
                ", cylinders=" + cylinders +
                ", displacement=" + displacement +
                ", drive='" + drive + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", highway_mpg=" + highway_mpg +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", transmission='" + transmission + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    // Getters and Setters for each field

    public int getCity_mpg() {
        return city_mpg;
    }

    public void setCity_mpg(int city_mpg) {
        this.city_mpg = city_mpg;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getCombination_mpg() {
        return combination_mpg;
    }

    public void setCombination_mpg(int combination_mpg) {
        this.combination_mpg = combination_mpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public int getHighway_mpg() {
        return highway_mpg;
    }

    public void setHighway_mpg(int highway_mpg) {
        this.highway_mpg = highway_mpg;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
