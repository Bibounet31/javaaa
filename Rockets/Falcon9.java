package Rockets;

//subclass from Launchers
public class Falcon9 extends Launchers {
    public Falcon9() {
        super("Falcon 9", true, 0, 500, 22, 60);
    }

    @Override
    public String getDescription() {
        return "Falcon 9 - SpaceX reusable launcher";
    }
}