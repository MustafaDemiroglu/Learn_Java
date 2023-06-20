public class Taschenrechner extends Calculator
{
    //Attribute
    
    //Konstruktor
    public Taschenrechner() {
    }

    //Methoden
    double addieren(double a, double b) {
        return a+b;
    }  

    double subtrahieren(double a, double b) {
        return a-b;
    }  
    
    double negation(double a) {
        return -a;
    }  
    
    double quadrat(double a) {
        return a*a;
    }
    
    
}
