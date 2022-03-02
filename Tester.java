
public class Tester extends Object // Every single class in Java extends Object
{
    public static void main( String[] args )
    {
//    	//Searching Tester
//        Integer[] ia = { 1,2,8,5,3,5,6,8,3,6 } ;
//    	
//        Searching.execute( ia , 375546 ) ;
//        
//    	//Sorting Tester        
//        Sorting.execute( ia ) ;
    	
    	System.out.println( sumRange( 1 , 10 ) ) ;
    	
    }
    
    public static int result = 0 ;
    
    public static int sumRange( int first , int second )
    {
    	if( first != second )
    	{
    		result += first ;
    		first++ ;
    		sumRange( first , second ) ;
    	}
    	
    	int temp = result ;
    	result = 0 ;
    	
    	return temp ;
    }

}