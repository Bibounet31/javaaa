import Mission.*;
import Rocket.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String FILE_PATH = "history.txt";

    public static void save(Launch launch) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(launch.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    public static List<String> load() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("No history found.");
        }
        return lines;
    }
}