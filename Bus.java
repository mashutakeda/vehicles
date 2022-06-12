/**
 * Represents a regular bus in your transport network, like the Georgia Tech busses, or a MARTA bus.
 *
 * @author mtakeda9 Mashu Takeda
 * @version 1
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * Creates a bus object with specified id, numMiles, location, and stopsPerMile variables.
     *
     * @param id           the identifier for the vehicle
     * @param numMiles     number of miles the vehicle has travelled
     * @param location     the general area of the bus route.
     * @param stopsPerMile how many times a bus stops in one mile.
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * Creates a bus object with specified id and location, and defaults numMiles to 0 and stopsPerMile to 2.
     *
     * @param id       the identifier for the vehicle
     * @param location the general area of the bus route.
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    @Override
    public boolean canDrive(int distance) {
        return (distance > 0);
    }

    @Override
    public double calculateCost(int distance) {
        if (distance < 0) {
            return -1;
        } else {
            double cost = distance * 3.0 / getStopsPerMile();
            return cost;
        }
    }


    @Override
    public boolean addPassenger(int distance, String[] waiting) {
        if (this.canDrive(distance)) {
            int j = 0;
            String[] list = this.passengers;
            for (int i = 0; i < list.length && j < waiting.length; i++) {
                if (list[i] == null) {
                    list[i] = waiting[j];
                    j++;
                }
            }
            chargeRide(distance);
            this.setEarnings(this.getEarnings() + (j - 1) * this.calculateCost(distance));
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (super.equals(other) && other instanceof Bus) {
            Bus bus = (Bus) other;
            return (this.location == bus.location && this.stopsPerMile == bus.stopsPerMile);
        }
        return false;
    }


    @Override
    public String toString() {
        return "Bus " + super.toString() + String.format("This bus drives around %s and makes %d stops per mile.",
                getLocation(), getStopsPerMile());
    }

    /**
     * Getter for location variable.
     *
     * @return location, a String representing the general area of the bus route.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for stopsPerMile variable.
     *
     * @return stopsPerMile, an int representing how many times a bus stops in one mile.
     */
    public int getStopsPerMile() {
        return stopsPerMile;
    }
}