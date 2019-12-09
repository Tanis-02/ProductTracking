package working;

/**@author Elizabeth Gonzalez
 *
 * Fills the choice box with the types of products we have for our program
 *
 * */

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public final String code;

  /** @param code */
  ItemType(String code) {
    this.code = code;
  }

  /** @return */
  public String code() {
    return code;
  }
}
