package Question2;



public class InfixToPostfix 
{
	
	StackImplementation stack = new StackImplementation();
	
	public int prec(String operand) 
	{ 
		switch (operand) 
		{

		case "=":
			return 1;
		case "||":
			return 2;
		case "&&":
			return 3;
		case "|":
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

	public void evaluate(String[] exp) {
		String postfix="";
		stack.Push("N");
		for(int index=0;index<exp.length;index++) {
			String character = exp[index];
			if(isElementNumeric(character) || isElementAlphabet(character)) {
				postfix+=character; }

			else if(character.equals("(")) 
				stack.Push("("); 

			else if(character.equals(")")) 
			{ 
				while (!stack.isEmpty() && !(stack.Top().equals("("))) 
					postfix += stack.Pop(); 

				if (!stack.isEmpty() && !(stack.Top().equals("("))) 
					System.out.println( "Invalid Expression"); // invalid expression                 
				else
					stack.Pop(); 
			}

			else{ 

				while (!stack.isEmpty() && prec(character) <= prec(stack.Top())) 
					postfix += stack.Pop(); 
				stack.Push(character); 
			} 
		}	
		while (stack.top!=stack.head) 
			postfix += stack.Pop(); 
		System.out.println(postfix);
	} 

	public boolean isElementNumeric(String element) {
		boolean result=false;
		for(int index=0;index<element.length();index++) {
			if(Character.isDigit(element.charAt(index)))
				result=true;
			else
				return result;
		}
		return result;
	}

	public boolean isElementAlphabet(String element) {
		boolean result=false;
		if(element.length()>1)
			return result;
		for(int index=0;index<element.length();index++) {
			if(Character.isLetter(element.charAt(index)))
				result=true;
			else
				return result;
		}
		return result;
	}

	
}
