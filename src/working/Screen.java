package working;

/**
 * This class implements the methods from the screenSpecs interface
 *
 * @author Elizabeth Gonzalez
 */
public class Screen implements ScreenSpec {

  String resolution;
  int refreshrate;
  int responsetime;

  /**
   * @param resolution
   * @param refreshrate
   * @param responsetime
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshrate = refreshrate;
    this.responsetime = responsetime;
  }

  /** @return */
  @Override
  public String getResolution() {
    return resolution;
  }

  /** @return */
  @Override
  public int getRefreshRate() {
    return refreshrate;
  }

  /** @return */
  @Override
  public int getResponseTime() {
    return responsetime;
  }

  /** @return */
  public String toString() {
    return "\nResolution: "
        + resolution
        + "\nRefresh rate: "
        + refreshrate
        + "\nResponse time: "
        + responsetime;
  }
}
