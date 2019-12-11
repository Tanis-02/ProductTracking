package working;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class Controller {

  @FXML
  private ChoiceBox<ItemType> itemTypeChB;

  @FXML
  private TextField productionTf;

  @FXML
  private TextField manufactureTf;

  @FXML
  private Button addProductBtn;

  @FXML
  private TableView<?> existingTV;

  @FXML
  private ListView<?> chooseTxtA;

  @FXML
  private ComboBox<String> quanitityCb;

  @FXML
  private Button recordProductionBtn;

  @FXML
  void addProduct(MouseEvent event) {
    String addProductsField = productionTf.getText();
    String addManufactureField = manufactureTf.getText();
    ItemType itemTypeChoice = itemTypeChB.getValue();

    
  }

  @FXML
  void recordProduction(MouseEvent event) {

  }
  public void initialize(){
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/WorkingProduct";

    //  Database credentials
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);
      System.out.println("connected");
      // STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql =
          "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod')";
      PreparedStatement preparedStatement =
          conn.prepareStatement(sql);
      preparedStatement.execute();


      // STEP 4: Clean-up environment
      conn.close();
      stmt.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();

    }

    //populates numbers 1-10 to the combo box in Product Tab
    quanitityCb.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    quanitityCb.setEditable(true);

    //fills the choiceBox in the product line with the types defined in ItemType Enum in Produce
    // Line Tab
    for (ItemType type : ItemType.values()) {
      itemTypeChB.getItems().add(type);
    }
}
}

