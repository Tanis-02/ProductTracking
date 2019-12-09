package working;

public class AudioPlayer extends Product implements MultimediaControl {

  String supportedAudioFormats;
  String supportedPlaylistFormats;

  /**
   * @param name
   * @param manufacturer
   */

  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO); // switched data type of type in Product to ItemType, restricts what we can send in, only sends in ItemType not any random string

    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;

  }

  @Override // @Override tells us if the method exists in the implemented class before an error happens
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

  @Override
  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
  }
}
