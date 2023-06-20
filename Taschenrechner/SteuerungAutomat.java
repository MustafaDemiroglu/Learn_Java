import java.util.*;

public class SteuerungAutomat extends Steuerung
{
    
// ist noch nicht fertig, nur einige Beispieloperatoren sind angelegt
// zum Erweitern einfach im Konstruktor neue Operatoren ehinzufuegen
    
     
    //die drei Dinge, die man fuers Rechnen braucht
    double operand1 = 0; //der erste Operand
    double operand2 = 0; //der zweite Operand
    String aktuelleRechenart;

    //ein Attribute, das den Zustand bestimmt
    int zustand = 0; 
    //0 : das 1. Zeichen des 1. Operanden wird erwartet (und ueberschreibt die Ausgabe )
    //1 : weitere Zeichen des 1. Operanden werden erwartet (und werden an Ausgabe angehaengt)
    //2 : das 1. Zeichen des 2. Operanden wird erwartet (und ueberschreibt die Ausgabe )
    //3	 : weitere Zeichen des 2. Operanden werden erwartet (und werden an Ausgabe angehaengt)
    
    //was an das GUI gesendet wird
    String ausgabe ="0"; 

    // Hilfe zum Uebersetzen der Nachrichten in Funktionen
    Hashtable<String,String> einwertigeOperatoren;      
    Hashtable<String,String> einwertigeBoolescheOperatoren;      
    Hashtable<String,String> zweiwertigeOperatoren;      

    public SteuerungAutomat() {
        zweiwertigeOperatoren = new Hashtable<String, String>();
        zweiwertigeOperatoren.put("+", "addieren");
        zweiwertigeOperatoren.put("-", "subtrahieren");

        einwertigeOperatoren = new Hashtable<String, String>();
        einwertigeOperatoren.put("(-)", "negation");
        einwertigeOperatoren.put("x^2", "quadrat");
        
        einwertigeBoolescheOperatoren = new Hashtable<String, String>();
        einwertigeBoolescheOperatoren.put("istPrimzahl", "istGerade");
    }
    
    public void empfangen(String s) {
        System.out.println("Steuerung empfaengt: "+s);
        //eine Ziffer
        if ( s=="0" || s=="1" || s=="2" || s=="3" || s=="4" || s=="5" || s=="6" || s=="7" || s=="8" || s=="9" || s=="." ) {
            if (zustand==0) {
                zustand = 1;
                ausgabe=s;
                operand1=umformenInZahl(ausgabe);
            } 
            else if (zustand==1) {
                ausgabe=ausgabe.concat(s);
                operand1=umformenInZahl(ausgabe);                    
            }
            else if (zustand==2) {
                zustand = 3;
                ausgabe=s;
                operand2=umformenInZahl(ausgabe);
            }
            else if (zustand==3) { 
                ausgabe=ausgabe.concat(s);
                operand2=umformenInZahl(ausgabe);
            }           
        }
        //ein zweiwertiger Operator
        else if ( zweiwertigeOperatoren.containsKey(s) ) {
            if ( zustand==0 || zustand==1 ) {
                aktuelleRechenart = zweiwertigeOperatoren.get(s);
                zustand = 2;
                ausgabe=s;
            } 
            else if ( zustand==2) {
                aktuelleRechenart = zweiwertigeOperatoren.get(s);
                ausgabe = s;
            }
            else if ( zustand ==3 ) {
                zustand = 2;
                operand1=rechnen(operand1,aktuelleRechenart,operand2);                        
                ausgabe=umformenInString(operand1);
                aktuelleRechenart = zweiwertigeOperatoren.get(s);
            }
        }
        //ein einwertiger Operator
        else if ( einwertigeOperatoren.containsKey(s) ) {
            if ( zustand == 0 || zustand == 1 ) {
                aktuelleRechenart=einwertigeOperatoren.get(s);
                zustand = 3;
                operand1=rechnen(operand1,aktuelleRechenart,0);
                ausgabe=umformenInString(operand1);                
            } 
            else if ( zustand == 2  ) {
                operand1=rechnen(operand1,einwertigeOperatoren.get(s),0); //check
                ausgabe=umformenInString(operand1);
            }                                                   
            else if ( zustand==3 ) {
                zustand = 2;
                operand2=rechnen(operand2,einwertigeOperatoren.get(s),0); //check
                ausgabe=umformenInString(operand2);                
            }                                                   
        }
        //eine Funktion mit booleschem Rueckgabetyp
        else if ( einwertigeBoolescheOperatoren.containsKey(s) ) {
            if ( zustand == 0 || zustand == 1 ) {
                aktuelleRechenart = einwertigeBoolescheOperatoren.get(s);
                zustand = 0;
                ausgabe = rechnenBoolean(operand1,aktuelleRechenart,0);
            } 
            else if ( zustand == 2 || zustand == 3  ) {
                aktuelleRechenart = einwertigeBoolescheOperatoren.get(s);
                zustand = 2;                
                ausgabe = rechnenBoolean(operand2,aktuelleRechenart,0);
            }                                                   
        }
                
       //Sonderfall: =
       else if (s=="=") {
            if ( zustand==0 || zustand==1 ) { 
                zustand = 1;
            }
            else if ( zustand == 2 || zustand==3 ) {
                zustand = 0;
                operand1=rechnen(operand1, aktuelleRechenart, operand2);
                ausgabe=umformenInString(operand1);
            }
        }
        //Sonderfall: Loeschen
        else if (s=="AC") {
            zustand = 0;
            ausgabe = "0";
            operand1=0;
            operand2=0;
        }
        //Sonderfall: Backspace
        else if (s=="DEL") {
            if (zustand==0) {
            } 
            else if (zustand==1) {
                if (ausgabe.length()>1) {
                    ausgabe = ausgabe.substring(0,ausgabe.length()-1);
                    operand1=umformenInZahl(ausgabe);
                }
                else {
                    zustand = 0;
                    operand1=0;;
                }
            }
            else if (zustand==2) {
            }
            else if (zustand==3) {
                if (ausgabe.length()>1) {
                    ausgabe = ausgabe.substring(0,ausgabe.length()-1);
                    operand2=umformenInZahl(ausgabe);
                }
                else {
                    zustand=2;
                    ausgabe = "0";
                    operand2=0;
                }                
            }                               
        }
        //unbekanntes Zeichen
        else {
            if ( zustand == 0 || zustand == 1) {
                zustand = 0;
                ausgabe="Noch nicht implementiert.";
            }
            else if ( zustand == 2 || zustand == 3)  {
                zustand = 2;
                ausgabe="Noch nicht implementiert.";
            }
        }
        //Der aktuelle Wert des Attributs "ausgabe" wird an das GUI geschickt.
        if (gui!= null) gui.ausgeben(ausgabe);
        else System.out.println("Bidschirm sagt: " + ausgabe); 

        System.out.println("Op1: "+operand1+", Op2: "+operand2+ ", Operator: "+aktuelleRechenart); //test
        System.out.println("Zustand: "+zustand); //test
        System.out.println("----"); //test

    }
    

    /**
     * Diese Methode beauftragt den eigentlichen Rechner, die Rechung durchzufuehren,
     * und gibt eine Zahl als Antwort zurueck. Nicht fuer Boolesche Rechnungen.
     */
    private double rechnen(double zahl1, String rechenart, double zahl2) {
        //sicherheitshalber
        if (rechner==null) return -1;
        
        double ergebnis = 0;
        
        //zweistellige Funktionen
        if (rechenart=="addieren") ergebnis = rechner.addieren(zahl1, zahl2);
        else if (rechenart=="subtrahieren") ergebnis = rechner.subtrahieren(zahl1, zahl2);
        else if (rechenart=="multiplizieren") ergebnis = rechner.multiplizieren(zahl1, zahl2);
        else if (rechenart=="dividieren") ergebnis = rechner.dividieren(zahl1, zahl2);
        else if (rechenart=="ggT") ergebnis = rechner.ggT((int)zahl1, (int)zahl2);
        else if (rechenart=="kgV") ergebnis = rechner.kgV((int)zahl1, (int)zahl2);
        else if (rechenart=="potenz") ergebnis = rechner.potenz(zahl1, (int)zahl2);        
        else if (rechenart=="modulo") ergebnis = rechner.modulo((int) zahl1, (int) zahl2);
        else if (rechenart=="malZehnHoch") ergebnis = rechner.malZehnHoch(zahl1, (int) zahl2);
        else if (rechenart=="summeVonBis") ergebnis = rechner.summeVonBis((int) zahl1, (int) zahl2);
        
        //einstellige Funktionen
        else if (rechenart=="prozent") ergebnis = rechner.prozent(zahl1);
        else if (rechenart=="negation") ergebnis = rechner.negation(zahl1);
        else if (rechenart=="quadratwurzel") ergebnis = rechner.quadratwurzel(zahl1);
        else if (rechenart=="fakultaet") ergebnis = rechner.fakultaet((int) zahl1);
        else if (rechenart=="betrag") ergebnis = rechner.betrag(zahl1);
        else if (rechenart=="kehrwert") ergebnis = rechner.kehrwert(zahl1);
        else if (rechenart=="hochDrei") ergebnis = rechner.hochDrei(zahl1);
        else if (rechenart=="quadrat") ergebnis = rechner.quadrat(zahl1);
        else if (rechenart=="zehnHoch") ergebnis = rechner.zehnHoch(zahl1);
        else if (rechenart=="sinus") ergebnis = rechner.sinus(zahl1);
        else if (rechenart=="cosinus") ergebnis = rechner.cosinus(zahl1);
        else if (rechenart=="tangens") ergebnis = rechner.tangens(zahl1);
        else if (rechenart=="collatz") ergebnis = rechner.collatz((int)zahl1);
        else if (rechenart=="fibonacci") ergebnis = rechner.fibonacci((int)zahl1);

        return ergebnis;
    }
    
    /**
     * Diese Methode beauftragt den eigentlichen Rechner, die Rechung durchzufuehren,
     * und gibt einen String als Antwort zurueck. Nur fuer Boolesche Rechnungen.
     */
    private String rechnenBoolean(double zahl1, String rechenart, double zahl2) {
        //Sicherheitshalber:
        if (rechner==null) return "Kein Rechner da.";

        String  ergebnis ="";

        if (rechenart=="istPrimzahl") ergebnis = ""+rechner.istPrimzahl((int)zahl1);
        else if (rechenart=="istGerade") ergebnis = ""+rechner.istGerade((int)zahl1);

        return ergebnis;
    }

    /**
     * Diese Funktion wandelt eine Kommazahl in einen String um und entfernt dabei ein .0 nach dem Komma
     */
    private String umformenInString(double d) {
        //umwandeln:
        String s = String.valueOf(d);    
        //Komma entfernen:
        if (s.length()>2) {
            if (s.charAt(s.length()-2)=='.') {
                if (s.charAt(s.length()-1)=='0') {
                    s=s.substring(0,s.length()-2);
                }
            }
        }
        return s;
    }
    /**
     *  Diese Funktion wandelt einen String in eine Zahl um.
     */
    private double umformenInZahl(String s) {
        return Double.parseDouble(s);
    }
    

}
    