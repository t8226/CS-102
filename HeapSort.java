
public class HeapSort<T>
{
	public static <T extends Comparable<T>> void Sort( T[] data )
	{
		ArrayHeap<T> temp = new ArrayHeap<T>() ;
		
		for( int i = 0 ; i < data.length ; i++ )
			temp.addElement( data [ i ] ) ;
		
		int count = 0 ;
		while( ! ( temp.isEmpty() ) )
		{
			data[ count ] = temp.removeMin() ;
			count++ ;
		}
	}
}
