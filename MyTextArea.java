import javax.swing.*;

/**
  * TextArea eingebettet in einer JScrollPane, damit Schieberegler bei Bedarf erscheinen
  *
  * @version 1.1 vom 22.02.2017
  * @author Olaf Brink
  */
  
@SuppressWarnings("serial")
public class MyTextArea extends JTextArea {
  JScrollPane pane;                                                             // um bei Bedarf das Scrolling zu ermöglichen                                                          // um bei Bedarf das Scrolling zu ermöglichen
  public MyTextArea(int xpos, int ypos, int width, int height, final JFrame frameToAdd) { 
    super();
    setLineWrap(true);                                                          // automatischer Zeilenumbruch
    pane = new JScrollPane(this);
    pane.setBounds(xpos,ypos,width,height);                                     // hier das "Geheimnis": setBounds nicht auf die TextArea ausführen, sondern auf die ScrollPane
    frameToAdd.getContentPane().add(pane);
  }
}