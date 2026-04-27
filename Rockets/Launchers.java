package Rockets;

public abstract class Launchers { // name, can carry humans, max boosters max fuel, max payload, priceinmillion.
    private String name;
    private boolean canCarryHumans;
    private int maxBoosters;
    private double maxFuel;
    private double maxPayloadT;
    private double priceMillion;

    public Launchers(String name, boolean canCarryHumans, int maxBoosters,
                     double maxFuel, double maxPayloadT, double priceMillion) {
        this.name = name;
        this.canCarryHumans = canCarryHumans;
        this.maxBoosters = maxBoosters;
        this.maxFuel = maxFuel;
        this.maxPayloadT = maxPayloadT;
        this.priceMillion = priceMillion;
    }

    public String getName() { return name; }
    public boolean canCarryHumans() { return canCarryHumans; }
    public int getMaxBoosters() { return maxBoosters; }
    public double getMaxFuel() { return maxFuel; }
    public double getMaxPayloadT() { return maxPayloadT; }
    public double getPriceMillion() { return priceMillion; }

    public abstract String getDescription();
}