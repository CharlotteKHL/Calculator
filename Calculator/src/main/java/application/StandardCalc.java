package application;

import java.util.HashMap;
import java.util.Map;

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
  private Map<Symbol, Integer> precedence = new HashMap<Symbol, Integer>();
  
  /**
   * Constructor for StandardCalc, initialises precedence of operators in a HashMap.
   */
  public StandardCalc() {
    precedence.put(Symbol.PLUS, 0);
    precedence.put(Symbol.MINUS, 0);
    precedence.put(Symbol.TIME, 1);
    precedence.put(Symbol.DIVIDE, 1);
    
  }

  /**
   * Evaluates an expression in Standard form and returns answer.
   * 
   * @param expression is the string to be evaluated
   * @return the result of the evaluation of the expression in standard form
   * @throws BadTypeException thrown if getter for Entry does not match type of object
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   * @throws InvalidExpressionException thrown if expression is invalid in standard form
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
        
        case "/":
          if ((values.size() != 0) && (values.top() == Symbol.DIVIDE)) {
            addOpToOutput();
          }
          values.push(Symbol.DIVIDE);
          break;
          
        case "+":
          while ((values.size() != 0) 
              && (precedence.get(values.top()) >= precedence.get(Symbol.PLUS))) {
            addOpToOutput();
    
          }
          values.push(Symbol.PLUS);
          break;

        case "-":
          while ((values.size() != 0) 
              && (precedence.get(values.top()) >= precedence.get(Symbol.MINUS))) {
            addOpToOutput();
    
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
      addOpToOutput();
    }

    float answer = rpCalc.evaluate(output);

    return answer;
  }
  
  /**
   * Identifies the operator on the top of stack to add to expression to calculate it RevPolishForm.
   * 
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   * @throws BadTypeException thrown if getter for Entry does not match type of object
   */
  private void addOpToOutput() throws EmptyStackException, BadTypeException {
    Symbol operator = values.pop();
    
    switch (operator) {

      case PLUS:
        output = output + " +";
        break;
      case TIME:
        output = output + " *";
        break;
      case DIVIDE:
        output = output + " /";
        break;
      default:
        output = output + " -";
    }
    
  }

}
