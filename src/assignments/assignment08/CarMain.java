package assignments.assignment08;

public class CarMain {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car("Ford","Pinto", 1972, 17.5, 132480, 12, 8);
        cars[1] = new Car("Toyota", "Camry", 2016, 20, 60000, 14, 10);
        cars[2] = new Car("Tesla", "Model X", 2020, 15, 20000, 13, 9);

        cars[0].fillTank(2);
        cars[0].drive(10);
        System.out.println(cars[0]); 

        cars[1].fillTank(5);
        System.out.println(cars[1]); // prints the fuel capacity since it is over the max

        System.out.println(cars[2].getFuelRemaining()); // prints 9
    }
}
