package working;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this is the employee tab which will set a username, email and password from the employee tab and
 * check the input against a matching one in the database
 *
 * @author Elizabeth Gonzalez
 */
public class Employee {

  private StringBuilder name;
  private String username;
  private String password;
  private String email;

  /** @param name */
  private void setUsername(String name) {
    Pattern username = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher matchingUser = username.matcher(name);
    matchingUser.find();
    String lastName = matchingUser.group(1);
    String initials = name.substring(0, 1) + lastName;
    this.username = initials.toLowerCase();
  }

  /**
   * @param name
   * @return
   */
  private boolean checkName(String name) {
    Pattern checking = Pattern.compile("\\s");
    Matcher matchingCheck = checking.matcher(name);
    boolean check = matchingCheck.find();
    return check;
  }

  /** @param name */
  private void setEmail(String name) {
    Pattern checkingFirst = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher firstNameMatched = checkingFirst.matcher(name);
    firstNameMatched.find();
    String firstName = firstNameMatched.group(1);

    Pattern checkingLast = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher lastNameMatched = checkingLast.matcher(name);
    lastNameMatched.find();
    String lastName = lastNameMatched.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  /**
   * @param password
   * @return
   */
  private boolean isValidPassword(String password) {
    final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\W).*$";
    final Pattern regexCD = Pattern.compile(regex);
    final Matcher matched = regexCD.matcher(password);
    return matched.matches();
  }

  /**
   * @param name
   * @param password
   */
  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
    }

    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /** @return */
  public String toString() {
    return "Employee Details"
        + "\n"
        + "Name: "
        + name
        + "\n"
        + "Username: "
        + username
        + "\n"
        + "Email: "
        + email
        + "\n"
        + "Initial Password: "
        + password;
  }
}
