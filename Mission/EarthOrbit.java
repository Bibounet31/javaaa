package Mission;
import Rocket.*;

public class EarthOrbit extends MissionMaker {
    public EarthOrbit() {
        super("Earth Orbit", false, 400, 1.0);
    }

    @Override
    public double calculateFuel(Rocket rocket) {
        return (rocket.getTotalWeight() * getDistance() * getFuelCoefficient()) / 1000;
    }
}