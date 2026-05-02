public class InsufficientFuelException extends Exception {
    public InsufficientFuelException(double fuelNeeded, double fuelMax) {
        super("Insufficient fuel: needed " + fuelNeeded + "t but max capacity is " + fuelMax + "t");
    }
}