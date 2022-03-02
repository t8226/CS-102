import java.util.Arrays;
import java.util.LinkedList ;
import java.util.Queue ;

public class RadixSort 
{
	public static void main( String[] args )
	{
		Integer[] list = { 7843 , 4568 , 8765 , 6543 , 7865 , 4532 , 9987 , 3241 , 6589 , 6622 , 1211 , 7777 } ;
		
		@SuppressWarnings("unchecked")
		Queue<Integer>[] digitQueues = ( Queue < Integer >[]) new LinkedList[ 10 ] ; // Allocating an array of 10 items that are each a LinkedList of type Integer
		
		// A 2D native array of size 10 in the major axis and is a LinkedList<Integer> (10 of them) in the minor axis
		for( int i = 0 ; i < digitQueues.length ; ++i )
			digitQueues[ i ] = new LinkedList<Integer>() ;
		
		for( int i = 0 ; i < 4 ; ++i )
		{
			for( int j = 0 ; j < list.length ; ++j )
			{
				// This is the string/index approach, would be more efficient to do with math and mod but also much more complex.
				String temp = String.valueOf( list[ j ] ) ;
				int digit = Character.digit( temp.charAt ( 3 - i ) , 10 ) ;
				digitQueues[ digit ].add( list[ j ] ) ;
			}
			
			int num = 0 ;
			for( int j = 0 ; j < digitQueues.length ; ++j )
			{
				while( ! ( digitQueues[ j ].isEmpty() ) )
				{
					list[ num ] = digitQueues[ j ].remove() ;
					++num ;
				}
			}
		}
		
		System.out.println( Arrays.toString( list ) ) ;
	}
}
