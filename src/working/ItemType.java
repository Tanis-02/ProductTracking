package working;

/**@author Elizabeth Gonzalez
 *
 * Enum with the item types
 *
 * */

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

 String type;

  /** @param value */
  ItemType(String value) {
    type = value;
  }

  /** @return */
  public String getItemType() {
    return type;
  }
}
