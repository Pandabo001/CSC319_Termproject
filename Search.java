import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class Search {

  JFrame frame;
  JTextField searchText, showText;
  JButton searchWord, countWord;
  private static int operator = 0;
  int count;
  
  
  public void searchFile(String fileName, String searchStr) throws FileNotFoundException{
    Scanner scan = new Scanner(new File(fileName));
    while(scan.hasNext()){
      String line = scan.nextLine().toLowerCase().toString();
      if(line.contains(searchStr)){
        System.out.println(line);
        
      }
    }
  }
  
  public int countWord(String fileName, String word) throws FileNotFoundException{
    count = 0;
    Scanner scan = new Scanner(new File(fileName));
    while (scan.hasNext()) {
      String nextToken = scan.next().toLowerCase().toString();;
      if (nextToken.contains(word))
        count++;
    }
    return count;
  }

}