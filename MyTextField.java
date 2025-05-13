import javax.swing.*;

/**
  * TextField mit 2 Konstruktoren
  *
  * @version 1.1 vom 22.02.2017
  * @author Olaf Brink
  */

@SuppressWarnings("serial")
public class MyTextField extends JTextField {
  public MyTextField(int xpos, int row, int width, final JFrame frameToAdd) { 
    this(xpos,8+32*row,width,20,frameToAdd);
  }
  public MyTextField(int xpos, int ypos, int width, int height, final JFrame frameToAdd) { 
    super();
    setBounds(xpos,ypos,width,height);
    frameToAdd.getContentPane().add(this);
  }
}