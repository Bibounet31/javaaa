import Launchers.*;
import Capsule.*;
import Booster.*;
import Mission.*;
import Rocket.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Simulator {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SPACE LAUNCH SIMULATOR ===");
        System.out.println("\nAvailable launchers:");

        for (int i = 0; i < launchers.size(); i++) {
            System.out.println((i + 1) + ". " + launchers.get(i).getName());
        }

        System.out.print("\nChoose a launcher: ");
        int choice = scanner.nextInt();
        Launchers chosenLauncher = launchers.get(choice - 1);
        System.out.println("You chose: " + chosenLauncher.getName());
//capsules
        System.out.println("\nAvailable capsules:");
        for (int i = 0; i < capsules.size(); i++) {
            System.out.println((i + 1) + ". " + capsules.get(i).getDescription());
        }
        System.out.print("\nChoose a capsule: ");
        int capsuleChoice = scanner.nextInt();
        CapsulesMaker chosenCapsule = capsules.get(capsuleChoice - 1);
        System.out.println("You chose: " + chosenCapsule.getDescription());
// boosters
        Rocket rocket = new Rocket(chosenLauncher, chosenCapsule);

        System.out.println("\nAvailable boosters:");
        for (int i = 0; i < boosters.size(); i++) {
            System.out.println((i + 1) + ". " + boosters.get(i).getName());
        }
        System.out.println("0. No booster");

        System.out.print("\nChoose a booster (0 to stop): ");
        int boosterChoice = scanner.nextInt();
        while (boosterChoice != 0) {
            rocket.addBooster(boosters.get(boosterChoice - 1));
            System.out.println("Booster added!");
            System.out.print("Add another booster (0 to stop): ");
            boosterChoice = scanner.nextInt();
        }
        // missions
        System.out.println("\nAvailable missions:");
        for (int i = 0; i < missions.size(); i++) {
            System.out.println((i + 1) + ". " + missions.get(i).getName());
        }
        System.out.print("\nChoose a mission: ");
        int missionChoice = scanner.nextInt();
        MissionMaker chosenMission = missions.get(missionChoice - 1);
        System.out.println("You chose: " + chosenMission.getName());
        simulate(rocket, chosenMission);
    }


    private static Simulator instance;

    private List<Launchers> launchers;
    private List<CapsulesMaker> capsules;
    private List<BoosterMaker> boosters;
    private List<MissionMaker> missions;

    private Simulator() {
        // initialize catalogues
        launchers = new ArrayList<>();
        capsules = new ArrayList<>();
        boosters = new ArrayList<>();
        missions = new ArrayList<>();

        // fill catalogues
        launchers.add(new Falcon9());
        launchers.add(new SaturnV());
        launchers.add(new Ariane5());
        launchers.add(new SLS());

        capsules.add(new Orion());
        capsules.add(new CrewDragon());
        capsules.add(new Apollo());
        capsules.add(new CargoDragon());

        boosters.add(new BoosterMaker("EAP", 6470, 270, 30));
        boosters.add(new BoosterMaker("SRB", 12500, 590, 55));
        boosters.add(new BoosterMaker("BE-3", 490, 25, 12));

        missions.add(new EarthOrbit());
        missions.add(new ISS());
        missions.add(new Moon());
        missions.add(new Mars());
        missions.add(new Custom());
    }

    public static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }

    public void simulate(Rocket rocket, MissionMaker mission) {
        System.out.println("\n=== LAUNCHING ===");

        // 1. check crew compatibility
        if (mission.requiresCrew() && !rocket.getLauncher().canCarryHumans()) {
            System.out.println("FAILURE: Launcher cannot carry crew");
            return;
        }

        // 2. check fuel
        double fuelNeeded = mission.calculateFuel(rocket);
        if (fuelNeeded > rocket.getLauncher().getMaxFuel()) {
            System.out.println("FAILURE: Insufficient fuel capacity");
            return;
        }

        // 3. check payload
        if (rocket.getTotalWeight() > rocket.getLauncher().getMaxPayloadT()) {
            System.out.println("FAILURE: Payload exceeded");
            return;
        }

        // 4. check boosters
        if (rocket.getBoosters().size() > rocket.getLauncher().getMaxBoosters()) {
            System.out.println("FAILURE: Too many boosters");
            return;
        }

        // 5. random failure
        double random = Math.random();
        if (random < 0.05) {
            System.out.println("FAILURE: Unexpected technical anomaly");
            return;
        }

        System.out.println("SUCCESS! Mission " + mission.getName() + " completed!");
        System.out.println("Fuel used: " + fuelNeeded + "t");
    }




}