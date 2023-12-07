package application;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Used by the test suite as a View - it is convenient to have a mock view with public fields.
 */
public class MockView implements ViewInterface {
  public Runnable evaluateMethodToBeNotified = null;
  public Consumer<OpType> setTypeToBeNotified = null;
  public String answer;
  public String question = "2 2 +";

  public void addCalculateObserver(Runnable f) {
    evaluateMethodToBeNotified = f;
  }

  public void addTypeObserver(Consumer<OpType> c) {
    setTypeToBeNotified = c;
  }

  public void startView() {

  }
  
  @Override
  public String getExpression() {
    return question;
  }

  @Override
  public void setAnswer(String a) {
    answer = a;
    
  }

  @Override
  public void setErrorMessage(String m) {
    // TODO Auto-generated method stub
    
  }
}
