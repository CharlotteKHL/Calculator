package application;

// You can use this file in your second assignment as is - or modify it to suit your code - in which
// case add another @author tag below mine
// DO NOT remove my @author tag

import java.util.function.Consumer;

/**
 * Any calculator view must implement these methods to allow the controller and the view to properly
 * work together.
 * 
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 * 
 **/
public interface ViewInterface {

  /**
   * Add the method that should do the calculation.
   * 
   * @param f the runnable object to do the calculation (a method that takes no parameters and
   *        returns no value)
   */
  void addCalculateObserver(Runnable f);

  /**
   * Add the method to tell the controller the type of calculation to do.
   * 
   * @param c the method to do the calculation takes an OpType argument and returns no value
   */
  void addTypeObserver(Consumer<OpType> c);

  /**
   * The controller can call this to find the current expression to be evaluated.
   */
  String getExpression();

  /**
   * The controller should call this to display the evaluated answer to the user.
   */

  void setAnswer(String a);

  /**
   * Activate the user interface - all systems are go. All buttons start disabled - the controller
   * calls this method once it is ready to start calculating.
   */
  public void startView();
}
