package Capsule;

//subclasse from CapsulesMaker
public class Orion extends CapsulesMaker {
    public Orion() {
        super(true,4,10.40,300); //(boolean canCarryHumans, int maxPeople, int weight, int price)
    }


    @Override
    public String getDescription() { return "Orion"; }
}


