package Mission;
import Rocket.*;

public class Moon extends MissionMaker {
    public Moon() {
        super("Moon", true, 400000, 0.005);
    }

    @Override
    public double calculateFuel(Rocket rocket) {
        return (rocket.getTotalWeight() * getDistance() * getFuelCoefficient()) / 1000;
    }
}