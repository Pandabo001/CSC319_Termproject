import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class projMain {
  
  public static void main(String[] args) throws IOException {
    // open file input stream
    BufferedReader reader = new BufferedReader(new FileReader("sample.csv"));
    
    // read file line by line
    String line = null;
    Scanner scanner = null;
    int index = 0;
    List<TweetObject> tweetList = new ArrayList<>();
    
    while ((line = reader.readLine()) != null) {
      TweetObject tw = new TweetObject();
      scanner = new Scanner(line);
      scanner.useDelimiter(",");
      while (scanner.hasNext()) {
        String data = scanner.next();
        if (index == 0)
          tw.setId(Integer.parseInt(data));
        else if (index == 1)
          tw.setName(data);
        else if (index == 2)
          tw.setTweet(data);
        else if (index == 3)
          tw.setLocation(data);
        else if (index == 4)
          tw.setDevice(data);
        else if (index == 5)
          tw.setTime(data);
        else
          System.out.println("invalid data : " + data);
        index++;
      }
      index = 0;
      tweetList.add(tw);
    }
    
    //close reader
    reader.close();
    
    System.out.println(tweetList);
    
    
    List<TweetObject> result = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter word to find: ");
    String word = sc.nextLine().toLowerCase();
    for(TweetObject tweet : tweetList){
      
      String sentence = tweet.getTweet().toLowerCase();
      boolean foundWord = Search.search(sentence, word);
      
      if(foundWord){
      
        result.add(tweet);
      }
    }
    
    System.out.println("Tweet found : " + result.size());
    System.out.println(result);
    
    
    //System.out.println(searchTweet.search("Heloboy", "Hello"));
  }
  
}