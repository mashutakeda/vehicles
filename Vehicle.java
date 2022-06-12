/**
 * Represents any vehicle to get around the city.
 *
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public abstract class Vehicle {
    private final String id;
    protected int numMiles;
    protected String[] passengers;
    private double earnings;

    /**
     * This constructor creates a vehicle with specified id, numMiles, and passenger's names.
     *
     * @param id         the identifier for the vehicle
     * @param numMiles   number of miles the vehicle has travelled
     * @param passengers the passengers aboard the vehicle. Each item in the Array represents a passenger’s name.
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        earnings = 0;
    }

    /**
     * Creates a vehicle with specified id and passenger's names.
     * @param id the identifier for the vehicle
     * @param passengers the passengers aboard the vehicle. Each item in the Array represents a passenger’s name.
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
        earnings = 0;
    }

    /**
     * Abstract method that shows whether the vehicle can drive the specified distance.
     * @param distance how long to the destination
     * @return boolean representing whether the vehicle can drive the given distance
     */
    public abstract boolean canDrive(int distance);

    /**
     * Abstract method that calculates the total cost for the vehicle to drive a given distance.
     *
     * @param distance how long to the destination
     * @return double representing the total cost for the vehicle to drive a given distance.
     */
    public abstract double calculateCost(int distance);

    /**
     * Abstract method that shows whether all customers can fit in the
     * vehicle and the vehicle can drive the given distance.
     *
     * @param distance how long to the destination
     * @param waiting the passengers aboard the vehicle.
     *                   Contains passengers' names.
     * @return boolean representing whether all customers can fit in the vehicle
     * and the vehicle can drive the given distance.
     */
    public abstract boolean addPassenger(int distance, String[] waiting);

    /**
     * Method that calculates how much the vehicle would earn and number of miles it drove with specified distance.
     *
     * @param distance how long to the destination
     */
    public void chargeRide(int distance) {
        earnings += calculateCost(distance);
        numMiles = getNumMiles() + distance;
    }

    /**
     * Method that shows whether two vehicles are equal.
     * {@inheritDoc}
     *
     * @param other the object passed in
     * @return boolean representing whether two vehicles are equal.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) other;
            return this.id.equals(vehicle.id) && this.numMiles == vehicle.numMiles;
        }
        return false;
    }

    /**
     * Method that returns a string representing how many miles the vehicle drove and how much earned.
     *
     * @return String representing how many miles the vehicle drove and how much earned.
     */
    @Override
    public String toString() {
        return String.format("%s has driven %d miles and has earned %.2f dollars. ",
                id, getNumMiles(), getEarnings());
    }

    /**
     * Getter for earnings variable.
     *
     * @return earnings representing the total amount of money this vehicle earned transporting passengers
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Setter for earnings variable.
     * @param earnings representing the total amount of money this vehicle earned transporting passengers
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    /**
     * Getter for numMiles variable.
     *
     * @return int numMiles representing the total amount of money this vehicle earned transporting passengers
     */
    public int getNumMiles() {
        return numMiles;
    }
}