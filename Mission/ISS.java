package Mission;
import Rocket.*;

public class ISS extends MissionMaker {
    public ISS() {
        super("ISS", true, 400, 1.2);
    }

    @Override
    public double calculateFuel(Rocket rocket) {
        return (rocket.getTotalWeight() * getDistance() * getFuelCoefficient()) / 1000;
    }
}