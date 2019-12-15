package working;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;

/**
 * This is the controller class that executes most of the functions in this project
 *
 * @author Elizabeth Gonzalez
 */
public class Controller {

  @FXML private ChoiceBox<ItemType> itemTypeChB;

  @FXML private TextField productionTf;

  @FXML private TextField manufactureTf;

  @FXML private Button addProductBtn;

  @FXML private TableView<Product> existingTV;

  @FXML private TableColumn<?, ?> tvNameCol;

  @FXML private TableColumn<?, ?> tvManuCol;

  @FXML private TableColumn<?, ?> tvTypeCol;

  @FXML private ObservableList<Product> productionLine = FXCollections.observableArrayList();

  @FXML private ListView<Product> chooseTxtA;

  @FXML private ComboBox<String> quanitityCb;

  @FXML private Button recordProductionBtn;

  @FXML private TextArea productionLogTxA;

  @FXML private TextField firstNameTx;

  @FXML private TextField lastNameTx;

  @FXML private Button createEmployeeBtn;

  @FXML private TextArea instructions;

  /**
   * This is my product button that takes the user input in the product tab and inserts it into the
   * database
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void addProduct(MouseEvent event) throws SQLException {
    String addProductsField = productionTf.getText();
    String manufactureField = manufactureTf.getText();
    ItemType itemTypeChoice = itemTypeChB.getValue();

    Connection con = DriverManager.getConnection("jdbc:h2:./res/WorkingProduct");
    Statement state = con.createStatement();

    String productTable =
        "INSERT INTO PRODUCT(NAME, MANUFACTURER, TYPE) VALUES ('"
            + addProductsField
            + "', '"
            + manufactureField
            + "', '"
            + itemTypeChoice
            + "')";

    PreparedStatement prep = con.prepareStatement(productTable);
    prep.executeUpdate();

    productionLine.add(new Widget(addProductsField, manufactureField, itemTypeChoice));
    System.out.println("Product has been added");
    System.out.println(productionLine);
  }

  /**
   * @param event
   * @throws SQLException
   */
  @FXML
  void recordProduction(MouseEvent event) throws SQLException {}

  @FXML
  void createEmployee(MouseEvent event) throws SQLException {
    String firstName = firstNameTx.getText();
    String lastName = lastNameTx.getText();

    Connection con = DriverManager.getConnection("jdbc:h2:./res/WorkingProduct");
    Statement state = con.createStatement();

    String employee =
        "INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME) VALUES ('"
            + firstName
            + "', '"
            + lastName
            + "')";

    PreparedStatement prep = con.prepareStatement(employee);
    prep.executeUpdate();

    instructions.appendText("You're response has been submitted" + "\n" + "Your username, password and email will be created shortly.");

  }

  Connection conn = null;
  Statement stmt = null;

  /**
   * this method connects my database and executes other methods that use this connection as well
   *
   * @throws SQLException
   */
  public void initialize() throws SQLException {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/WorkingProduct";

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);
      System.out.println("connected");
      // STEP 3: Execute a query

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // populates numbers 1-10 to the combo box in Product Tab
    quanitityCb.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    quanitityCb.setEditable(true);

    // fills the choiceBox in the product line with the types defined in ItemType Enum in Produce
    // Line Tab
    for (ItemType type : ItemType.values()) {
      itemTypeChB.getItems().add(type);
    }

    // populating Production Record to the Production Log text area
    productionLogTxA.setEditable(false);

    // populating product tableview
    loadProduct();
    loadProductLog();
    loadProductList();
  }

  /**
   * this method loads my product tableview with the data from the database
   *
   * @throws SQLException
   */
  private void loadProduct() throws SQLException {
    tvNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    tvManuCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    tvTypeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
    existingTV.setItems(productionLine);

    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM PRODUCT");
    while (rs.next()) {
      productionLine.add(
          new Widget(rs.getString(2), rs.getString(4), ItemType.valueOf(rs.getString(3))));
    }
  }

  /**
   * this method loads the data from the product table into the production log from the production
   * list
   *
   * @throws SQLException
   */
  private void loadProductLog() throws SQLException {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTIONRECORD");
    while (rs.next()) {
      ProductionRecord productLog =
          new ProductionRecord(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getTimestamp(4));
      productionLogTxA.appendText(productLog.toString());
      productionLogTxA.setEditable(false);
    }
  }

  /**
   * this method sets the items from the product table in the database intot the production line
   * list
   */
  private void loadProductList() {
    chooseTxtA.setItems(productionLine);
  }
}
