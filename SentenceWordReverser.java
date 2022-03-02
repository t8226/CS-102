import java.util.* ;

public class SentenceWordReverser {

	public static void main(String[] args) 
	{
		String input = "" ;
		String output = "" ;
		Scanner iScanner = new Scanner( System.in ) ;
		
		System.out.print( "Enter a sentence: ") ;
		input = iScanner.nextLine();
		
		output = reverse( input ) ;
		
		System.out.print( "Reversing each word: " + output ) ;
		
		iScanner.close();
	}
	
	public static String reverse( String input )
	{
		ArrayStack arrayStack = new ArrayStack() ;
		Scanner nScanner = new Scanner( input ) ;
		String current = "" ;
		String output = "" ;
		
		while( nScanner.hasNext() )
		{
			current = nScanner.next() ;
			
			for( int i = 0 ; i < current.length() ; i ++ )
			{
				arrayStack.push( current.charAt( i ) ) ;
			}
			
			for( int i = current.length() ; i  > 0 ; i-- )
			{
				output += arrayStack.peek() ;
				arrayStack.pop() ;
			}
			
			output += " " ;
		}
		
		nScanner.close() ;
		
		return output ;
	}

}
