import java.util.Scanner;

public class PalindromeChecker 
{

	public static void main(String[] args) 
	{
		String input = "" ;
		boolean queue ;
		boolean stack ;
		String repeat = "y" ;
		Scanner scanner = new Scanner( System.in ) ;				// Creating all variables that will be used within the while loop
		
		while( repeat.equals( "y" ) )								// Will prompt for a change at the end of the loop each repeat
		{
			System.out.print( "Enter a string: " ) ;
			input = scanner.nextLine() ;							// Take user input
			
			queue = qIsPalindrome( input ) ;						// Evaluating using queue
			stack = sIsPalindrome( input ) ;						// Evaluating using stack
			
			if( queue )												// if is with a queue
				System.out.println( "Accroding to the queue method that statement IS a palindrome." ) ;
			else
				System.out.println( "Accroding to the queue method that statement IS NOT a palindrome." ) ;
			
			if( stack )												// if is with a stack
				System.out.println( "Accroding to the stack method that statement IS a palindrome." ) ;
			else
				System.out.println( "Accroding to the stack method that statement IS NOT a palindrome." ) ;
			
			System.out.print( "Try another (y/n)? " ) ;				// Prompts for repeat
			repeat = scanner.nextLine() ;
			
			System.out.println() ;									// Adding space between tries
		}
		
		scanner.close() ;											// Close scanner
	}

	public static boolean qIsPalindrome( String input ) 
	{
		String output = "" ;
		Scanner inputScanner = new Scanner( input ) ;
		LinkedQueue<String> linkedQueue = new LinkedQueue<String>() ;		// Creates all variables and Queue

		for( int i = 0 ; i < input.length() ; i++ )							// Enqueue all values into the queue
		{
			linkedQueue.enqueue( String.valueOf( input.charAt( i ) ) ) ;
		}
		
		while( linkedQueue.size() > 0 ) 									// Take out of queue and move to output for evaluation
		{
			output = linkedQueue.first() + output ;

			linkedQueue.dequeue() ;	
		}
		
		inputScanner.close() ;												// Close scanner
		
		return output.equals( input ) ;										// Returns true if input and output are equal
	}
	
	public static boolean sIsPalindrome( String input )
	{
		String output = "" ;
		LinkedStack<String> linkedStack = new LinkedStack<String>() ;		// Create all variables and stack
		
		for( int i = 0 ; i < input.length() ; i++ )							// Pushing values into stack
		{
			linkedStack.push( String.valueOf( input.charAt( i ) ) ) ;
		}
		
		while( linkedStack.size() > 0 )										// Taking values in stack and assigning to output
		{
			output = output + linkedStack.peek() ;
			
			linkedStack.pop() ;
		}
		
		return input.equals( output ) ;										// Returns true if input and output are equal
	}
}
