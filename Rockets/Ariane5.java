package Rockets;

//subclass from Launchers
public class Ariane5 extends Launchers {
    public Ariane5() {
        super("Ariane 5", false, 2, 700, 20, 180);
    }

    @Override
    public String getDescription() {
        return "Ariane 5 - ESA workhorse, cargo only";
    }
}