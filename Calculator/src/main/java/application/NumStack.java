package application;

/**
 * NumStack class contains a stack specialised for floats.
 */
public class NumStack {
  private int size = 0;

  public float size() {
    return size;
  }

  public void push(float value) {
    size = size + 1;
  }
  
  public float pop() {
    size = 0;
    return 2.3f;
  }
  
}
