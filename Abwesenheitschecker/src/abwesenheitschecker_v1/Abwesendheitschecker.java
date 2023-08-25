package abwesenheitschecker_v1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Abwesendheitschecker {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            List<String> klassenList = readCSV(selectedFile.getAbsolutePath());
            List<String> teilnehmerList = readCSV(selectedFile.getAbsolutePath());

            List<String> abwesendList = new ArrayList<>();
            for (String teilnehmer : teilnehmerList) {
                if (!teilnehmerList.contains(teilnehmerList)) {
                    abwesendList.add(teilnehmer);
                }
            }

            try (FileWriter writer = new FileWriter("abwesenheitsList.csv")) {
                for (String abwesend : abwesendList) {
                    writer.write(abwesend + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> readCSV(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

