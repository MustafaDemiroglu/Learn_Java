public abstract class Calculator 
{
    //Attribute
    
    //Konstruktor
    public Calculator() {
    }

    //Einfach: Grundrechenarten
    double addieren(double a, double b) { return 99; }
    double subtrahieren(double a, double b) { return 99; }
    double multiplizieren(double a, double b) { return 99; }
    double dividieren(double a, double b) { return 99; }
    
    //Einfach: Leichte Sachen 
    double negation(double a) { return 99;}
    double kehrwert(double a) { return 99;}
    double hochDrei(double a) { return 99;}
    double quadrat(double a) { return 99;}
    double prozent(double a) { return 99; } //geaendert!
    
    //Leicht: Mit bedingter Anweisung (if)
    double betrag(double a) { return 99;}
    //Leicht - aber nur, wenn man zuerst die modulo-Funktion hat und diese dann verwendet!!
    boolean istGerade(int a) { return false; }
       
    //Etwas schwerer, mit while-Scheife zu loesen
    double potenz(double basis, int exponent) { return 99;}
    int modulo(int a, int b) { return 99; }
    int fakultaet(int a) { return 99; }
    double summeVonBis(int a, int b) { return 99; } //oder mit der Formel, dann leicht - solle eher int sein,
    
    //Leicht, wenn man zuerst potenz hat!   
    double zehnHoch(double a) { return 99;}
    double malZehnHoch(double a, int b) { return 99;} //geaendert!

    //Noch etwas schwieriger - Grundwissen benutzen oder bei Wikipedia nachschauen, aber mit while alles machbar
    double quadratwurzel(double a) { return 99; }
    int ggT(int a, int b) { return 99; }
    int kgV(int a, int b) { return 99; } //dazu erst den ggT machen und verwenden!
    int fibonacci(int a) { return 99;}
    boolean istPrimzahl(int a) { return false; } // wenn a 1 ist => false, sonst while-Schleife und a durch alle
    //zahlen, die kleiner als a sind, teilen - sobald einmal Rest 0 herauskommt => false, sonst: true
    
    //Winkelfunktionen, da muesste ich selber nachschauen
    double sinus(double a) { return 99; }
    double cosinus(double a) { return 99; }
    double tangens(double a) { return 99; }
    
    
    //speziell
    int collatz(int a) { return 99; }
    
    //nicht verwendet
//    double summeVon99Bis(int a) { return 99; }
//    double max(double a, double b) {return 99;}
//    double min(double a, double b) { return 99; }
//    double quadrat(int a) { return 99; }    
//    double wurzel(int a, int b) { return 99; }
//    double pi() { return 99; }
    
    
}
