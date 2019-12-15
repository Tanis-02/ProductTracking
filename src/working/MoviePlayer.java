package working;

/**
 * This class extends the product class which implements the controls from multimediaControl
 *
 * @author ELizabeth Gonzalez
 */
public class MoviePlayer extends Product implements MultimediaControl {
  Screen screen;
  MonitorType monitorType;

  /**
   * @param name
   * @param manufacturer
   * @param screen
   * @param monitorType
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
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

  /** @return */
  public String toString() {
    return "Name: "
        + name
        + "\n"
        + "Manufacturer: "
        + manufacturer
        + "\n"
        + "Type: "
        + type
        + "\n"
        + "Screen:"
        + screen
        + "\n"
        + "Monitor Type: "
        + monitorType;
  }

  public static void testMultimedia() {
    // AudioPlayer newAudioProduct = new
    // AudioPlayer("DP-X1A","Onkyo","DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC")
  }
}
