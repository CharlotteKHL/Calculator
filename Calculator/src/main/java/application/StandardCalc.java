package application;

/**
 * Calculator responsible with evaluating expressions in Standard form.
 * 
 * @author The below algorithm to evaluate is a simplified version of Dijkstra's shunting-yard
 *         algorithm used to convert infix notation to postfix.
 * 
 * @author Descriptions used to guide my programming can be found at these two links:
 *         https://www.chris-j.co.uk/parsing.php https://brilliant.org/wiki/shunting-yard-algorithm/
 * 
 */
public class StandardCalc {

  private OpStack values = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();
  private String output;

  /**
   * Evaluates an expression in Standard form and returns answer.
   * 
   * @param expression is the string to be evaluated
   * @return the result of the evaluation of the expression in standard form
   * @throws BadTypeException if getter for Entry does not match type of object
   * @throws EmptyStackException if pop or top called on an empty stack
   * @throws InvalidExpressionException if expression is invalid in standard form
   */
  public float evaluate(String expression)
      throws EmptyStackException, BadTypeException, InvalidExpressionException {

    String[] list = expression.split(" ");
    output = "";

    for (int index = 0; index < list.length; index++) {

      switch (list[index]) {

        case "*":
          values.push(Symbol.TIME);
          break;
          
        case "+":
          values.push(Symbol.PLUS);
          break;

        case "-":
          if ((values.size() != 0) && (values.top() == Symbol.MINUS)) {
            values.pop();
            output = output + " -";
          }
          values.push(Symbol.MINUS);
          break;

        default:
          if (output == "") {
            output = list[index];
          } else {
            output = output + " " + list[index];
          }

      }
    }
    
    int currentSize = values.size();

    for (int index = 0; index < currentSize; index++) {
      Symbol operator = values.pop();

      switch (operator) {

        case PLUS:
          output = output + " +";
          break;
        case TIME:
          output = output + " *";
          break;
        default:
          output = output + " -";
      }
    }

    float answer = rpCalc.evaluate(output);

    return answer;
  }

}
