package working;

/**
 * Item interface that has the getters and setters for id, name, and manufacturer
 * @author Elizabeth Gonzalez
 */
public interface Item {

  /** @param id */
  void setId(int id);

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