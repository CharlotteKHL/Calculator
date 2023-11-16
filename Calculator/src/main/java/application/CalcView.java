package application;

import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class provides a resizeable JavaFx GUI for the calculator MVC.
 */

public class CalcView extends Application implements ViewInterface {
  @FXML
  private Button calcButton;

  @FXML
  private ToggleButton infixCalculatorButton;

  @FXML
  private TextField inputField;

  @FXML
  private ToggleButton revPolishCalculatorButton;

  @FXML
  private TextField totalField;

  // Methods for registering an observer and for
  // accessing user data in the UI
  // These methods build the Observer/Observable pattern


  @Override
  public void addCalculateObserver(Runnable f) {
    calcButton.setOnAction(event -> f.run());
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    infixCalculatorButton.setOnAction(event -> c.accept(OpType.STANDARD));
    revPolishCalculatorButton.setOnAction(event -> c.accept(OpType.REV_POLISH));
  }

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    totalField.setText(answer);
  }

  @Override
  public void startView() {
    calcButton.setDisable(false);
    revPolishCalculatorButton.setDisable(false);
    infixCalculatorButton.setDisable(false);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(CalcView.class.getResource("View.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("MVC/Observer/fxml");
    primaryStage.show();
  }

  // DO NOT CHANGE ANYTHING BELOW THIS COMMENT
  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method
  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This is a Singleton View constructed by the JavaaFX Thread and made available through this
   * method.
   * 
   * @return the single object representing this view
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////

}
