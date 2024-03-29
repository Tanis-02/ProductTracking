package working;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the driver class for the project and sets the scene for the GUI
 *
 * @author Elizabeth Gonzalez
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("gui_code.fxml"));
    primaryStage.setTitle("Product Tracking");
    primaryStage.setScene(new Scene(root, 750, 550));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
