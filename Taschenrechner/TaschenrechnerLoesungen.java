public class TaschenrechnerLoesungen extends Calculator
{
    //Attribute
    
    //Konstruktor
    public TaschenrechnerLoesungen() {
    }

    //Methoden
    
    //Einfach: Grundrechenarten
    double addieren(double a, double b) { return a+b; }
    double subtrahieren(double a, double b) { return a-b; }
    double multiplizieren(double a, double b) { return a*b; }
    double dividieren(double a, double b) { return a/b; }
    
    //Einfach: Leichte Sachen 
    double negation(double a) { return -a;}
    double kehrwert(double a) { return 1/a;}
    double hochDrei(double a) { return a*a*a;}
    double quadrat(double a) { return a*a;}
    double prozent(double a) { return a/100; } //geaendert!
    
    //Leicht: Mit bedingter Anweisung (if)
    double betrag(double a) { 
        if (a>0) { return a; }
        else { return -a; }
    }
    //Leicht - aber nur, wenn man zuerst die modulo-Funktion hat und diese dann verwendet!!
    boolean istGerade(int a) {
        if (modulo(a,2)==0) { return true; }
        else { return false; }
    }
       
    //Etwas schwerer, mit while-Scheife zu loesen
    double potenz(double basis, int exponent) {
        double erg = 1;
        while (exponent>0) {
            erg = erg* basis;
            exponent = exponent -1;
        }
        return erg;
    }
    int modulo(int a, int b) {
        while (a>=b) {
            a=a-b;
        }
        return a;
    }
    int fakultaet(int a) { 
        int erg = 1;
        int i = 1;
        while (a>=i) {
            erg = erg*i;
            i=i+1;
        }
        return erg;
    }
    //sollte eigentlich int als Rueckgabetyp haben
    double summeVonBis(int a, int b) { 
        double erg = 0;
        while (a<=b) {
            erg = erg + a;
            a=a+1;
        }
        return erg;
    } //oder mit der Formel, dann leicht
    
    double zehnHoch(double a) { 
        double erg=10;
        int i = 1;
        while (i<a) {
            erg = erg*10;
            i=i+1;
        }
        return erg;
    }
    double malZehnHoch(double a, int b) { return a * zehnHoch(b);} //geaendert!

    //Noch etwas schwieriger - Grundwissen benutzen oder bei Wikipedia nachschauen, aber mit while alles machbar
    double quadratwurzel(double a) { return 99; }
    int ggT(int a, int b) {
        while (b>0) {
            if (a>b) {
                a=a-b;
            }
            else {
                b = b-a;
            }
        }
        return a;
    }
    int kgV(int a, int b) {
        return a * (b / ggT(a,b));
    } //dazu erst den ggT machen und verwenden!
    int fibonacci(int a) { return 99;}
    boolean istPrimzahl(int a) {
        if (a<2) return false;
        int i=2;
        while (i<a) {
            if (a%i==0) return false;
            i=i+1;
        }
        return true;
    }
    
    //Winkelfunktionen, da muesste ich selber nachschauen
    double sinus (double x) {
        //umrechnen in bogenmaß, da die Formel das verlangt
        x = x*Math.PI/180;
        int n = 0;
        double erg = 0;
        while (n<10) {
            erg = erg+ potenz(-1,n)*potenz(x,2*n+1)/fakultaet(2*n+1);
            n = n+1;
            System.out.println(erg);
        }
        return erg;
    }
    double cosinus(double a) { return 99; }
    double tangens(double a) { return 99; }
    
    
    //speziell
    int collatz(int a) { return 99; }
    
   
    
}
