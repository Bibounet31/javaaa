package Capsule;

public abstract class CapsulesMaker { // Cancarryhumans maxpeople weight price
    private boolean canCarryHumans;
    private int maxPeople;
    private double weight;
    private double price;

    //constructor
    public CapsulesMaker(boolean canCarryHumans, int maxPeople, double weight, double price) {
        this.canCarryHumans = canCarryHumans;
        this.maxPeople = maxPeople;
        this.weight = weight;
        this.price = price;
    }


    //get
    public boolean canCarryHumans() { return canCarryHumans; }
    public int getMaxPeople() { return maxPeople; }
    public double getWeight() { return weight; }
    public double getPrice() { return price; }

    public abstract String getDescription();

}