import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
//import java.text.DateFormat;                                                    
//import java.text.SimpleDateFormat;

/**
  * Laden einer Datei, nun auch mit FileChooser
  *
  * @version 1.2 vom 27.02.2017
  * @author Olaf Brink
  */

public class MyFileIO {
  private String newline = System.getProperty("line.separator");        // bei Windows /n/r, bei Linux nur /n, bei Mac nur /r
  private FileWriter fw;
  private FileReader fr;
  private String lastLoadedFile;
  
  public boolean saveRecords(String stringToSave, String fileName) {
    try {
      fw = new FileWriter(fileName);
      fw.write(stringToSave);
      fw.close();
      return true;
    } catch(Exception e) {
      System.out.println("Fehler beim Erstellen der Datei " + fileName);
      return false;
    }
  }
  
  public String loadString(String fileName) {
    int c;
    String loadedString = "";
    try {
      fr = new FileReader(fileName);
      while ((c = fr.read()) != -1) { 
        loadedString = loadedString + (char)c;
      } 
      fr.close();
    } catch(Exception e) {
      System.out.println("Fehler beim Lesen der Datei " + fileName);
    }
    return loadedString;
  }
  
  public String loadFile(JFrame frameToAdd) {                                   // frameToAdd benötigt, um zu wissen, worüber der Dialog gelegt werden soll
    JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("txt-Files", "txt");
      chooser.setCurrentDirectory(new File("."));
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(frameToAdd);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
        lastLoadedFile = chooser.getSelectedFile().getPath();
        return loadString(lastLoadedFile);
      }
    return "";                                                                  // wenn Abbruch gib leeren String zurück
  }
  
  
  /**
  *
  * Die folgende main-Methode dient nur zum eigenständigen Testen von FileWriter und FileReader
  *
  */
  public static void main(String[] args) {                        // zum ersten Testen
    String newline = System.getProperty("line.separator");        // bei Windows /n/r, bei Linux nur /n, bei Mac nur /r
    String fileName = "hello.txt";
    //System.out.println(newline.length());                      // bei Windows also 2 Zeichen lang
    
    String hello = "Erste Zeile" + newline + "Zweite Zeile" + newline + "Dritte Zeile" + newline;
    FileWriter fw;
    FileReader fr;
    
    try {
      fw = new FileWriter(fileName);
      fw.write(hello);
      fw.close();
    } catch(Exception e) {
      System.out.println("Fehler beim Erstellen der Datei " + fileName);
    }
    
    int c;
    String s = "";
    try {
      fr = new FileReader(fileName);
      while ((c = fr.read()) != -1) { 
        s = s + (char)c;
      } 
      fr.close();
    } catch(Exception e) {
      System.out.println("Fehler beim Lesen der Datei " + fileName);
    }
    
    String sub;
    while (!s.isEmpty()) { 
      sub = s.substring(0,s.indexOf(newline));
      System.out.println(sub);
      s = s.substring(s.indexOf(newline)+newline.length());
    } 
  }
  
}