package Capsule;

//subclasse from CapsulesMaker
public class CrewDragon extends CapsulesMaker {
    public CrewDragon() {
        super(true,7,12.00,150); //(boolean canCarryHumans, int maxPeople, int weight, int price)


    }

    @Override
    public String getDescription() { return "Crew Dragon"; }

}

