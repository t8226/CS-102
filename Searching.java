
public class Searching 		// Doesn't need to be genericable because it will just find and return a value
{
	public static <T extends Comparable<T>> void execute( T[] ia , T target )
	{
		System.out.println( "Search             # of Comparisons" ) ;
        System.out.println( "-----------------------------------" ) ;
        
        linearSearch( ia.clone() , target ) ;
        System.out.println( "Linear Search             " + getLinearSearchComparisons() ) ;
        
        binarySearch( ia.clone() , target ) ;
        System.out.println( "Binary Search             " + getBinarySearchComparisons() ) ;
        
        System.out.println() ;
	}
	
	private static int linearSearchComparisons = 0 ;
	
	public static int getLinearSearchComparisons()
	{
		return linearSearchComparisons ; 
	}
	
	private static int binarySearchComparisons = 0 ;
	
	public static int getBinarySearchComparisons()
	{
		return binarySearchComparisons ;
	}
	
	public static <T> boolean linearSearch( T[] data , T target )
	{
		return linearSearch( data , 0 , data.length - 1 , target ) ;
	}
	
	public static <T> boolean linearSearch( T[] data , int min , int max , T target ) throws NullPointerException , NonComparableElementException ,
		EmptyCollectionException
	
	{	// indicate <T> before any data type
		if( target == null )
			throw new NullPointerException() ;
		
		if( ! ( target instanceof Comparable ) )
			throw new NonComparableElementException() ;
		
		if( data.length == 0 )
			throw new EmptyCollectionException() ;
		
		int index = min ;
		boolean found = false ;
		
		linearSearchComparisons++ ;
		while( !found && index <= max )
		{
			linearSearchComparisons++ ;
			found = data[ index ].equals( target ) ;
			index++ ;
		}
		
		return found ;
	}
	
	public static <T extends Comparable<T>> boolean binarySearch( T[] data , T target )
	{
		return binarySearch ( data , 0 , data.length - 1 , target ) ;
	}
	
	public static <T extends Comparable<T>> boolean binarySearch( T[] data , int min , int max , T target ) throws NullPointerException ,
		NonComparableElementException , NotSortedException , EmptyCollectionException
	
	{			  // extends Comparable will ensure that we can compare whatever is passed in as [] data and target
		if( target == null )
			throw new NullPointerException() ;
		
		if( ! ( target instanceof Comparable ) )
			throw new NonComparableElementException() ;
		
		Sorting sorting = new Sorting() ;
		
		if( ! sorting.isSorted( data ) )
			throw new NotSortedException() ;
		
		if( data.length == 0 )
			throw new EmptyCollectionException() ;
		
		
		boolean found = false ;
		int midpoint = ( min + max ) / 2 ;
		
		binarySearchComparisons++ ;
		int compareVal = data[ midpoint ].compareTo( target ) ;
		
		binarySearchComparisons++ ;
		
		if(compareVal == 0 )
		{
			binarySearchComparisons++ ;
			
			found = true ;
		}
		else if( compareVal > 0 )
		{
			binarySearchComparisons++ ;
			
			if( min <= midpoint - 1 )
				found = binarySearch( data , min , midpoint - 1 , target ) ;
		}
		else if( midpoint < max )
		{	
			found = binarySearch( data , midpoint + 1 , max , target ) ;
		}
				
		return found ;
	}
}
