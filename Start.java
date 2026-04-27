import java.util.Scanner;
import Rockets.*;
import Capsule.*;

public class Start {


    public static void main(String[] args) {

        //test capsules
        CapsulesMaker c = new Orion();
        System.out.println(c.getDescription());
        System.out.println(c.canCarryHumans());
        System.out.println(c.getMaxPeople());
        System.out.println(c.getWeight());
        System.out.println(c.getPrice());
        //test launcher
        Launchers l  = new Falcon9();
        System.out.println(l.getName());
        System.out.println(l.canCarryHumans());
        System.out.println(l.getMaxFuel());
        System.out.println(l.getDescription());





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