package Booster;

public class BoosterMaker {
    private String name;
    private int pushForce;
    private double weight;
    private double price;

    public BoosterMaker(String name, int pushForce, double weight, double price) {
        this.name = name;
        this.pushForce = pushForce;
        this.weight = weight;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPushForce() { return pushForce; }
    public double getWeight() { return weight; }
    public double getPrice() { return price; }
}