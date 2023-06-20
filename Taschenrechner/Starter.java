public class Starter
{
    //ANlegen der Attribute
    public GUI gui;
    public Steuerung steuerung;
    public Calculator rechner;

    public Starter() {
        this("Taschenrechner");
    }
    
    public Starter(String s) {
        //Anlegen der drei Objekte / Initialisieren der Attribute
        rechner =  new Taschenrechner();
        steuerung = new SteuerungAutomat();
        gui = new GUI_Schueler (s);

        //Miteinanderbekanntmachen der Elemente
        gui.steuerungSetzen(steuerung);
        steuerung.gui= gui;
        steuerung.rechner = rechner;
    }

    public static void main(String[] args) {
        new Starter("Taschenrechner");
    }
}
