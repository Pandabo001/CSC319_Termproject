public class TweetObject {
  
  private int id;
  private String name;
  private String tweet;
  private String location;
  private String device;
  private String timeTweet;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getTweet() {
    return tweet;
  }
  
  public void setTweet(String tweet) {
    this.tweet = tweet;
  }
  
  public String getLocation() {
    return location;
  }
  
  public void setLocation(String location) {
    this.location = location;
  }
  
  public String getDevice() {
    return device;
  }
  
  public void setDevice(String device) {
    this.device = device;
  }
  
   public String getTime() {
    return timeTweet;
  }
  
  public void setTime(String timeTweet) {
    this.timeTweet = timeTweet;
  }
  
  @Override
  public String toString(){
    return "\nName " + getName() + " Tweet : "+getTweet();
  }
}