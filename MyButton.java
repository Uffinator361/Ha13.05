import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  * Buttons mit 2 Konstruktoren
  *
  * @version 1.1 vom 22.02.2017
  * @author Olaf Brink
  */

@SuppressWarnings("serial")
public class MyButton extends JButton {
  public MyButton(final String text, int xpos, int row, int width, final JFrame frameToAdd) { 
    this(text,xpos,8+32*row,width,20,frameToAdd);
  }
    
  public MyButton(final String text, int xpos, int ypos, int width, int height, final JFrame frameToAdd) { 
    setBounds(xpos, ypos, width, height);
    setText(text);
    setFocusPainted(false);
    setMargin(new Insets(2, 2, 2, 2));
    
    addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        ((MainProg)frameToAdd).doButtonAction(text);                            // hier ist der Name des Hauptprogramms einzutragen
      }
    });
    
    frameToAdd.getContentPane().add(this);
  }
}