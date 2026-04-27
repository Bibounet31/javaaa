package Capsule;

//subclasse from CapsulesMaker
public class Apollo extends CapsulesMaker {
    public Appollo() {
        super(true,3,5.60,200); //(boolean canCarryHumans, int maxPeople, int weight, int price)
    }


    @Override
    public String getDescription() {
        return "Apolllo CAPSULE only owo";
    }

}