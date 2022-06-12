/**
 * This is a driver file for Vehicle and Car classes.
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class Driver {
    /**
     * Tests all the classes.
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        // Car
        String[] list = {"Owen", null, "Chloe", "Jack", null, null};
        Car c1 = new Car("CAR1", 50, list, 5.0, 25.50, 100);
        Car c2 = new Car("CAR2", 10, 100);
        String[] a1 = {"Nathan", "Brian"};
        System.out.println(c1.addPassenger(25, a1));
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c1.equals(c2));

        // Bus
        Bus b1 = new Bus("BUS1", 50, "Atlanta", 5);
        Bus b2 = new Bus("BUS2", "Georgia");

        String[] list2 = {"Owen", "Adam", "Chloe", "Jack", "Owen", "Jackie", "Tim", "Bob"};
        System.out.println(b1.addPassenger(25, list2));
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b1.equals(b2));


    }
}