import java.util.Scanner;
import Launchers.*;
import Capsule.*;
import Booster.*;
import Mission.*;
import Rocket.*;

public class Start {


    public static void main(String[] args) {

        Simulator sim = Simulator.getInstance();
        sim.start();
        //Rocket rocket = new Rocket(new Falcon9(), new Orion());
        //rocket.addBooster(new BoosterMaker("EAP", 6470, 270, 30));

        //MissionMaker mission = new Moon();
        //System.out.println(mission.getName());
        //System.out.println(mission.calculateFuel(rocket));


        //System.out.println(rocket.getTotalWeight());
        //System.out.println(rocket.getTotalPrice());


        //test boosters
        //BoosterMaker eap = new BoosterMaker("EAP", 6470, 270, 30);
        //BoosterMaker srb = new BoosterMaker("SRB", 12500, 590, 55);
        //BoosterMaker be3 = new BoosterMaker("BE-3", 490, 25, 12);


        //test capsules
        //CapsulesMaker c = new Orion();
        //System.out.println(c.canCarryHumans());
        //System.out.println(c.getMaxPeople());
        //System.out.println(c.getWeight());
        //System.out.println(c.getPrice());
        //test launcher
        //Launchers l  = new Falcon9();
        //System.out.println(l.getName());
        //System.out.println(l.canCarryHumans());
        //System.out.println(l.getMaxFuel());





        Scanner reader = new Scanner(System.in);
        int rockets = reader.nextInt();


        switch (rockets) {
            case 1:
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                reader.close();
                break;
            case 2:
                System.out.println("b");
                reader.close();

        }



    }
}