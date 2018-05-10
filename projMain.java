import java.io.*;
import java.util.Scanner;

public class projMain{
  
  
  public static void main(String[] args) throws FileNotFoundException{
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter file name: ");
    String file = sc.nextLine();
    
    System.out.print("Please enter word to find: ");
    String word = sc.nextLine();
    
    
    Search fileSearch = new Search();
    fileSearch.parseFile(file, word);
    
    Search cntWord = new Search();
    System.out.println("People tweet about " + word + " : " + cntWord.countWord(file, word));
    
    
  }
}

