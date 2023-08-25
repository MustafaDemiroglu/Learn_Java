package yoklamaprogrami;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.util.List;

public class YoklamaProgrami_v3 {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        int ogrenciListesiSecim = fileChooser.showOpenDialog(null);
        if (ogrenciListesiSecim != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Öğrenci listesi dosyası seçilmedi.");
            return;
        }
        File ogrenciListesiDosyasi = fileChooser.getSelectedFile();

        int katilimListesiSecim = fileChooser.showOpenDialog(null);
        if (katilimListesiSecim != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Ders katılım listesi dosyası seçilmedi.");
            return;
        }
        File katilimListesiDosyasi = fileChooser.getSelectedFile();

        List<String> ogrenciListesi = dosyadanListeOku(ogrenciListesiDosyasi.getPath());
        List<String> katilimListesi = dosyadanListeOku(katilimListesiDosyasi.getPath());

        Map<String, Boolean> yoklamaDurumlari = new HashMap<>();
        for (String ogrenci : ogrenciListesi) {
            yoklamaDurumlari.put(ogrenci, katilimListesi.contains(ogrenci));
        }

        String tarih = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String kaydetDosyasi = "yoklamalistesi_" + tarih + ".csv";

        try {
            FileWriter writer = new FileWriter(kaydetDosyasi);
            writer.write("Öğrenci Adı,Sınıf,Katılım Durumu\n");
            for (String ogrenci : ogrenciListesi) {
                boolean katildiMi = yoklamaDurumlari.getOrDefault(ogrenci, false);
                String katilimDurumu = katildiMi ? "Katıldı" : "Katılmadı";
                writer.write(ogrenci + "," + katilimDurumu + "\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Yoklama listesi " + kaydetDosyasi + " olarak kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : yoklamaDurumlari.entrySet()) {
            String ogrenci = entry.getKey();
            boolean katildiMi = entry.getValue();
            Color renk = katildiMi ? Color.GREEN : Color.RED;
            String durum = katildiMi ? "Katıldı" : "Katılmadı";
            sb.append("<span style='color:" + (katildiMi ? "green" : "red") + "'>" + ogrenci + ": " + durum + "</span><br>");
        }

        JLabel label = new JLabel("<html>" + sb.toString() + "</html>");
        JOptionPane.showMessageDialog(null, label);
    }

    public static List<String> dosyadanListeOku(String dosyaAdi) {
        List<String> liste = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
            String satir;
            while ((satir = reader.readLine()) != null) {
                liste.add(satir);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
