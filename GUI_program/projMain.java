import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class projMain {
  
  private static JFrame createFrame() {
    JFrame frame = new JFrame("Twitter tweet search");
    JLabel lblSearch = new JLabel("Search word");
    lblSearch.setBounds(80, 7, 84, 14);
    frame.add(lblSearch);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(600, 450));
    return frame;
  }
  
  public static void main(String[] args)  {
    
    /*
     * Create a JFrame and table
     */ 
    
    JFrame frame = createFrame();
    TableModel tableModel = createTableModel();
    JTable tweetData = new JTable(tableModel);
    
    JTextField filterTweet = TweetFilter.createRowFilter(tweetData);
    JPanel panel = new JPanel();
    panel.add(filterTweet);
    frame.add(panel, BorderLayout.NORTH);
    
    JScrollPane pane = new JScrollPane(tweetData);
    frame.add(pane, BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    
    
  }
  
  private static TableModel createTableModel(){
    
    /*
     * Store a dataset into arrayList
     */
    
    // read file line by line
    String line = null;
    Scanner scanner = null;
    int index = 0;
    List<TweetObject> tweetList = new ArrayList<>();
    try{
      
      // open file input stream
      BufferedReader reader = new BufferedReader(new FileReader("sample.csv"));
      
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
    }catch(IOException e){
      System.out.println("Error" + e);
    }
    
    /*
     * Store a Tweet object into 2D array using 2 Vector columns and rows and add it to table.
     * 
     */
    Vector<String> columns = new Vector<>(Arrays.asList("ID", "Name", "Tweet"));
    Vector<Vector<Object>> rows = new Vector<>();
    
    for(TweetObject tweet : tweetList){
      
      Vector<Object> v = new Vector<>();
      v.add(tweet.getId());
      v.add(tweet.getName());
      v.add(tweet.getTweet());
      rows.add(v);
      
    }
    
    
    DefaultTableModel tm = new DefaultTableModel(rows, columns) {
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 2 ? Integer.class : String.class;
      }
    };
    return tm;
  }
  
}