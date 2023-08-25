package yoklamaprogrami;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class YoklamaProgrami {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Öğrenci listesi dosyasının adını girin (ornek_liste.csv): ");
        String ogrenciListesiDosyasi = scanner.nextLine();

        System.out.println("Ders katılım listesi dosyasının adını girin (katilim_listesi.csv): ");
        String katilimListesiDosyasi = scanner.nextLine();

        List<String> ogrenciListesi = dosyadanListeOku(ogrenciListesiDosyasi);
        List<String> katilimListesi = dosyadanListeOku(katilimListesiDosyasi);

        List<String> yoklamaListesi = new ArrayList<>();

        for (String ogrenci : ogrenciListesi) {
            if (katilimListesi.contains(ogrenci)) {
                yoklamaListesi.add(ogrenci);
            }
        }

        System.out.println("Yoklama Listesi:");
        for (String ogrenci : yoklamaListesi) {
            System.out.println(ogrenci);
        }

        String tarih = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String kaydetDosyasi = "yoklamalistesi_" + tarih + ".csv";

        try {
            FileWriter writer = new FileWriter(kaydetDosyasi);
            for (String ogrenci : yoklamaListesi) {
                writer.write(ogrenci + "\n");
            }
            writer.close();
            System.out.println("Yoklama listesi " + kaydetDosyasi + " olarak kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
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

