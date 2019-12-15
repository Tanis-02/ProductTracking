package working;

/**
 * this is the interface that has the specifics for the monitors
 *
 * @author Elizabeth Gonzalez
 */
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
