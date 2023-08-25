package yoklamaprogrami;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class YoklamaProgrami_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Öğrenci listesi dosyasının adını girin: ");
        String ogrenciListesiDosyasi = scanner.nextLine();

        System.out.println("Ders katılım listesi dosyasının adını girin: ");
        String katilimListesiDosyasi = scanner.nextLine();

        List<String> ogrenciListesi = dosyadanListeOku(ogrenciListesiDosyasi);
        List<String> katilimListesi = dosyadanListeOku(katilimListesiDosyasi);

        Map<String, Boolean> yoklamaDurumlari = new HashMap<>();
        for (String ogrenci : ogrenciListesi) {
            yoklamaDurumlari.put(ogrenci, katilimListesi.contains(ogrenci));
        }

        String tarih = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String kaydetDosyasi = "yoklamalistesi_" + tarih + ".csv";

        try {
            FileWriter writer = new FileWriter(kaydetDosyasi);
            for (Map.Entry<String, Boolean> entry : yoklamaDurumlari.entrySet()) {
                String ogrenci = entry.getKey();
                boolean katildiMi = entry.getValue();
                writer.write(ogrenci + "," + (katildiMi ? "Katıldı" : "Katılmadı") + "\n");
            }
            writer.close();
            System.out.println("Yoklama listesi " + kaydetDosyasi + " olarak kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nYoklama Listesi:");
        for (Map.Entry<String, Boolean> entry : yoklamaDurumlari.entrySet()) {
            String ogrenci = entry.getKey();
            boolean katildiMi = entry.getValue();
            String renk = katildiMi ? "\u001B[32m" : "\u001B[31m"; // Yeşil veya Kırmızı renk
            String durum = katildiMi ? "Katıldı" : "Katılmadı";
            System.out.println(renk + ogrenci + ": " + durum + "\u001B[0m");
        }
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
