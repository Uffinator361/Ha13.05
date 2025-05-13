import javax.swing.*;

/**
  * Label mit 2 Konstruktoren
  *
  * @version 1.1 vom 22.02.2017
  * @author Olaf Brink
  */

@SuppressWarnings("serial")
public class MyLabel extends JLabel {
  public MyLabel(final String text, int xpos, int row, int width, final JFrame frameToAdd) { 
    this(text,xpos,8+32*row,width,20,frameToAdd);
  }
  
  public MyLabel(final String text, int xpos, int ypos, int width, int height, final JFrame frameToAdd) { 
    super();
    setBounds(xpos,ypos,width,height);
    setText(text);  
    frameToAdd.getContentPane().add(this);
  }
  
  public void meineMethode() {
    System.out.println("Meine Methode tut was!");
  }
}