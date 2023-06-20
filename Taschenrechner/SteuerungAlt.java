public class SteuerungAlt extends Steuerung
{
    //
    // Das ist eine haessliche Klasse! Entschuldigung.
    // Wer neue Rechenmethoden haben will, muss an zwei Stellen etwas aendern: Bei der empfangen-Methode, und bei der
    // rechnen-Methode. Die empfangen-Methode nimmt zB ein eingehendes "+" und merkt sich das als "addition". Warum der Unterschied?
    // Das eine ist das Zeichen, das reinkommt und hat nur mit dem GUI zu tun, das andere ist das Merken der Rechenart fuer
    // spaeter und ist eine rein steuerungsinterne Sache. Der String mit der gemerkten Rechenart taucht dann in der rechnen-Methode
    // wieder auf.
    //
    
    //die drei Dinge, die man fuers Rechnen braucht
    double operand1 = 0; //der erste Operand
    double operand2 = 0; //der zweite Operand
    String aktuelleRechenart;

    //zwei Attribute, die den Zustand bestimmen
    boolean anhaengen = false; //davon haengt ab, ob eine Ziffer hinten angehaengt wird oder eine neue Zahl begonnen wird
    boolean operand1_aktiv = true; //Es gibt eigentlich nur 2 Moeglichkeiten: Eingabe der ersten Zahl, Eingabe der zweiten Zahl.

    //was an das GUI gesendet wird
    String ausgabe ="0"; 
    
    
    /**
     * Diese Methode empfaengt eine Stringnachricht, und je nach Inhalt der Nachricht wird die
     * Verarbeitung an weitere Methoden delegiert.
     * Wenn der eingegangene String fuer einen Operator steht, wird die dazu gehoerende Methode als
     * Attribut "aktuelleRechenart" gespeichert - so umstaendlich, weil ich in Java die spaeter auszufuehrende
     * Methode nicht direktals Attribut speichern kann.
     * 
     * @param s Das eingehende Signal
     * 
     */
    public void empfangen(String s) {
        //System.out.println("Empfangenes Signal: " +s);

        if (s=="0") { zahlVerarbeiten(s); }
        else if (s=="1") { zahlVerarbeiten(s); }
        else if (s=="2") { zahlVerarbeiten(s); }
        else if (s=="3") { zahlVerarbeiten(s); }
        else if (s=="4") { zahlVerarbeiten(s); }
        else if (s=="5") { zahlVerarbeiten(s); }
        else if (s=="6") { zahlVerarbeiten(s); }
        else if (s=="7") { zahlVerarbeiten(s); }
        else if (s=="8") { zahlVerarbeiten(s); }
        else if (s=="9") { zahlVerarbeiten(s); }
        else if (s==".") { zahlVerarbeiten(s); }

        else if (s=="+") { aktuelleRechenart = "addition"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="-") { aktuelleRechenart = "subtraktion"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="/") { aktuelleRechenart = "divison"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="x") { aktuelleRechenart = "multiplikation"; zweistelligeFunktionVerarbeiten(s); } //multiplizieren
        else if (s=="mod") { aktuelleRechenart = "modulo"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="E") { aktuelleRechenart = "summenfunktion"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="kgV") { aktuelleRechenart = "kgV"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="exp") { aktuelleRechenart = "potenz"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="ggT") { aktuelleRechenart = "ggT"; zweistelligeFunktionVerarbeiten(s); } 
        else if (s=="mal10^x") { aktuelleRechenart = "mal10hochx"; zweistelligeFunktionVerarbeiten(s); } 
               
        else if (s=="root") { aktuelleRechenart = "quadratwurzel"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="!") { aktuelleRechenart = "fakultaet"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="abs") { aktuelleRechenart = "betrag"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="x^-1") { aktuelleRechenart = "kehrwert"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="x^3") { aktuelleRechenart = "hoch3"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="x^2") { aktuelleRechenart = "quadrat"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="sin") { aktuelleRechenart = "sinus"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="cos") { aktuelleRechenart = "cosinus"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="tan") { aktuelleRechenart = "tangens"; einstelligeFunktionVerarbeiten(s); } 
        else if (s=="collatz") { aktuelleRechenart = "collatz"; einstelligeFunktionVerarbeiten(s); }
        else if (s=="fibonacci") { aktuelleRechenart = "fibonacci"; einstelligeFunktionVerarbeiten(s); }
        else if (s=="(-)") { aktuelleRechenart = "negation"; einstelligeFunktionVerarbeiten(s); }
        else if (s=="%") { aktuelleRechenart = "prozent"; einstelligeFunktionVerarbeiten(s); }
        else if (s=="10^x") { aktuelleRechenart = "zehnHoch"; einstelligeFunktionVerarbeiten(s); }
        
        else if (s=="prim?") { aktuelleRechenart ="ist prim"; booleanEinstelligVerarbeiten(s); }
        else if (s=="even?") { aktuelleRechenart = "ist gerade"; booleanEinstelligVerarbeiten(s); }       
        
        //Taste "="
        else if (s=="=") {
            if (operand1_aktiv) {
                operand1_aktiv = true; //eigtl ueberfluessig
                anhaengen = false;
                ausgabe=ausgabe;
                operand1=Double.parseDouble(ausgabe);
            }
            else if (!operand1_aktiv) {
                anhaengen=false;
                operand1_aktiv=true;                
                operand1=rechnen(operand1, aktuelleRechenart, operand2); //was passiert bei 4 + =                
                ausgabe=String.valueOf(operand1);
                //.0 entfernen
                ausgabe = kommaEntfernen(ausgabe);
            }
        }
        //Taste "Loeschen"
        else if (s=="AC") {
            anhaengen=false;
            ausgabe = "0";
            operand1=0;
            operand2=0;
        }
        //Taste "letztes Zeichen loeschen"
        else if (s=="DEL") {
            if (anhaengen && operand1_aktiv) {
                if (ausgabe.length()>1) {
                    ausgabe = ausgabe.substring(0,ausgabe.length()-1);
                    operand1=Double.parseDouble(ausgabe);
                }
                else {
                    ausgabe = "0";
                    operand1=0;
                    anhaengen = false;
                }
            }
            else if (anhaengen && !operand1_aktiv) {
                if (ausgabe.length()>1) {
                    ausgabe = ausgabe.substring(0,ausgabe.length()-1);
                    operand2=Double.parseDouble(ausgabe);
                }
                else {
                    ausgabe = "0";
                    operand2=0;
                    anhaengen = false;
                }
            }
        }
        else {
            ausgabe="Noch nicht implementiert.";
            anhaengen = false;
        }        
        //Der aktuelle Wert des Attributs "ausgabe" wird an das GUI geschickt.
        if (gui!= null) {
            gui.ausgeben(ausgabe);
        }
        else {
            System.out.println("Bidschirm sagt: " + ausgabe);
        }

    }
        
    //wenn eine Zahl hereinkommt, soll sie an die vorherige Zahl angehaengt werden,
    //oder wenn das unmittelbar nach einer Operatoreingabe geschieht, soll die Eingabe
    //einer neuen Zahl begonnen werden
    void zahlVerarbeiten(String s) {
        if (operand1_aktiv) {
            if (!anhaengen) {
                anhaengen = true;
                ausgabe=s;
                operand1=Double.parseDouble(ausgabe);
            }
            else {
                ausgabe=ausgabe.concat(s);
                operand1=Double.parseDouble(ausgabe);
            }
        }
        else if (!operand1_aktiv) {
            if (!anhaengen) {
                anhaengen = true;
                ausgabe=s;
                operand2=Double.parseDouble(ausgabe);
            }
            else {
                ausgabe=ausgabe.concat(s);
                operand2=Double.parseDouble(ausgabe);
            }                
        }
    }


    //die beiden gespeicherten Zahlen werden verrechnet - wenn bisher nur
    //eine Zahl gespeichert ist, wird auf die zweite gewartet
    void zweistelligeFunktionVerarbeiten(String s) {
        //typischer Fall: 1 +
        if (operand1_aktiv) {
            operand1_aktiv=false;
            anhaengen=false;
            ausgabe=s;
        }
        //typischer Fall: 1 + 3 + 
        else if (!operand1_aktiv) {
            anhaengen=false;
            operand1_aktiv=false;
            operand1=rechnen(operand1,aktuelleRechenart,operand2);                        
            ausgabe=String.valueOf(operand1);
            //.0 entfernen
            ausgabe = kommaEntfernen(ausgabe);
        }

    }


    //die gespeicherte Zahl wird verrechnet
    void einstelligeFunktionVerarbeiten(String s) {
        //typischer Fall: 4!
        if (operand1_aktiv) {
            operand1_aktiv=true; //eigtl ueberfluessig
            anhaengen=false;
            operand1=rechnen(operand1,aktuelleRechenart,0);
            ausgabe=String.valueOf(operand1);    
            //.0 entfernen
            ausgabe = kommaEntfernen(ausgabe);
        }
        //typischer Fall: 3 + 1 !
        else if (!operand1_aktiv) { 
            operand1_aktiv=false; //eigtl. ueberfluessig
            anhaengen=false;
            operand2=rechnen(operand2,aktuelleRechenart,0);
            ausgabe=String.valueOf(operand2);                
            //.0 entfernen
            ausgabe = kommaEntfernen(ausgabe);
        }
    }

    void booleanEinstelligVerarbeiten(String s) {
        //typischer Fall: 1 prim?
        if (operand1_aktiv) {
            operand1_aktiv = true; //eigtl ueberfluessig
            anhaengen=false;
            operand1=rechnen(operand1,aktuelleRechenart,0);
            if (operand1==0) ausgabe = "false";
            else ausgabe = "true";
        }
        //typischer Fall: 1 + 3 prim?
        else if (!operand1_aktiv) { 
            operand1_aktiv=false; //eigtl. ueberfluessig
            anhaengen=false;
            operand2=rechnen(operand2,aktuelleRechenart,0);
            if (operand2==0) ausgabe = "false";
            else ausgabe = "true";
        }
    }

    
    



    /**
     * Diese Methode beauftragt den eigentlichen Rechner, die Rechung durchzufuehren,
     * und gibt eine Zahl als Antwort zurueck.
     */
    double rechnen(double zahl1, String aktuelleRechenart, double zahl2) {
        //sicherheitshalber
        if (rechner==null) return -1;
        
        //fehlt jeweils noch: Kontrolle des Definitionsbereichs, etwa bei Div/0
        double ergebnis = 0;
        
        //zweistellige Funktionen
        if (aktuelleRechenart=="addition") ergebnis = rechner.addieren(zahl1, zahl2);
        else if (aktuelleRechenart=="subtraktion") ergebnis = rechner.subtrahieren(zahl1, zahl2);
        else if (aktuelleRechenart=="multiplikation") ergebnis = rechner.multiplizieren(zahl1, zahl2);
        else if (aktuelleRechenart=="division") ergebnis = rechner.dividieren(zahl1, zahl2);
        else if (aktuelleRechenart=="ggT") ergebnis = rechner.ggT((int)zahl1, (int)zahl2);
        else if (aktuelleRechenart=="kgV") ergebnis = rechner.kgV((int)zahl1, (int)zahl2);
        else if (aktuelleRechenart=="potenz") ergebnis = rechner.potenz(zahl1, (int)zahl2);        
        else if (aktuelleRechenart=="modulo") ergebnis = rechner.modulo((int) zahl1, (int) zahl2);
        else if (aktuelleRechenart=="mal10^x") ergebnis = rechner.malZehnHoch(zahl1, (int) zahl2);
        else if (aktuelleRechenart=="summenfunktion") ergebnis = rechner.summeVonBis((int) zahl1, (int) zahl2);
        
        //einstellige Funktionen
        else if (aktuelleRechenart=="prozent") ergebnis = rechner.prozent(zahl1);
        else if (aktuelleRechenart=="negation") ergebnis = rechner.negation(zahl1);
        else if (aktuelleRechenart=="quadratwurzel") ergebnis = rechner.quadratwurzel(zahl1);
        else if (aktuelleRechenart=="fakultaet") ergebnis = rechner.fakultaet((int) zahl1);
        else if (aktuelleRechenart=="betrag") ergebnis = rechner.betrag(zahl1);
        else if (aktuelleRechenart=="kehrwert") ergebnis = rechner.kehrwert(zahl1);
        else if (aktuelleRechenart=="hoch3") ergebnis = rechner.hochDrei(zahl1);
        else if (aktuelleRechenart=="quadrat") ergebnis = rechner.quadrat(zahl1);
        else if (aktuelleRechenart=="zehnHoch") ergebnis = rechner.zehnHoch(zahl1);
        else if (aktuelleRechenart=="sinus") ergebnis = rechner.sinus(zahl1);
        else if (aktuelleRechenart=="cosinus") ergebnis = rechner.cosinus(zahl1);
        else if (aktuelleRechenart=="tangens") ergebnis = rechner.tangens(zahl1);
        else if (aktuelleRechenart=="collatz") ergebnis = rechner.collatz((int)zahl1);
        else if (aktuelleRechenart=="fibonacci") ergebnis = rechner.fibonacci((int)zahl1);

        //boolean einstellig - umrechnen noetig, da eine Zahl herauskommen soll
        else if (aktuelleRechenart=="ist prim") {
            boolean b = rechner.istPrimzahl((int)zahl1);
            if (b) ergebnis = 1;
            else ergebnis = 0;
        }
        else if (aktuelleRechenart=="ist gerade") {
            boolean b = rechner.istGerade((int)zahl1);
            if (b) ergebnis = 1;
            else ergebnis = 0;
        }
        return ergebnis;
    }

    

    /**
     * Diese Funktion schneidet bei einem Ergebnis von x.0 das .0 weg.
     */
    String kommaEntfernen(String s) {
        if (s.length()>2) {
            if (s.charAt(s.length()-2)=='.') {
                if (s.charAt(s.length()-1)=='0') {
                    s=s.substring(0,s.length()-2);
                }
            }
        }
        return s;
    }
    

}
    