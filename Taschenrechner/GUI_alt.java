import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 30.10.2012
  * @author
  */

public class GUI_alt extends JFrame implements GUI   {
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
  private JLabel jLabel1 = new JLabel();
  
  Steuerung steuerung; 
  Container cp;

  // Ende Attribute

  public GUI_alt(String s) {
    // Frame-Initialisierung
    super(s);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    cp = getContentPane();
    cp.setLayout(null);     
        
        
   // Anfang Komponenten

    jButton1.setBounds(16, 72, 51, 25);
    jButton1.setText("1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(72, 72, 51, 25);
    jButton2.setText("2");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(128, 72, 51, 25);
    jButton3.setText("3");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jButton4.setBounds(16, 104, 51, 25);
    jButton4.setText("4");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(jButton4);
    jButton5.setBounds(72, 104, 51, 25);
    jButton5.setText("5");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton5_ActionPerformed(evt);
      }
    });
    cp.add(jButton5);
    jButton6.setBounds(128, 104, 51, 25);
    jButton6.setText("6");
    jButton6.setMargin(new Insets(2, 2, 2, 2));
    jButton6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton6_ActionPerformed(evt);
      }
    });
    cp.add(jButton6);
    jButton7.setBounds(16, 136, 51, 25);
    jButton7.setText("7");
    jButton7.setMargin(new Insets(2, 2, 2, 2));
    jButton7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton7_ActionPerformed(evt);
      }
    });
    cp.add(jButton7);
    jButton8.setBounds(72, 136, 51, 25);
    jButton8.setText("8");
    jButton8.setMargin(new Insets(2, 2, 2, 2));
    jButton8.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton8_ActionPerformed(evt);
      }
    });
    cp.add(jButton8);
    jButton9.setBounds(128, 136, 51, 25);
    jButton9.setText("9");
    jButton9.setMargin(new Insets(2, 2, 2, 2));
    jButton9.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton9_ActionPerformed(evt);
      }
    });
    cp.add(jButton9);
    jButton10.setBounds(72, 168, 51, 25);
    jButton10.setText("0");
    jButton10.setMargin(new Insets(2, 2, 2, 2));
    jButton10.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton10_ActionPerformed(evt);
      }
    });
    cp.add(jButton10);
    jButton11.setBounds(16, 168, 51, 25);
    jButton11.setText("C");
    jButton11.setMargin(new Insets(2, 2, 2, 2));
    jButton11.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton11_ActionPerformed(evt);
      }
    });
    cp.add(jButton11);
    jButton12.setBounds(128, 168, 51, 25);
    jButton12.setText("=");
    jButton12.setMargin(new Insets(2, 2, 2, 2));
    jButton12.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton12_ActionPerformed(evt);
      }
    });
    cp.add(jButton12);
    jButton13.setBounds(192, 8, 75, 25);
    jButton13.setText("+");
    jButton13.setMargin(new Insets(2, 2, 2, 2));
    jButton13.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton13_ActionPerformed(evt);
      }
    });
    cp.add(jButton13);
    jButton14.setBounds(192, 40, 75, 25);
    jButton14.setText("sqrt");
    jButton14.setMargin(new Insets(2, 2, 2, 2));
    jButton14.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton14_ActionPerformed(evt);
      }
    });
    cp.add(jButton14);
    jButton15.setBounds(192, 72, 75, 25);
    jButton15.setText("jButton15");
    jButton15.setMargin(new Insets(2, 2, 2, 2));
    jButton15.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton15_ActionPerformed(evt);
      }
    });
    cp.add(jButton15);
    jButton16.setBounds(192, 104, 75, 25);
    jButton16.setText("jButton16");
    jButton16.setMargin(new Insets(2, 2, 2, 2));
    jButton16.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton16_ActionPerformed(evt);
      }
    });
    cp.add(jButton16);
    jButton17.setBounds(192, 136, 75, 25);
    jButton17.setText("jButton17");
    jButton17.setMargin(new Insets(2, 2, 2, 2));
    jButton17.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton17_ActionPerformed(evt);
      }
    });
    cp.add(jButton17);
    jButton18.setBounds(192, 168, 75, 25);
    jButton18.setText("jButton18");
    jButton18.setMargin(new Insets(2, 2, 2, 2));
    jButton18.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton18_ActionPerformed(evt);
      }
    });
    cp.add(jButton18);
    jButton19.setBounds(192, 200, 75, 25);
    jButton19.setText("jButton19");
    jButton19.setMargin(new Insets(2, 2, 2, 2));
    jButton19.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton19_ActionPerformed(evt);
      }
    });
    cp.add(jButton19);
    jButton20.setBounds(192, 232, 75, 25);
    jButton20.setText("jButton20");
    jButton20.setMargin(new Insets(2, 2, 2, 2));
    jButton20.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton20_ActionPerformed(evt);
      }
    });
    cp.add(jButton20);
    jLabel1.setBounds(16, 8, 171, 57);
    jLabel1.setText("0");
    cp.add(jLabel1);
    // Ende Komponenten


    setVisible(true);
  }

  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    senden("1");
  }

  public void jButton2_ActionPerformed(ActionEvent evt) {
    senden("2");
  }

  public void jButton3_ActionPerformed(ActionEvent evt) {
    senden("3");
  }

  public void jButton4_ActionPerformed(ActionEvent evt) {
    senden("4");
  }

  public void jButton5_ActionPerformed(ActionEvent evt) {
    senden("5");
  }

  public void jButton6_ActionPerformed(ActionEvent evt) {
    senden("6");
  }

  public void jButton7_ActionPerformed(ActionEvent evt) {
    senden("7");
  }

  public void jButton8_ActionPerformed(ActionEvent evt) {
    senden("8");
  }

  public void jButton9_ActionPerformed(ActionEvent evt) {
    senden("9");
  }

  public void jButton10_ActionPerformed(ActionEvent evt) {
    senden("0");
  }

  public void jButton11_ActionPerformed(ActionEvent evt) {
    senden("AC");
  }

  public void jButton12_ActionPerformed(ActionEvent evt) {
    senden("=");
  }

  public void jButton13_ActionPerformed(ActionEvent evt) {
    senden("+");
  }

  public void jButton14_ActionPerformed(ActionEvent evt) {
    senden("sqrt");
  }

  public void jButton15_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void jButton16_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void jButton17_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void jButton18_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void jButton19_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void jButton20_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  }

  public void ausgeben(String s) {
          jLabel1.setText(s);
  }
  
  public void senden(String s) {
        steuerung.empfangen(s);
    }

  public void steuerungSetzen(Steuerung s) {
      steuerung = s;
  }
  // Ende Methoden

}
