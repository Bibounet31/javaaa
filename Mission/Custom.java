package Mission;
import Rocket.*;

public class Custom extends MissionMaker {
    public Custom() {
        super("Jupiter", true, 628730000, 0.000008);
    }

    @Override
    public double calculateFuel(Rocket rocket) {
        return (rocket.getTotalWeight() * getDistance() * getFuelCoefficient()) / 1000;
    }
}