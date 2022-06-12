/**
 * Represents a regular car in the transportation network.
 *
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * Creates a car object with specified id, number of miles, list of passengers,
     * rate, fees, and maximum number of miles the vehicle can drive.
     *
     * @param id          the identifier for the vehicle
     * @param numMiles    number of miles the vehicle has travelled
     * @param passengers  the passengers aboard the vehicle. Each item in the Array represents a passenger’s name.
     * @param rate        the price of using the car to go 1 mile.
     * @param fees        the total fees to use the car once
     * @param maxNumMiles the total number of miles that the car can drive before it is retired.
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * Creates a car object with specified id, number of miles, and maximum number of miles the vehicle can drive.
     * defaults 10 for rate, 15 for fees, and a total of 4 passengers.
     *
     * @param id          the identifier for the vehicle
     * @param numMiles number of miles the vehicle has travelled
     * @param maxNumMiles the total number of miles that the car can drive before it is retired.
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10, 15, maxNumMiles);
    }

    /**
     * Creates a car object with speficied id and defaults of 0 for
     * numMiles, 4 passengers, 10 for rate, 15 for fee, and 200 for maxNumMiles.
     *
     * @param id the identifier for the vehicle
     */
    public Car(String id) {
        this(id, 0, new String[4], 10, 15, 200);
    }

    @Override
    public boolean canDrive(int distance) {
        return (distance > 0 && distance <= (maxNumMiles - numMiles));
    }

    @Override
    public double calculateCost(int distance) {
        if (distance < 0 || distance >= maxNumMiles) {
            return -1;
        } else {
            double cost = distance * rate + fees;
            return cost;
        }
    }

    @Override
    public boolean addPassenger(int distance, String[] waiting) {
        int space = 0;
        boolean result;
        String[] list = this.passengers;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                space++;
            }
        }
        if (this.canDrive(distance) && waiting.length <= space) {
            int j = 0;
            for (int i = 0; i < list.length && j < waiting.length; i++) {
                if (list[i] == null) {
                    list[i] = waiting[j];
                    j++;
                }
            }
            chargeRide(distance);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (super.equals(other) && other instanceof Car) {
            Car car = (Car) other;
            return (this.rate == car.rate && this.fees == car.fees && this.maxNumMiles == car.maxNumMiles);
        }
        return false;
    }


    @Override
    public String toString() {
        return "Car " + super.toString()
                + String.format("It can only drive %d miles. "
                        + "It costs %.2f dollars per mile and there is a one-time fee of %.2f dollars.",
                getMaxNumMiles(), getRate(), getFees());
    }
    /**
     * Getter for rate variable.
     *
     * @return rate, a double representing the price of using the car to go 1 mile.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Getter for fees variable.
     *
     * @return fees, a double representing the total fees to use the car once.
     */
    public double getFees() {
        return fees;
    }

    /**
     * Getter for maxNumMiles.
     *
     * @return maxNumMiles, an int representing the total number of miles that the car can drive before it is retired.
     */
    public int getMaxNumMiles() {
        return maxNumMiles;
    }

}