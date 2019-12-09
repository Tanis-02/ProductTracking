package working;

public abstract class Product implements Item {
  private int Id;
  private ItemType Type;
  private String Manufacturer;
  private String Name;
  /** @return */
  public int getId() {
    return Id;
  }

  /** @param name */
  public void setName(String name) {
    Name = name;
  }

  /** @return */
  public String getName() {
    return Name;
  }

  /** @param manufacturer */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /** @return */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * @param name
   * @param manufacturer
   * @param type
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /** @return */
  public String toString() {
    return "Name: " + Name + "\nManufacturer: " + Manufacturer + "\nType: " + Type;
  }
}
