import Launchers.*;
import Capsule.*;
import Booster.*;
import Mission.*;
import Rocket.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulator {
    private static Simulator instance;

    private List<Launchers> launchers;
    private List<CapsulesMaker> capsules;
    private List<BoosterMaker> boosters;
    private List<MissionMaker> missions;
    private List<Launch> history;

    private Simulator() {
        launchers = new ArrayList<>();
        capsules = new ArrayList<>();
        boosters = new ArrayList<>();
        missions = new ArrayList<>();
        history = new ArrayList<>();

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



        // load history at startup
        List<String> savedHistory = HistoryManager.load();
        if (!savedHistory.isEmpty()) {
            System.out.println("\n=== PREVIOUS LAUNCHES ===");
            for (String line : savedHistory) {
                System.out.println(line);
            }
        }
    }





    public static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        //launchers
        System.out.println("=== SPACE LAUNCH SIMULATOR ===");
        System.out.println("\nAvailable launchers:");


        for (int i = 0; i < launchers.size(); i++) {
            System.out.println((i + 1) + ". " + launchers.get(i).getName());  // list all available launchers
        }

        System.out.print("\nChoose a launcher: ");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > launchers.size()) {       //check if inserted value is in range
            System.out.print("choix invalide!");
            choice = scanner.nextInt();
        }

        Launchers chosenLauncher = launchers.get(choice - 1);           //get chosen launcher
        System.out.println("You chose: " + chosenLauncher.getName());





        //capsules
        System.out.println("\nAvailable capsules:");
        for (int i = 0; i < capsules.size(); i++) {
            System.out.println((i + 1) + ". " + capsules.get(i).getDescription());      //show all availables capsules
        }
        System.out.print("\nChoose a capsule: ");

        int capsuleChoice = scanner.nextInt();
        while (capsuleChoice < 1 || capsuleChoice > capsules.size()) {     //check if inserted value is in range
            System.out.print("choix invalide!");
            capsuleChoice = scanner.nextInt();
        }

        CapsulesMaker chosenCapsule = capsules.get(capsuleChoice - 1);
        System.out.println("You chose: " + chosenCapsule.getDescription()); //show selected capsule

        Rocket rocket = new Rocket(chosenLauncher, chosenCapsule);      // init rocket with chosed launcher and capsule

        //booster
        System.out.println("\nAvailable boosters:");
        for (int i = 0; i < boosters.size(); i++) {
            System.out.println((i + 1) + ". " + boosters.get(i).getName());     //show available booteers
        }
        System.out.println("0. No booster");

        System.out.print("\nChoose a booster (0 to stop): ");
        int boosterChoice = scanner.nextInt();      //ask
        while (boosterChoice < 1 || boosterChoice > boosters.size()) {     //check if inserted value is in range
            System.out.print("choix invalide!");
            boosterChoice = scanner.nextInt();
        }

        while (boosterChoice != 0) {
            rocket.addBooster(boosters.get(boosterChoice - 1));
            System.out.println("Booster added!");
            System.out.print("Add another booster (0 to stop): ");
            boosterChoice = scanner.nextInt();
        }



        //missions
        System.out.println("\nAvailable missions:");
        for (int i = 0; i < missions.size(); i++) {
            System.out.println((i + 1) + ". " + missions.get(i).getName());     //show available missions
        }

        System.out.print("\nChoose a mission: ");


        int missionChoice = scanner.nextInt();
        MissionMaker chosenMission = missions.get(missionChoice - 1);       //tell mission maker which mission useer chosed
        System.out.println("You chose: " + chosenMission.getName());


        //MISSIONNNN
        try {
            simulate(rocket, chosenMission);
        } catch (InsufficientFuelException e) {
            System.out.println("FAILURE: " + e.getMessage());
            Launch launch = new Launch(rocket, chosenMission, false, e.getMessage(), 0);
            history.add(launch);
            HistoryManager.save(launch);
        }

        showHistory();
    }

    public void simulate(Rocket rocket, MissionMaker mission) throws InsufficientFuelException {
        System.out.println("\n=== LAUNCHING ===");

        // 1. check crew compatibility
        if (mission.requiresCrew() && !rocket.getLauncher().canCarryHumans()) {
            Launch launch = new Launch(rocket, mission, false, "Launcher cannot carry crew", 0);
            history.add(launch);
            HistoryManager.save(launch);
            System.out.println("FAILURE: Launcher cannot carry crew");
            return;
        }

        // 2. check fuel
        double fuelNeeded = mission.calculateFuel(rocket);
        if (fuelNeeded > rocket.getLauncher().getMaxFuel()) {
            throw new InsufficientFuelException(fuelNeeded, rocket.getLauncher().getMaxFuel());
        }

        // 3. check payload
        if (rocket.getTotalWeight() > rocket.getLauncher().getMaxPayloadT()) {
            Launch launch = new Launch(rocket, mission, false, "Payload exceeded", 0);
            history.add(launch);
            HistoryManager.save(launch);
            System.out.println("FAILURE: Payload exceeded");
            return;
        }

        // 4. check boosters
        if (rocket.getBoosters().size() > rocket.getLauncher().getMaxBoosters()) {
            Launch launch = new Launch(rocket, mission, false, "Too many boosters", 0);
            history.add(launch);
            HistoryManager.save(launch);
            System.out.println("FAILURE: Too many boosters");
            return;
        }

        // 5. random failure
        double random = Math.random();
        if (random < 0.05) {
            Launch launch = new Launch(rocket, mission, false, "Unexpected technical anomaly", 0);
            history.add(launch);
            HistoryManager.save(launch);
            System.out.println("FAILURE: Unexpected technical anomaly");
            return;
        }

        double totalCost = rocket.getTotalPrice();
        Launch launch = new Launch(rocket, mission, true, "Success", totalCost);
        history.add(launch);
        HistoryManager.save(launch);
        System.out.println("SUCCESS! Mission " + mission.getName() + " completed!");
        System.out.println("Fuel used: " + fuelNeeded + "t");
        System.out.println("Total cost: " + totalCost + "M€");
    }

    public void showHistory() {
        System.out.println("\n=== LAUNCH HISTORY ===");
        if (history.isEmpty()) {
            System.out.println("No launches yet.");
            return;
        }
        for (Launch l : history) {
            System.out.println(l.toString());
        }
    }
}