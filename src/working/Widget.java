package working;

/**
 * this is a widget class that extends the abstract class product to test the class
 * @author Elizabeth Gonzalez
 **/
public class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  public Widget(int Id, String name, String manufacturer, ItemType type) {
    super(Id, name, manufacturer, type);
  }

  public int getId(){
    return 0;
  }
}
