package Mission;

import Rocket.*;

public abstract class MissionMaker {
    private String name;
    private boolean requiresCrew;
    private double distance;
    private double fuelCoefficient;



    public MissionMaker(String name, boolean requiresCrew, double distance, double fuelCoefficient) {
        this.name = name;
        this.requiresCrew = requiresCrew;
        this.distance = distance;
        this.fuelCoefficient = fuelCoefficient;
    }



    public String getName() {
        return name;
    }

    public boolean requiresCrew() {
        return requiresCrew;
    }

    public double getDistance() {
        return distance;
    }

    public double getFuelCoefficient() {
        return fuelCoefficient;
    }

    public abstract double calculateFuel(Rocket rocket);
}