package working;

import java.util.Date;

/**
 * Class that contains constructors,accessors, and mutators for the production record
 *
 * @author Elizabeth Gonzalez
 */
public class ProductionRecord {
  int productionNumber;
  int productID;
  String serialNumber;
  Date dateProduced;

  // accessors and mutators
  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getDateProduced() {
    return dateProduced;
  }

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * constructor
   *
   * @param productID
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * overloaded constructor to use when creating ProductionRecord objects from the database
   *
   * @param productionNumber
   * @param productID
   * @param serialNumber
   * @param dateProduced
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public String toString() {
    return ("Prod. Num: "
        + productionNumber
        + "\n"
        + "Product ID: "
        + productID
        + "\n"
        + "Serial Num: "
        + serialNumber
        + "\n"
        + "Date: "
        + dateProduced);
  }
}
