import java.util.Scanner;

public class FibonacciTester 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner( System.in ) ;
		System.out.print( "Enter a number: " ) ;
		int originalInput = scanner.nextInt() ;
		
		output = Fibonacci( originalInput , counter ) ;
		
		System.out.print( "The Fibonacci number is: " + output ) ; 
		
		scanner.close() ;
	}
	
	public static int input = 0 ;
	public static int output = 0 ;
	public static int counter = 1 ;
	public static int firstTerm = 0 ;
	public static int secondTerm = 1 ;
	
	public static int Fibonacci( int originalInput , int input ) 
	{
		if( originalInput == 0 )
			return 0 ;
		
		if( input != originalInput )
		{
			counter++ ;
			output = firstTerm + secondTerm ;
			firstTerm = secondTerm ;
			secondTerm = output ;
			
			Fibonacci( originalInput , counter ) ;
		}
		
		return output ;
	}
}
