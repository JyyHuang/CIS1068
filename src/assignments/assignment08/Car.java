package assignments.assignment08;

public class Car {
    private String make;
    private String model;
    private int year;
    private double MPG;
    private double milesDriven;
    private double fuelCapacity;
    private double fuelRemaining;

    public Car(String make, String model, int year, double MPG, double milesDriven, double fuelCapacity, double fuelRemaining){
        this.make = make;
        this.model = model;
        this.year = year;
        this.MPG = MPG;
        this.milesDriven = milesDriven;
        this.fuelCapacity = fuelCapacity;
        this.fuelRemaining = fuelRemaining;
    }

    public void fillTank(double g){
        fuelRemaining += g;
        if (fuelRemaining > fuelCapacity){
            fuelRemaining = fuelCapacity;
        }
    }

    public void drive(double m){
        milesDriven += m;
        fuelRemaining -= m/MPG;
    }

    public String toString(){
        return "make: " + make + "\r\n" +
        "model: " + model + "\r\n" +
        "year: " + year + "\r\n" +
        "MPG: " + MPG + "\r\n" +
        "milesDriven: " + milesDriven + "\r\n" +
        "fuelCapacity: " + fuelCapacity + "\r\n" +
        "fuelRemaining: " + fuelRemaining;
    }

    public double getFuelRemaining(){
        return fuelRemaining;
    }
}
