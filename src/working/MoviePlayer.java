package working;

public class MoviePlayer extends Product implements MultimediaControl {
  Screen screen;
  ItemType monitorType;

  /**
   * @param name
   * @param manufacturer
   * @param type
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, ItemType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  public String toString(){
    return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
  }

  public static void testMultimedia(){
    //AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A","Onkyo","DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC")
  }
}
