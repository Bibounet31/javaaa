package Rockets;

//subclass from Launchers
public class SLS extends Launchers {
    public SLS() {
        super("SLS", true, 2, 2600, 130, 2000);
    }

    @Override
    public String getDescription() {
        return "SLS - NASA Space Launch System, Artemis program";
    }
}