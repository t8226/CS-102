import java.util.Scanner ;

public class CityInformation {

	public static void main(String[] args) 
	{
		
		CityInformation.execute() ; 

	}
	
	private static int topic = 0 ;
	private static String neighborhood = "" ;
	
	private static void execute()
	{
		Scanner scanner = new Scanner( System.in ) ;
		
		System.out.println( "Welcome! Please enter the neighborhood that you want information about below.\n" ) ;
		
		neighborhood = scanner.next() ;
		
		neighborhood = neighborhood.toUpperCase() ;
		
		if( ! ( neighborhood.equals( "NORTH" ) || neighborhood.equals( "EAST" ) || neighborhood.equals( "SOUTH" ) || neighborhood.equals( "WEST" ) ) ) 
		{
			System.out.println( "INPUT NOT VALID. PLEASE TRY AGAIN.\n" ) ;
			CityInformation.execute() ;
		}
		
		System.out.println( "You entered: " + neighborhood ) ;
		System.out.println( "\nWhat do you want to know about the " + neighborhood + " neighborhood? " ) ;
		System.out.println( "1. TRANSPORTATION\n2. PARKS\n3. RECREATION\n4. FOOD\n5. OTHER\n" ) ;
		System.out.println( "(Enter the number of topic that you want information about)\n" ) ;
		
		topic = scanner.nextInt() ;
		
		if( topic == 2 )
			Info.parks( neighborhood ) ;
		else if( neighborhood.equals( "NORTH" ) )
			CityInformation.north( topic ) ;
		else if( neighborhood.equals( "EAST" ) )
			CityInformation.east( topic ) ;
		else if( neighborhood.equals( "SOUTH" ) )
			CityInformation.south( topic ) ;
		else if( neighborhood.equals( "WEST" ) )
			CityInformation.west( topic ) ;
			
		scanner.close() ;
	}

	private static void north( int topic ) 
	{
		if( topic == 1 )
			Info.NorthTransportation() ;
	}
	
	private static void east( int topic ) 
	{
		
	}
	
	private static void south( int topic )
	{
		
	}
	
	private static void west( int topic )
	{
		
	}
}
