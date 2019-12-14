package working;

/**
 * Abstract class named Products that implements Item
 * @author Elizabeth Gonzalez
 **/
public abstract class Product implements Item {
  int id;
  ItemType type;
  String manufacturer;
  String name;
  /** @return */
  public int getId() {
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  /** @param name */
  public void setName(String name) {
    this.name = name;
  }

  /** @return */
  public String getName() {
    return name;
  }

  /** @param manufacturer */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /** @return */
  public String getManufacturer() {
    return manufacturer;
  }

  /** @param type */
  public void setType(ItemType type){
    this.type = type;
  }

  public ItemType getType(){
    return type;
  }

  /**
   * @param name
   * @param manufacturer
   * @param type
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * @param id
   * @param name
   * @param manufacturer
   * @param type
   */
  public Product(int id, String name, String manufacturer, ItemType type) {
    this.id = id;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /** @return */
  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }
}
