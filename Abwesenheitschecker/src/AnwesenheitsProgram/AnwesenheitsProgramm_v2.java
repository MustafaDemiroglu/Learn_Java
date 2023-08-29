/*
 *  Zur Beschreibung der App:
 * Die "AnwesenheitsProgramm_v4"-App ermöglicht es einem Dozenten,
 * eine Klassenliste und eine Anwesenheitsliste auszuwählen.
 * Anhand dieser Daten erstellt die App eine Anwesenheitsliste
 * und speichert sie in einer CSV-Datei ab. Die Liste zeigt
 * den Namen eines jeden Schülers sowie seinen Anwesenheitsstatus an.
 * Die App generiert außerdem eine Übersicht,
 * die die Anwesenheitsliste zusammen mit einer Überschrift darstellt.
 * Der Dozent hat die Möglichkeit, die erstellten Daten zu überprüfen,
 * indem er auf eine Schaltfläche klickt.
 * Dieses Tool erleichtert die Verwaltung von Schüleranwesenheit
 * in einer übersichtlichen Weise.
 */

package AnwesenheitsProgram;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.awt.*;

public class AnwesenheitsProgramm_v2 {
    public static void main(String[] args) {
        JFileChooser dateiAuswahl = new JFileChooser();

        dateiAuswahl.setDialogTitle("Klassenliste auswählen");
        int schuelerListeAuswahl = dateiAuswahl.showOpenDialog(null);
        if (schuelerListeAuswahl != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Die Klassenliste wurde nicht ausgewählt.");
            return;
        }
        File schuelerListeDatei = dateiAuswahl.getSelectedFile();

        dateiAuswahl.setDialogTitle("Zu vergleichendes Anwesenheitsprotokoll auswählen");
        int anwesenheitsListeAuswahl = dateiAuswahl.showOpenDialog(null);
        if (anwesenheitsListeAuswahl != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Die benötigte Liste wurde nicht ausgewählt.");
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
            schreiber.write("Schülername,Anwesenheitsstatus\n");
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
        sb.append("<html><h1>Anwesenheitsliste</h1><br>");
        for (Map.Entry<String, Boolean> eintrag : anwesenheitsStatus.entrySet()) {
            String schueler = eintrag.getKey();
            boolean anwesend = eintrag.getValue();
            Color farbe = anwesend ? Color.GREEN : Color.RED;
            String status = anwesend ? "Anwesend" : "Abwesend";
            sb.append("<span style='color:" + (anwesend ? "green" : "red") + "'>" + schueler + ": " + status + "</span><br>");
        }
        sb.append("</html>");

        JLabel label = new JLabel(sb.toString());

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
