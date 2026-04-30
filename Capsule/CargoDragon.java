package Capsule;

//subclasse from CapsulesMaker
public class CargoDragon extends CapsulesMaker {
    public CargoDragon() {
        super(false,0,9.50,100); //(boolean canCarryHumans, int maxPeople, int weight, int price)
    }

    @Override
    public String getDescription() { return "Cargo Dragon"; }

}

