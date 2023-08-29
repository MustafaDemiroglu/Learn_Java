package AnwesenheitsProgramm_v10;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class AnwesenheitsProgramm_v9 {
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
        List<SchuelerAnwesenheit> anwesenheitsListe = schuelerAnwesenheitListeAusDateiLesen(anwesenheitsListeDatei.getPath());

        Map<String, SchuelerAnwesenheit> anwesenheitsStatus = new HashMap<>();
        for (SchuelerAnwesenheit eintrag : anwesenheitsListe) {
            anwesenheitsStatus.put(eintrag.getName() + " " + eintrag.getVorname(), eintrag);
        }

        String datum = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String gespeicherteDatei = "anwesenheitsliste_" + datum + ".csv";

        try {
            FileWriter schreiber = new FileWriter(gespeicherteDatei);
            schreiber.write("Name,Vorname,Anwesenheitsstatus\n");
            for (String schueler : schuelerListe) {
                SchuelerAnwesenheit anwesenheit = anwesenheitsStatus.getOrDefault(schueler, new SchuelerAnwesenheit());
                String anwesenheitsStatusText = anwesenheit.getAnwesenheitText();
                schreiber.write(schueler + ",," + anwesenheitsStatusText + "\n");
            }
            schreiber.close();
            JOptionPane.showMessageDialog(null, "Die Anwesenheitsliste wurde als " + gespeicherteDatei + " gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<html><h1>Anwesenheitsliste</h1><br>");
        for (String schueler : schuelerListe) {
            SchuelerAnwesenheit anwesenheit = anwesenheitsStatus.getOrDefault(schueler, new SchuelerAnwesenheit());
            Color farbe = Color.decode(anwesenheit.getAnwesenheitFarbe());
            String status = anwesenheit.getAnwesenheitText();
            sb.append("<span style='color:" + farbe + "'>" + schueler + ": " + status + "</span><br>");
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

    static class SchuelerAnwesenheit {
        private String name;
        private String vorname;
        private String anwesenheitText;
        private String anwesenheitFarbe;

        public SchuelerAnwesenheit() {
            anwesenheitText = "Abwesend";
            anwesenheitFarbe = "red";
        }

        public SchuelerAnwesenheit(String name, String vorname, String anwesenheitText) {
            this.name = name;
            this.vorname = vorname;
            this.anwesenheitText = anwesenheitText;
            this.anwesenheitFarbe = anwesenheitText.equals("Anwesend") ? "green" : "red";
        }

        public String getName() {
            return name;
        }

        public String getVorname() {
            return vorname;
        }

        public String getAnwesenheitText() {
            return anwesenheitText;
        }

        public String getAnwesenheitFarbe() {
            return anwesenheitFarbe;
        }
    }

    public static List<SchuelerAnwesenheit> schuelerAnwesenheitListeAusDateiLesen(String dateiName) {
        List<SchuelerAnwesenheit> liste = new ArrayList<>();
        try {
            BufferedReader leser = new BufferedReader(new FileReader(dateiName));
            String zeile;
            while ((zeile = leser.readLine()) != null) {
                String[] teile = zeile.split(",");
                if (teile.length >= 3) {
                    SchuelerAnwesenheit anwesenheit = new SchuelerAnwesenheit(teile[0], teile[1], teile[2]);
                    liste.add(anwesenheit);
                }
            }
            leser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
