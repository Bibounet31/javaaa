package Rockets;

//subclass of Launchers
public class SaturnV extends Launchers {
    public SaturnV() {
        super("Saturne V", true, 0, 2700, 140, 1500);
    }

    @Override
    public String getDescription() {
        return "Saturne V - NASA historic launcher, Moon capable";
    }
}