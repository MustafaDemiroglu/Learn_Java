
/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 30.10.2012
  * @author
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_Schueler extends JFrame implements GUI {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();
  private JButton jButton6 = new JButton();
  private JButton jButton7 = new JButton();
  private JButton jButton8 = new JButton();
  private JButton jButton9 = new JButton();
  private JButton jButton10 = new JButton();
  private JButton jButton11 = new JButton();
  private JButton jButton12 = new JButton();
  private JButton jButton13 = new JButton();
  private JButton jButton14 = new JButton();
  private JButton jButton15 = new JButton();
  private JButton jButton16 = new JButton();
  private JButton jButton17 = new JButton();
  private JButton jButton18 = new JButton();
  private JButton jButton19 = new JButton();
  private JButton jButton20 = new JButton();
  private JButton jButton21 = new JButton();
  private JButton jButton22 = new JButton();
  private JButton jButton23 = new JButton();
  private JButton jButton24 = new JButton();
  private JButton jButton25 = new JButton();
  private JButton jButton26 = new JButton();
  private JButton jButton27 = new JButton();
  private JButton jButton28 = new JButton();
  private JButton jButton29 = new JButton();
  private JButton jButton30 = new JButton();
  private JButton jButton31 = new JButton();
  private JButton jButton32 = new JButton();
  private JButton jButton33 = new JButton();
  private JButton jButton34 = new JButton();
  private JButton jButton35 = new JButton();
  private JButton jButton36 = new JButton();
  private JButton jButton37 = new JButton();
  private JButton jButton38 = new JButton();
  private JButton jButton39 = new JButton();
  private JButton jButton40 = new JButton();
  private JButton jButton41 = new JButton();
  private JButton jButton42 = new JButton();
  private JButton jButton43 = new JButton();
  private JButton jButton44 = new JButton();
  private JButton jButton45 = new JButton();
  private JButton jButton46 = new JButton();
  private JButton jButton47 = new JButton();
  private JButton jButton48 = new JButton();
  private JButton jButton49 = new JButton();
  private JButton jButton50 = new JButton();
  private JTextField jTextField1 = new JTextField();

  Steuerung steuerung;

  // Ende Attribute
public GUI_Schueler(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 481;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    
    jButton1.setBounds(16, 80, 43, 25);
    jButton1.setText("ggT");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(72, 80, 43, 25);
    jButton2.setText("!");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(192, 80, 43, 25);
    jButton3.setText("\u03A3"); //Sigma E
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jButton4.setBounds(248, 80, 43, 25);
    jButton4.setText("ON");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(jButton4);
    jButton5.setBounds(120, 104, 19, 17);
    jButton5.setText("<");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton5_ActionPerformed(evt);
      }
    });
    cp.add(jButton5);
    jButton6.setBounds(168, 104, 19, 17);
    jButton6.setText(">");
    jButton6.setMargin(new Insets(2, 2, 2, 2));
    jButton6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton6_ActionPerformed(evt);
      }
    });
    cp.add(jButton6);
    jButton7.setBounds(144, 88, 19, 17);
    jButton7.setText("^");
    jButton7.setMargin(new Insets(2, 2, 2, 2));
    jButton7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton7_ActionPerformed(evt);
      }
    });
    cp.add(jButton7);
    jButton8.setBounds(144, 120, 19, 17);
    jButton8.setText("v");
    jButton8.setMargin(new Insets(2, 2, 2, 2));
    jButton8.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton8_ActionPerformed(evt);
      }
    });
    cp.add(jButton8);
    jButton9.setBounds(24, 128, 43, 25);
    jButton9.setText("AC");
    jButton9.setMargin(new Insets(2, 2, 2, 2));
    jButton9.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton9_ActionPerformed(evt);
      }
    });
    cp.add(jButton9);
    jButton10.setBounds(184, 136, 43, 25);
    jButton10.setText("x\u207B\u00B9");//x^-1
    jButton10.setMargin(new Insets(2, 2, 2, 2));
    jButton10.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton10_ActionPerformed(evt);
      }
    });
    cp.add(jButton10);
    jButton11.setBounds(240, 128, 43, 25);
    jButton11.setText("x\u207F"); //exp, x^y
    jButton11.setMargin(new Insets(2, 2, 2, 2));
    jButton11.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton11_ActionPerformed(evt);
      }
    });
    cp.add(jButton11);
    jButton12.setBounds(80, 136, 43, 25);
    jButton12.setText("x\u00B3"); //x^3
    jButton12.setMargin(new Insets(2, 2, 2, 2));
    jButton12.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton12_ActionPerformed(evt);
      }
    });
    cp.add(jButton12);
    jButton13.setBounds(64, 176, 35, 25);
    jButton13.setText("\u00B2\u221A");//root
    jButton13.setMargin(new Insets(2, 2, 2, 2));
    jButton13.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton13_ActionPerformed(evt);
      }
    });
    cp.add(jButton13);
    jButton14.setBounds(208, 176, 35, 25);
    jButton14.setText("10\u207F");//10^x
    jButton14.setMargin(new Insets(2, 2, 2, 2));
    jButton14.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton14_ActionPerformed(evt);
      }
    });
    cp.add(jButton14);
    jButton15.setBounds(256, 176, 35, 25);
    jButton15.setText("prim?");
    jButton15.setMargin(new Insets(2, 2, 2, 2));
    jButton15.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton15_ActionPerformed(evt);
      }
    });
    cp.add(jButton15);
    jButton16.setBounds(112, 176, 35, 25);
    jButton16.setText("x\u00B2"); //x^2
    jButton16.setMargin(new Insets(2, 2, 2, 2));
    jButton16.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton16_ActionPerformed(evt);
      }
    });
    cp.add(jButton16);
    jButton17.setBounds(16, 176, 35, 25);
    jButton17.setText("x/y");
    jButton17.setMargin(new Insets(2, 2, 2, 2));
    jButton17.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton17_ActionPerformed(evt);
      }
    });
    cp.add(jButton17);
    jButton18.setBounds(160, 176, 35, 25);
    jButton18.setText("%");
    jButton18.setMargin(new Insets(2, 2, 2, 2));
    jButton18.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton18_ActionPerformed(evt);
      }
    });
    cp.add(jButton18);
    jButton19.setBounds(16, 216, 35, 25);
    jButton19.setText("(-)");
    jButton19.setMargin(new Insets(2, 2, 2, 2));
    jButton19.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton19_ActionPerformed(evt);
      }
    });
    cp.add(jButton19);
    jButton20.setBounds(208, 216, 35, 25);
    jButton20.setText("even?");
    jButton20.setMargin(new Insets(2, 2, 2, 2));
    jButton20.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton20_ActionPerformed(evt);
      }
    });
    cp.add(jButton20);
    jButton21.setBounds(160, 216, 35, 25);
    jButton21.setText("kgV");
    jButton21.setMargin(new Insets(2, 2, 2, 2));
    jButton21.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton21_ActionPerformed(evt);
      }
    });
    cp.add(jButton21);
    jButton22.setBounds(64, 216, 35, 25);
    jButton22.setText("sin");
    jButton22.setMargin(new Insets(2, 2, 2, 2));
    jButton22.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton22_ActionPerformed(evt);
      }
    });
    cp.add(jButton22);
    jButton23.setBounds(112, 216, 35, 25);
    jButton23.setText("cos");
    jButton23.setMargin(new Insets(2, 2, 2, 2));
    jButton23.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton23_ActionPerformed(evt);
      }
    });
    cp.add(jButton23);
    jButton24.setBounds(256, 216, 35, 25);
    jButton24.setText("tan");
    jButton24.setMargin(new Insets(2, 2, 2, 2));
    jButton24.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton24_ActionPerformed(evt);
      }
    });
    cp.add(jButton24);
    jButton25.setBounds(16, 256, 35, 25);
    jButton25.setText("modulo");
    jButton25.setMargin(new Insets(2, 2, 2, 2));
    jButton25.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton25_ActionPerformed(evt);
      }
    });
    cp.add(jButton25);
    jButton26.setBounds(112, 256, 35, 25);
    jButton26.setText("(");
    jButton26.setMargin(new Insets(2, 2, 2, 2));
    jButton26.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton26_ActionPerformed(evt);
      }
    });
    cp.add(jButton26);
    jButton27.setBounds(64, 256, 35, 25);
    jButton27.setText("collatz");
    jButton27.setMargin(new Insets(2, 2, 2, 2));
    jButton27.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton27_ActionPerformed(evt);
      }
    });
    cp.add(jButton27);
    jButton28.setBounds(256, 256, 35, 25);
    jButton28.setText("M+");
    jButton28.setMargin(new Insets(2, 2, 2, 2));
    jButton28.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton28_ActionPerformed(evt);
      }
    });
    cp.add(jButton28);
    jButton29.setBounds(208, 256, 35, 25);
    jButton29.setText("fibonacci");
    jButton29.setMargin(new Insets(2, 2, 2, 2));
    jButton29.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton29_ActionPerformed(evt);
      }
    });
    cp.add(jButton29);
    jButton30.setBounds(160, 256, 35, 25);
    jButton30.setText(")");
    jButton30.setMargin(new Insets(2, 2, 2, 2));
    jButton30.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton30_ActionPerformed(evt);
      }
    });
    cp.add(jButton30);
    jButton31.setBounds(16, 304, 51, 25);
    jButton31.setText("7");
    jButton31.setMargin(new Insets(2, 2, 2, 2));
    jButton31.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton31_ActionPerformed(evt);
      }
    });
    cp.add(jButton31);
    jButton32.setBounds(16, 336, 51, 25);
    jButton32.setText("4");
    jButton32.setMargin(new Insets(2, 2, 2, 2));
    jButton32.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton32_ActionPerformed(evt);
      }
    });
    cp.add(jButton32);
    jButton33.setBounds(16, 368, 51, 25);
    jButton33.setText("1");
    jButton33.setMargin(new Insets(2, 2, 2, 2));
    jButton33.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton33_ActionPerformed(evt);
      }
    });
    cp.add(jButton33);
    jButton34.setBounds(16, 400, 51, 25);
    jButton34.setText("0");
    jButton34.setMargin(new Insets(2, 2, 2, 2));
    jButton34.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton34_ActionPerformed(evt);
      }
    });
    cp.add(jButton34);
    jButton35.setBounds(72, 304, 51, 25);
    jButton35.setText("8");
    jButton35.setMargin(new Insets(2, 2, 2, 2));
    jButton35.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton35_ActionPerformed(evt);
      }
    });
    cp.add(jButton35);
    jButton36.setBounds(72, 336, 51, 25);
    jButton36.setText("5");
    jButton36.setMargin(new Insets(2, 2, 2, 2));
    jButton36.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton36_ActionPerformed(evt);
      }
    });
    cp.add(jButton36);
    jButton37.setBounds(72, 368, 51, 25);
    jButton37.setText("2");
    jButton37.setMargin(new Insets(2, 2, 2, 2));
    jButton37.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton37_ActionPerformed(evt);
      }
    });
    cp.add(jButton37);
    jButton38.setBounds(72, 400, 51, 25);
    jButton38.setText(".");
    jButton38.setMargin(new Insets(2, 2, 2, 2));
    jButton38.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton38_ActionPerformed(evt);
      }
    });
    cp.add(jButton38);
    jButton39.setBounds(128, 304, 51, 25);
    jButton39.setText("9");
    jButton39.setMargin(new Insets(2, 2, 2, 2));
    jButton39.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton39_ActionPerformed(evt);
      }
    });
    cp.add(jButton39);
    jButton40.setBounds(128, 336, 51, 25);
    jButton40.setText("6");
    jButton40.setMargin(new Insets(2, 2, 2, 2));
    jButton40.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton40_ActionPerformed(evt);
      }
    });
    cp.add(jButton40);
    jButton41.setBounds(128, 368, 51, 25);
    jButton41.setText("3");
    jButton41.setMargin(new Insets(2, 2, 2, 2));
    jButton41.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton41_ActionPerformed(evt);
      }
    });
    cp.add(jButton41);
    jButton42.setBounds(128, 400, 51, 25);
    jButton42.setText("mal10^x");
    jButton42.setMargin(new Insets(2, 2, 2, 2));
    jButton42.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton42_ActionPerformed(evt);
      }
    });
    cp.add(jButton42);
    jButton43.setBounds(208, 304, 35, 25);
    jButton43.setText("DEL");
    jButton43.setMargin(new Insets(2, 2, 2, 2));
    jButton43.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton43_ActionPerformed(evt);
      }
    });
    cp.add(jButton43);
    jButton44.setBounds(248, 304, 35, 25);
    jButton44.setText("OFF");
    jButton44.setMargin(new Insets(2, 2, 2, 2));
    jButton44.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton44_ActionPerformed(evt);
      }
    });
    cp.add(jButton44);
    jButton45.setBounds(208, 336, 35, 25);
    jButton45.setText("x");
    jButton45.setMargin(new Insets(2, 2, 2, 2));
    jButton45.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton45_ActionPerformed(evt);
      }
    });
    cp.add(jButton45);
    jButton46.setBounds(248, 336, 35, 25);
    jButton46.setText("/");
    jButton46.setMargin(new Insets(2, 2, 2, 2));
    jButton46.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton46_ActionPerformed(evt);
      }
    });
    cp.add(jButton46);
    jButton47.setBounds(208, 368, 35, 25);
    jButton47.setText("+");
    jButton47.setMargin(new Insets(2, 2, 2, 2));
    jButton47.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton47_ActionPerformed(evt);
      }
    });
    cp.add(jButton47);
    jButton48.setBounds(248, 368, 35, 25);
    jButton48.setText("-");
    jButton48.setMargin(new Insets(2, 2, 2, 2));
    jButton48.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton48_ActionPerformed(evt);
      }
    });
    cp.add(jButton48);
    jButton49.setBounds(208, 400, 35, 25);
    jButton49.setText("Ans");
    jButton49.setMargin(new Insets(2, 2, 2, 2));
    jButton49.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton49_ActionPerformed(evt);
      }
    });
    cp.add(jButton49);
    jButton50.setBounds(248, 400, 43, 25);
    jButton50.setText("=");
    jButton50.setMargin(new Insets(2, 2, 2, 2));
    jButton50.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton50_ActionPerformed(evt);
      }
    });
    cp.add(jButton50);
    jTextField1.setBounds(16, 16, 273, 49);
    cp.add(jTextField1);
    // Ende Komponenten
    
    setVisible(true);
}
    // Ende
    
   // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("ggT") ;
  } // end of jButton1_ActionPerformed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("!") ;
  } // end of jButton2_ActionPerformed
  
  public void jButton3_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("E") ;
  } // end of jButton3_ActionPerformed
  
  public void jButton4_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("ON") ;
  } // end of jButton4_ActionPerformed
  
  public void jButton5_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("<") ;
  } // end of jButton5_ActionPerformed
  
  public void jButton6_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden (">") ;
  } // end of jButton6_ActionPerformed
  
  public void jButton7_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("^") ; 
  } // end of jButton7_ActionPerformed
  
  public void jButton8_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("v") ;
  } // end of jButton8_ActionPerformed
  
  public void jButton9_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("AC") ;
  } // end of jButton9_ActionPerformed
  
  public void jButton10_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("x^-1") ;
  } // end of jButton10_ActionPerformed
  
  public void jButton11_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("exp") ;
  } // end of jButton11_ActionPerformed
  
  public void jButton12_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("x^3") ;
  } // end of jButton12_ActionPerformed
  
  public void jButton13_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("root") ;
  } // end of jButton13_ActionPerformed
  
  public void jButton14_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("10^x") ;
  } // end of jButton14_ActionPerformed
  
  public void jButton15_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("prim?") ;
  } // end of jButton15_ActionPerformed
  
  public void jButton16_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("x^2") ;
  } // end of jButton16_ActionPerformed
  
  public void jButton17_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("x/y") ;
  } // end of jButton17_ActionPerformed
  
  public void jButton18_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("%") ;
  } // end of jButton18_ActionPerformed
  
  public void jButton19_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen   #
    senden ("(-)") ;
  } // end of jButton19_ActionPerformed
  
  public void jButton20_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("even?") ;
  } // end of jButton20_ActionPerformed
  
  public void jButton21_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("kgV") ;
  } // end of jButton21_ActionPerformed
  
  public void jButton22_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("sin") ;
  } // end of jButton22_ActionPerformed
  
  public void jButton23_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("cos") ;
  } // end of jButton23_ActionPerformed
  
  public void jButton24_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("tan") ;
  } // end of jButton24_ActionPerformed
  
  public void jButton25_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("mod") ;
  } // end of jButton25_ActionPerformed
  
  public void jButton26_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("(") ;
  } // end of jButton26_ActionPerformed
  
  public void jButton27_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("collatz") ;
  } // end of jButton27_ActionPerformed
  
  public void jButton28_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("M+") ;
  } // end of jButton28_ActionPerformed
  
  public void jButton29_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("fibonacci") ;
  } // end of jButton29_ActionPerformed
  
  public void jButton30_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden (")") ;
  } // end of jButton30_ActionPerformed
  
  public void jButton31_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("7") ;
  } // end of jButton31_ActionPerformed
  
  public void jButton32_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("4") ;
  } // end of jButton32_ActionPerformed
  
  public void jButton33_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("1") ;
  } // end of jButton33_ActionPerformed
  
  public void jButton34_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("0") ;
  } // end of jButton34_ActionPerformed
  
  public void jButton35_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("8") ;
  } // end of jButton35_ActionPerformed
  
  public void jButton36_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("5") ;
  } // end of jButton36_ActionPerformed
  
  public void jButton37_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("2") ;
  } // end of jButton37_ActionPerformed
  
  public void jButton38_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden (".") ;
  } // end of jButton38_ActionPerformed
  
  public void jButton39_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("9") ;
  } // end of jButton39_ActionPerformed
  
  public void jButton40_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("6") ;
  } // end of jButton40_ActionPerformed
  
  public void jButton41_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("3") ;
  } // end of jButton41_ActionPerformed
  
  public void jButton42_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("mal10^x") ;
  } // end of jButton42_ActionPerformed
  
  public void jButton43_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("DEL") ;
  } // end of jButton43_ActionPerformed
  
  public void jButton44_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("OFF") ;
  } // end of jButton44_ActionPerformed
  
  public void jButton45_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("x") ;
  } // end of jButton45_ActionPerformed
  
  public void jButton46_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("/") ;
  } // end of jButton46_ActionPerformed
  
  public void jButton47_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("+") ;
  } // end of jButton47_ActionPerformed
  
  public void jButton48_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("-") ;
  } // end of jButton48_ActionPerformed
  
  public void jButton49_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden ("Ans") ;
  } // end of jButton49_ActionPerformed
  
  public void jButton50_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    senden("=");
  } // end of jButton50_ActionPerformed
  
  void senden (String s) {
   if (steuerung != null) { 
       steuerung.empfangen(s);
    }
   //System.out.println("GUI sendet: "+s);
  }
  
  public void ausgeben (String s) {
      jTextField1.setText(s) ;
   
    }  

  public void steuerungSetzen(Steuerung s) {
      steuerung = s;
  }
    // Ende Methoden

}
