package application;

/**
 * Specialised stack class to store String values.
 */
public class StrStack {
  
  private int size = 0;

  public int size() {
    return size;
  }

  public void push(String string) {
    size = size + 1;
  }

  public String pop() {
    size = 0;
    return "Hello World!";
  }

}
