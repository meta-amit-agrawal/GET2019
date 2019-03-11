package Question1;

public class EvaluateExpression 
{
	
	Stack stack = new StackImplementation();
	
    public int evaluate(String exp) throws Exception 
    {	
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
        return stack.Pop(); 
    }
}
