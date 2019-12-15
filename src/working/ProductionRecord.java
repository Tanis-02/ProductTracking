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

  /**
   * accessors and mutators
   *
   * @return
   */
  public int getProductionNumber() {
    return productionNumber;
  }

  /** @param productionNumber */
  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /** @return */
  public int getProductID() {
    return productID;
  }

  /** @param productID */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /** @return */
  public String getSerialNumber() {
    return serialNumber;
  }

  /** @param serialNumber */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /** @return */
  public Date getDateProduced() {
    return dateProduced;
  }

  /** @param dateProduced */
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

  /**
   * @param product
   * @param counter
   */
  ProductionRecord(Product product, int counter) {
    String idNumber = String.format("%05d", counter);
    this.serialNumber =
        product.getManufacturer().substring(0, 3) + product.getType().getItemType() + idNumber;

    this.dateProduced = new Date();
  }

  /** @return */
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
