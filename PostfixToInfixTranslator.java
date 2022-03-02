import java.util.* ;

public class PostfixToInfixTranslator {

	public static void main(String[] args) 
	{
		// Declaration of variables
		boolean repeat = true ;
		String postfix , infix = null ;
		String response = "y" ;
		repeat = true ;
		
		while( repeat )
		{
			Scanner scanner = new Scanner (System.in) ;
			
			System.out.print ( "Enter a postfix expression: " ) ;
			postfix = scanner.nextLine() ;
			
			infix = evaluate( postfix ) ;
			
			System.out.println ( "In infix notation that is: " + infix ) ;
			
			System.out.println ( "Translate another expression? [y/n]" ) ;
			
			response = scanner.next().toLowerCase() ;
			System.out.println ( " " ) ;
			
			if( ! response.equals( "y" ) )
				repeat = false ;
			
			postfix = infix = null ;
		}
		
	}
	
	public static String evaluate ( String postfix )
	{
		ArrayStack<String> arrayStack = new ArrayStack<String>() ;
		String infix = "" ;
		String current = "" ;
		String operand1 = "" ;
		String operand2 = "" ;
		String temp = "" ;
		
		Scanner s = new Scanner( postfix ) ;
		
		current = s.next() ;
				
		while( s.hasNext() )
		{
			if( isOp( current ) )	// Case1: if current variable is an operator
			{
				operand1 = arrayStack.peek() ;
				arrayStack.pop() ;
				
				operand2 = arrayStack.peek() ;
				arrayStack.pop() ;
				
				temp = "(" + operand2 + current + operand1 + ")" ;
				
				arrayStack.push( temp ) ;			// Pushes the new expression on to the stack to be added to the infix expression later on.
			}
			else					// Case2: else current variable is an operand
			{
				arrayStack.push( current ) ;
			}
			
			current = s.next() ;
		}
		
		// For the final construction becasue the hasNext will not include my last variable entered.
		
		operand1 = arrayStack.peek() ;
		arrayStack.pop() ;
		
		operand2 = arrayStack.peek() ;
		arrayStack.pop() ;
		
		infix = "(" + operand2 + current + operand1 + ")" ;
		
		s.close() ;
		
		return infix ;
	}
	
	public static boolean isOp ( Object current )		// Returns true if current vairable is an operator (+ , - , * , /)
	{
		return current.equals( "+" ) || current.equals( "-" ) || current.equals( "*" ) || current.equals( "/" ) ;
	}

}
