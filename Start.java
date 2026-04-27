import java.util.Scanner;
import Rockets.*;


public class Start {


    public static void main(String[] args) {


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