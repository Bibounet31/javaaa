import java.util.Scanner;
import Rockets.*;
import Capsule.*;
import Booster.*;

public class Start {


    public static void main(String[] args) {


        //test boosters
        BoosterMaker eap = new BoosterMaker("EAP", 6470, 270, 30);
        BoosterMaker srb = new BoosterMaker("SRB", 12500, 590, 55);
        BoosterMaker be3 = new BoosterMaker("BE-3", 490, 25, 12);


        //test capsules
        CapsulesMaker c = new Orion();
        System.out.println(c.canCarryHumans());
        System.out.println(c.getMaxPeople());
        System.out.println(c.getWeight());
        System.out.println(c.getPrice());
        //test launcher
        Launchers l  = new Falcon9();
        System.out.println(l.getName());
        System.out.println(l.canCarryHumans());
        System.out.println(l.getMaxFuel());





        Scanner reader = new Scanner(System.in);
        int rocket = reader.nextInt();


        switch (rocket) {
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