import Rocket.*;
import Mission.*;
import java.time.LocalDateTime;

public class Launch {
    private Rocket rocket;
    private MissionMaker mission;
    private LocalDateTime date;
    private boolean success;
    private String reason;
    private double totalCost;

    public Launch(Rocket rocket, MissionMaker mission, boolean success, String reason, double totalCost) {
        this.rocket = rocket;
        this.mission = mission;
        this.date = LocalDateTime.now();
        this.success = success;
        this.reason = reason;
        this.totalCost = totalCost;
    }

    public String toString() {
        return date + " | " + mission.getName() + " | " +
                (success ? "SUCCESS" : "FAILURE: " + reason) +
                " | Cost: " + totalCost + "M€";
    }

    public boolean isSuccess() { return success; }
    public String getReason() { return reason; }
    public double getTotalCost() { return totalCost; }
    public MissionMaker getMission() { return mission; }
    public Rocket getRocket() { return rocket; }
    public LocalDateTime getDate() { return date; }
}