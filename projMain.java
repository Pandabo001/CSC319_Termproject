import java.io.*;
import java.util.Scanner;

public class projMain{
  
  
  public static void main(String[] args) throws FileNotFoundException{
    
    //new Search();
    
    Scanner sc = new Scanner(System.in);
    //System.out.print("Please enter file name: ");
    String file = "data.txt";
    
    
    System.out.print("Please enter word to find: ");
    String word = sc.nextLine();
    
    
    
    Search fileSearch = new Search();
    fileSearch.searchFile(file, word);
    
    Search cntWord = new Search();
    System.out.println("People tweet about " + word + " : " + cntWord.countWord(file, word));
    
    
  }
}

