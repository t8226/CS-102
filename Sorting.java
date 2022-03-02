public class Sorting 
{
	public static <T extends Comparable<T>> void execute( T[] ia )
	{
		System.out.println( "Algorithm          # of Comparisons" ) ;
        System.out.println( "-----------------------------------" ) ;
        
        bubbleSort( ia.clone() ) ;
        System.out.println( "Bubble Sort              " + getBubbleSortComparisons() ) ;
        
        selectionSort( ia.clone() ) ;
        System.out.println( "Selection Sort           " + getSelectionSortComparisons() ) ;
        
        insertionSort( ia.clone() ) ;
        System.out.println( "Insertion Sort           " + getInsertionSortComparisons() ) ;
        
        mergeSort( ia.clone() ) ;
        System.out.println( "Merge Sort               " + getInsertionSortComparisons() ) ;
        
        quickSort( ia.clone() ) ;
        System.out.println( "Quick Sort               " + getInsertionSortComparisons() ) ;
        
        System.out.println() ;
	}
	
	private static int bubbleSortComparisons = 0 ;
	
	public static int getBubbleSortComparisons()
	{
		return bubbleSortComparisons ; 
	}
	
	private static int selectionSortComparisons = 0 ;
	
	public static int getSelectionSortComparisons()
	{
		return selectionSortComparisons ;
	}
	
	private static int insertionSortComparisons = 0 ;
	
	public static int getInsertionSortComparisons()
	{
		return insertionSortComparisons ;
	}
	
	private static int mergeSortComparisons = 0 ;
	
	public static int getMergeSortComparisons()
	{
		return mergeSortComparisons ;
	}
	
	private static int quickSortComparisons = 0 ;
	
	public static int getQuickSortComparisons()
	{
		return quickSortComparisons ;
	}
	
	public static <T extends Comparable<T>> void bubbleSort( T[] data ) throws NullPointerException
	{
		bubbleSortComparisons = 0 ;
		
		if( data == null)
			throw new NullPointerException() ;
		
		for( int position = data.length - 1 ; position >= 0 ; position-- )
		{
			for( int i = 0 ; i < position ; i++ )
			{
				bubbleSortComparisons++ ;
				if( data[ i ].compareTo( data[ i + 1 ] ) > 0 )
				{
					swap( data , i , i + 1 ) ;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void selectionSort( T[] data )
	{
		selectionSortComparisons = 0 ;
		
		for( int i = 0 ; i < data.length - 1 ; ++i)
		{
			int min = i ;
			
			for( int j = i + 1 ; j < data.length ; ++j )
			{
				selectionSortComparisons++ ;
				
				if( data[ j ].compareTo( data[ min ] ) < 0 )
				{
					min = j ; 
				}
			}
			
			if( i != min )
			{
				swap( data , i , min ) ;	
			}
		}
	}
	
	
	public static <T extends Comparable<T>> void insertionSort( T[] data )
	{
		insertionSortComparisons = 0 ;
		
		for( int index = 1 ; index < data.length ; ++index )
		{
			T key = data[ index ] ;
			int position = index ;
						
			while( position > 0 )
			{
				insertionSortComparisons++ ;
				
				if( data[ position - 1 ].compareTo( key ) > 0 )
				{				
					data[ position ] = data[ position - 1 ] ;
					position-- ;
				}
				else
				{
					break ;
				}
			}
			
			data[ position ] = key ;
		}
	}
	
	
	private static <T> void swap( T[] data , int index1 , int index2 ) 
	{
		T temp = data[ index1 ] ;
		data[ index1 ] = data[ index2 ] ;
		data[ index2 ] = temp ;
	}
	
	
	
	// QUICK SORT
	public static <T extends Comparable<T>> void quickSort( T[] data )
	{
		quickSortComparisons = 0 ;
		
		quickSort( data , 0 , data.length - 1 ) ;
	}
	
	
	private static <T extends Comparable<T>> void quickSort( T[] data , int min , int max )
	{			
		if( min < max )
		{
			int indexOfPartition = partition( data , min , max ) ;
			quickSort( data , min , indexOfPartition - 1 ) ;
			quickSort( data , indexOfPartition + 1 , max ) ;
		}
	}
	
	
	private static <T extends Comparable<T>> int partition( T[] data , int min , int max ) 
	{
		int middle = ( min + max ) / 2 ;
		T partitionElement = data[ middle ] ;
		
		swap( data , middle , min ) ;
		
		int left = min ;
		int right = max ;
		while( left < right )
		{
			quickSortComparisons++ ;
			while( left < right && data[ left ].compareTo( partitionElement ) <= 0 )
			{
				++left ;
				quickSortComparisons++ ;
			}
			
			quickSortComparisons++ ;
			while( data[ right ].compareTo( partitionElement ) > 0 )
			{
				--right ;
				quickSortComparisons++ ;
			}
			
			if( left < right )
				swap( data , left , right ) ;
		}
		
		swap( data , min , right ) ;
		
		return right ;
	}
	
	public static <T extends Comparable<T>> void mergeSort( T[] data )
	{
		mergeSortComparisons = 0 ;
		
		mergeSort( data , 0 , data.length - 1 ) ;
	}
	
	private static <T extends Comparable <T>> void mergeSort( T[] data , int min , int max )
	{	
		if( min < max )
		{			
			int mid = ( min + max ) / 2 ;
			mergeSort( data , min , mid ) ;
			mergeSort( data , mid + 1 , max ) ;
			merge( data , min , mid , max ) ;
		}
		
	}
	
	private static <T extends Comparable <T>> void merge ( T[] data , int min , int mid , int max ) 
	{
		@SuppressWarnings("unchecked")
		T[] temp = ( T[] ) new Comparable[ data.length ] ;
		
		int first1 = min ;	// Represents the first half of the list
		int last1 = mid ;
		
		int first2 = mid + 1 ; // Represents the second half of the list
		int last2 = max ;
		
		int index = first1 ;
		
		while( first1 <= last1 && first2 <= last2 )
		{
			mergeSortComparisons++ ;
			
			if( data[ first1 ].compareTo( data[ first2 ] ) < 0 )
			{
				temp[ index ] = data[ first1 ] ;
				++first1 ;
			}
			else
			{
				temp[ index ] = data[ first2 ] ;
				++first2 ;
			}
			++index ;
		}
		
		while( first1 <= last1 )
		{
			temp[ index ] = data[ first1 ] ;
			++first1 ;
			++index ;
		}
		
		while( first2 <= last2 )
		{
			temp[ index ] = data[ first2 ] ;
			++ first2 ;
			++ index ;
		}
		
		for( int i = min ; i <= max ; ++i )
			data[ i ] = temp[ i ] ;
	}	
	
	
	public <T extends Comparable<T>> boolean isSorted( T[] data )
	{
////		for( int i = 0 ; i < data.length - 1 ; i++ )
////		{
////			if( data[ i ] > data[ i + 1 ] )				TODO: Could not get to work. Worked on it for hours and nothing.
////				return false ;								  Even though it extends Comparable it said that > is not defined
////		}
//		
		return true ;
	}
}