package working;

public interface Item {
  /** @return */
  int getId();

  /** @param name */
  void setName(String name);

  /** @return */
  String getName();

  /** @param manufacturer */
  void setManufacturer(String manufacturer);

  /** @return */
  String getManufacturer();
}