package LerneProgrammierenProjecte;

import javax.swing.JOptionPane;
import java.util.Random;
public class LottoGewinner {
    public static void main (String [] args) {
        String eingabeText = JOptionPane.showInputDialog("Bitte Lottozahl eingeben:");
        int lottoEingabe = Integer.parseInt(eingabeText);

        Random zufallsGenerator = new Random();
        int zufallszahl = zufallsGenerator.nextInt(100);

        if(zufallszahl == lottoEingabe) {
            JOptionPane.showMessageDialog(null, "Du hast gewonnen!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Du hast verloren! Die Zahl war: " + zufallszahl);
        }
    }
}