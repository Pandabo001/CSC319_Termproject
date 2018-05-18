import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search{
  
  
  public static boolean search(String sentence, String pattern){
    
    Pattern regex = Pattern.compile(pattern);
    
    Matcher m = regex.matcher(sentence);
    //System.out.println(m.group(0));
    int count = 0;
    while(m.find()) {
      count++;
    }
    if(count != 0) return true;
    return false;
  }
  
  
  
}