package application;

/**
 * A driver class that sets up the MVC framework and begins the application.
 */
public class Driver {

  /**
   * The entry point for the calculator.
   * 
   * @param args ignored - could be used to choose which view to load in future?
   */
  public static void main(String[] args) {
    ViewInterface view = new AsciiView();

    CalcModel model = new CalcModel();
    System.out.println("hello");

    // Decide which view to build.
    if (System.console() == null) {
      System.out.println("hello");
      view = CalcView.getInstance();
    }
    new CalcController(model, view);
    // All ready so begin the interface.
    view.startView();
  }
}
