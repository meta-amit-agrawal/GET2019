package Question1;

public class EvaluateExpression 
{
	
	Stack stack = new StackImplementation();
	
	/**
	 * This method evaluates the postfix expression
	 * @param exp
	 * @return the final result of the postfix expression
	 * @throws Exception if expression is not valid
	 */
    public int evaluate(String exp) throws Exception 
    {	
    	//loop to iterate over the expression given as input
        for(int index=0;index<exp.length();index++) 
        {
            char character = exp.charAt(index);
            if(Character.isDigit(character))
            	stack.Push(Character.getNumericValue(character));
            else 
            {
                int value1 = stack.Pop();
                int value2 = stack.Pop();

                switch(character) 
                {

                case '+': 
                    stack.Push(value2+value1); 
                    break; 

                case '-': 
                    stack.Push(value2-value1); 
                    break; 

                case '/': 
                    stack.Push(value2/value1); 
                    break; 

                case '*': 
                    stack.Push(value2*value1); 
                    break; 

                default:
                    throw new Exception("Wrong Expression");
               }
            }
        }
        //returns the top value by deleting the value(free space)
        return stack.Pop(); 
    }
}
