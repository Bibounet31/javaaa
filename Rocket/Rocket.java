package Rocket;

import Launchers.*;
import Capsule.*;
import Booster.*;
import java.util.ArrayList;
import java.util.List;

public class Rocket {
    private Launchers launcher;
    private CapsulesMaker capsule;
    private List<BoosterMaker> boosters;

    public Rocket(Launchers launcher, CapsulesMaker capsule) {
        this.launcher = launcher;
        this.capsule = capsule;
        this.boosters = new ArrayList<>();
    }

    public void addBooster(BoosterMaker booster) {
        boosters.add(booster);
    }

    public double getTotalWeight() {
        double total = capsule.getWeight();
        for (BoosterMaker b : boosters) {
            total += b.getWeight();
        }
        return total;
    }

    public double getTotalPrice() {
        double total = launcher.getPriceMillion() + capsule.getPrice();
        for (BoosterMaker b : boosters) {
            total += b.getPrice();
        }
        return total;
    }

    public Launchers getLauncher() { return launcher; }
    public List<BoosterMaker> getBoosters() { return boosters; }

}