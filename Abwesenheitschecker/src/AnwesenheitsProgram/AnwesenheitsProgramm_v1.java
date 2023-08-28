package AnwesenheitsProgram;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.awt.*;

public class AnwesenheitsProgramm_v1 {
    public static void main(String[] args) {
        JFileChooser dateiAuswahl = new JFileChooser();

        dateiAuswahl.setDialogTitle("Klassenliste auswählen");
        int schuelerListeAuswahl = dateiAuswahl.showOpenDialog(null);
        if (schuelerListeAuswahl != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Die Schülerliste wurde nicht ausgewählt.");
            return;
        }
        File schuelerListeDatei = dateiAuswahl.getSelectedFile();

        dateiAuswahl.setDialogTitle("Anwesenheitsliste auswählen");
        int anwesenheitsListeAuswahl = dateiAuswahl.showOpenDialog(null);
        if (anwesenheitsListeAuswahl != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Die Anwesenheitsliste wurde nicht ausgewählt.");
            return;
        }
        File anwesenheitsListeDatei = dateiAuswahl.getSelectedFile();

        List<String> schuelerListe = listeAusDateiLesen(schuelerListeDatei.getPath());
        List<String> anwesenheitsListe = listeAusDateiLesen(anwesenheitsListeDatei.getPath());

        Map<String, Boolean> anwesenheitsStatus = new HashMap<>();
        for (String schueler : schuelerListe) {
            anwesenheitsStatus.put(schueler, anwesenheitsListe.contains(schueler));
        }

        String datum = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String gespeicherteDatei = "anwesenheitsliste_" + datum + ".csv";

        try {
            FileWriter schreiber = new FileWriter(gespeicherteDatei);
            schreiber.write("Schülername,Klasse,Anwesenheitsstatus\n");
            for (String schueler : schuelerListe) {
                boolean anwesend = anwesenheitsStatus.getOrDefault(schueler, false);
                String anwesenheitsStatusText = anwesend ? "Anwesend" : "Abwesend";
                schreiber.write(schueler + "," + anwesenheitsStatusText + "\n");
            }
            schreiber.close();
            JOptionPane.showMessageDialog(null, "Die Anwesenheitsliste wurde als " + gespeicherteDatei + " gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Boolean> eintrag : anwesenheitsStatus.entrySet()) {
            String schueler = eintrag.getKey();
            boolean anwesend = eintrag.getValue();
            Color farbe = anwesend ? Color.GREEN : Color.RED;
            String status = anwesend ? "Anwesend" : "Abwesend";
            sb.append("<span style='color:" + (anwesend ? "green" : "red") + "'>" + schueler + ": " + status + "</span><br>");
        }

        JLabel label = new JLabel("<html>" + sb.toString() + "</html>");

        int kontrollAuswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie die erstellten Daten überprüfen?", "Überprüfen", JOptionPane.YES_NO_OPTION);
        if (kontrollAuswahl == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, label);
        }
    }

    public static List<String> listeAusDateiLesen(String dateiName) {
        List<String> liste = new ArrayList<>();
        try {
            BufferedReader leser = new BufferedReader(new FileReader(dateiName));
            String zeile;
            while ((zeile = leser.readLine()) != null) {
                liste.add(zeile);
            }
            leser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
