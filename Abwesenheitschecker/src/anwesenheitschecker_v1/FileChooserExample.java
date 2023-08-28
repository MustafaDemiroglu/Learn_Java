package anwesenheitschecker_v1;

import javax.swing.*;
import java.io.File;
public class FileChooserExample {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // hier geht es mit dem Einlesen der Datei weiter
        }

    }
}
