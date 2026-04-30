package Mission;
import Rocket.*;

public class Mars extends MissionMaker {
    public Mars() {
        super("Mars", true, 225000000, 0.000015);
    }

    @Override
    public double calculateFuel(Rocket rocket) {
        return (rocket.getTotalWeight() * getDistance() * getFuelCoefficient()) / 1000;
    }
}