package Question2;

public class InfixToPostfix 
{
	
	StackImplementation stack = new StackImplementation();
	
	//This method will return the precedence of the operator
	private int prec(String operand) 
	{ 
		switch (operand) 
		{

		case "=":
			return 1;
		case "||":
			return 2;
		case "&&":
			return 3;
		case "!":
			return 4;
		case "&":
			return 5;
		case "==":
		case "!=":
			return 6;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 7;
		case "+": 
		case "-": 
			return 8; 
		case "*": 
		case "/": 
			return 9; 
		case "^": 
			return 10; 
		} 
		return -1; 
	} 

	//This method will convert the infix expression to postfix expression
	private String evaluate(String[] exp) throws Exception {
		String postfix="";
//		stack.Push("N");
		
		for(int index=0;index<exp.length;index++) 
		{
			String character = exp[index];
			
			//checking for the character or the number
			if(isElementNumeric(character) || isElementAlphabet(character)) {
				postfix+=character; }

			else if(character.equals("(")) 
				stack.Push("("); 

			else if(character.equals(")")) 
			{ 
				while (!stack.isEmpty() && !(stack.Top().equals("("))) 
					postfix += stack.Pop(); 

				if (!stack.isEmpty() && !(stack.Top().equals("("))) 
					throw new Exception("Invalid Exception");            
				else
					stack.Pop(); 
			}

			//This case will execute when the operator is encountered
			else{ 

				while (!stack.isEmpty() && prec(character) <= prec(stack.Top())) 
					postfix += stack.Pop(); 
				stack.Push(character); 
			} 
		}	
		
		//finally merging the left operator with the postfix expression
		while (stack.top!=stack.head) 
			postfix += stack.Pop(); 
		return postfix;
	} 

	//This method will check foe the given string is number or not
	private boolean isElementNumeric(String element) {
		boolean result=false;
		for(int index=0;index<element.length();index++) {
			if(Character.isDigit(element.charAt(index)))
				result=true;
			else
				return result;
		}
		return result;
	}

	//This method will check for the string is valid alphabet or not
	private boolean isElementAlphabet(String element) {
		boolean result=false;
		
		if(element.length()>1)
			return result;
		
		if(Character.isLetter(element.charAt(0)))
			result=true;
		else
			return result;
		
		return result;
	}
	
	//This method will take the infix expression and split them in the basis of space 
	public String convertToPostfix(String input) throws Exception
	{
		String result="";
		String array[] = new String[100];
		array = input.split(" ");
		result = evaluate(array);
		return result;
		
	}
	
	
	
	

	
}