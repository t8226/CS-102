import java.util.Stack ;

public class Main
{
	public static void main( String[] args )
	{
		Graph<String> cities = new Graph<>() ;

		BuildGraph( cities ) ;

		System.out.println( cities.toString() ) ;
		
		final int size = cities.size() ;
		
																					// Create dist 	array with size equal to Graph vertex count
		double dist[] ;
		dist = new double[ size ] ;

																					// Create prev	array with size equal to Graph vertex count
		double prev[] ;
		prev = new double[ size ] ;
		
																					// Create known	array with size equal to Graph vertex count
		boolean known[] ;
		known = new boolean[ size ] ;

		for( int v = size - 1 ; v > 0 ; v-- )										// Instantiating all of the values
		{	
			dist[ v ] = cities.getAdjacencyMatrixValue( 0 , v ) ;
			prev[ v ] = 0 ;
			known[ v ] = false ;
		}
		
		dist[ 0 ] = 0 ;																
		
		for( int v = size - 1 ; v > 0 ; v-- )										// Goes through each vertex in the graph
		{
			int min_idx = 0 ;														// Instantiating minimum index and temporary values
			double temp = 0 ;
			
			for( int i = 0 ; i < size ; i++ )																
			{																								
				if( ( temp < dist[ v ] ) && ( known[ v ] == false ) )				// Checks to find the lowest distance that is also not known
				{
					min_idx = v ;
					temp = dist[ min_idx ] ;
				}
			}	
						
			known[ min_idx ] = true ;												// Assigning the city with the lowest distance to true
			
			for( int v2 = 0 ; v2 < size ; v2++ )
			{
				double alt = 0 ;											

				alt = temp + cities.getAdjacencyMatrixValue( min_idx , v2 ) ;		// Assigning a possible alternate route to see if it is shorter
				
				if( alt < dist[ v2 ] )												// Checking to see if an adjacent distance would be shorter
				{
					dist[ v2 ] = alt ;												// Assigning alternate route that is shorter to dist[]
					prev[ v2 ] = min_idx ;											// Reassigning the previous city in prev[]
				}
			}
		}
		
		System.out.println( "Shortest Paths\n--------------" );
		String result = "" ;
		int j = 0 ;
		
		Stack<String> stack = new Stack<String>() ;									// Creating a stack to print
		
		for( int i = 1 ; i < size ; i++ )											// For loop to go through all cities
		{
			stack.push( " -> " + cities.getVertexByIndex( i ) ) ;
			
			j = i ;																	
			while( prev[ j ] != 0 )													// Pushing all previous values on to stack 
			{
				stack.push( " -> " + cities.getVertexByIndex( (int) prev[ j ] ) ) ;
				j = (int) prev[ j ] ;
			}
			
			stack.push( "From Chicago to " + cities.getVertexByIndex( i ) + ": Chicago" ) ;	// Pushes beginning of the each line on to the stack
			
			while( ! stack.isEmpty() )												// Emptying out the stack into a string
			{
				result += stack.peek() ;
				stack.pop() ;
			}
			
			System.out.println( result ) ;											// Printing the resulting line and resetting the result String
			result = "" ;
		}
	}
	
	private static void BuildGraph( Graph<String> cities )
	{
		cities.addVertex( "Chicago" ) ;
		cities.addVertex( "Aurora" ) ;
		cities.addVertex( "Rockford" ) ;
		cities.addVertex( "Joliet" ) ;
		cities.addVertex( "Naperville" ) ;
		cities.addVertex( "Springfield" ) ;
		cities.addVertex( "Peoria" ) ;
		cities.addVertex( "Elgin" ) ;
		cities.addVertex( "Waukegan" ) ;
		cities.addVertex( "Cicero" ) ;
		cities.addVertex( "Champaign" ) ;
		cities.addVertex( "Bloomington" ) ;
		cities.addVertex( "Decatur" ) ;
		
		//Commented out edges indicate that the androids have a significant presence
		// in a territory along that route that makes using it impossible.
		
		cities.addEdge( "Chicago", "Aurora", 36.4 ) ;
		//cities.addEdge( "Chicago", "Rockford", 88.7 ) ;
		cities.addEdge( "Chicago", "Joliet", 44.9 ) ;
		//cities.addEdge( "Chicago", "Naperville", 35.3 ) ;
		//cities.addEdge( "Chicago", "Springfield", 201.7 ) ;
		//cities.addEdge( "Chicago", "Peoria", 165.7 ) ;
		cities.addEdge( "Chicago", "Elgin", 40.4 ) ;
		//cities.addEdge( "Chicago", "Waukegan", 41.2 ) ;
		cities.addEdge( "Chicago", "Cicero", 9.1 ) ;
		//cities.addEdge( "Chicago", "Champaign", 136.4 ) ;
		//cities.addEdge( "Chicago", "Bloomington", 137.6 ) ;
		//cities.addEdge( "Chicago", "Decatur", 180.2 ) ;
		
		cities.addEdge( "Aurora", "Rockford", 72.4 ) ;
		//cities.addEdge( "Aurora", "Joliet", 22.6 ) ;
		cities.addEdge( "Aurora", "Naperville", 10.3 ) ;
		//cities.addEdge( "Aurora", "Springfield", 180.0 ) ;
		cities.addEdge( "Aurora", "Peoria", 120.0 ) ;
		//cities.addEdge( "Aurora", "Elgin", 21.4 ) ;
		cities.addEdge( "Aurora", "Waukegan", 66.4 ) ;
		//cities.addEdge( "Aurora", "Cicero", 36.3 ) ;
		cities.addEdge( "Aurora", "Champaign", 160.4 ) ;
		//cities.addEdge( "Aurora", "Bloomington", 115.9 ) ;
		cities.addEdge( "Aurora", "Decatur", 161.1 ) ;

		//cities.addEdge( "Rockford", "Joliet", 110.3 ) ;
		cities.addEdge( "Rockford", "Naperville", 90.8 ) ;
		//cities.addEdge( "Rockford", "Springfield", 199.2 ) ;
		cities.addEdge( "Rockford", "Peoria", 136.1 ) ;
		//cities.addEdge( "Rockford", "Elgin", 52.2 ) ;
		cities.addEdge( "Rockford", "Waukegan", 130.9 ) ;
		//cities.addEdge( "Rockford", "Cicero", 89.0 ) ;
		cities.addEdge( "Rockford", "Champaign", 184.8 ) ;
		//cities.addEdge( "Rockford", "Bloomington", 135.1 ) ;
		cities.addEdge( "Rockford", "Decatur", 180.3 ) ;
		
		//cities.addEdge( "Joliet", "Naperville", 19.0 ) ;
		cities.addEdge( "Joliet", "Springfield", 165.5 ) ;
		//cities.addEdge( "Joliet", "Peoria", 129.6 ) ;
		cities.addEdge( "Joliet", "Elgin", 57.4 ) ;
		//cities.addEdge( "Joliet", "Waukegan", 69.8 ) ;
		cities.addEdge( "Joliet", "Cicero", 32.9 ) ;
		//cities.addEdge( "Joliet", "Champaign", 115.7 ) ;
		cities.addEdge( "Joliet", "Bloomington", 101.4 ) ;
		//cities.addEdge( "Joliet", "Decatur", 146.6 ) ;

		cities.addEdge( "Naperville", "Springfield", 179.3 ) ;
		//cities.addEdge( "Naperville", "Peoria", 143.4 ) ;
		cities.addEdge( "Naperville", "Elgin", 25.7 ) ;
		//cities.addEdge( "Naperville", "Waukegan", 58.4 ) ;
		cities.addEdge( "Naperville", "Cicero", 29.0 ) ;
		//cities.addEdge( "Naperville", "Champaign", 145.5 ) ;
		cities.addEdge( "Naperville", "Bloomington", 115.2 ) ;
		//cities.addEdge( "Naperville", "Decatur", 160.4 ) ;

		cities.addEdge( "Springfield", "Peoria", 74.3 ) ;
		//cities.addEdge( "Springfield", "Elgin", 213.2 ) ;
		cities.addEdge( "Springfield", "Waukegan", 232.7 ) ;
		//cities.addEdge( "Springfield", "Cicero", 195.8 ) ;
		cities.addEdge( "Springfield", "Champaign", 86.6 ) ;
		//cities.addEdge( "Springfield", "Bloomington", 67.9 ) ;
		cities.addEdge( "Springfield", "Decatur", 40.6 ) ;

		//cities.addEdge( "Peoria", "Elgin", 152.1 ) ;
		cities.addEdge( "Peoria", "Waukegan", 197.0 ) ;
		//cities.addEdge( "Peoria", "Cicero", 160.1 ) ;
		cities.addEdge( "Peoria", "Champaign", 89.4 ) ;
		//cities.addEdge( "Peoria", "Bloomington", 38.2 ) ;
		cities.addEdge( "Peoria", "Decatur", 84.9 ) ;

		cities.addEdge( "Elgin", "Waukegan", 56.7 ) ;
		//cities.addEdge( "Elgin", "Cicero", 35.9 ) ;
		cities.addEdge( "Elgin", "Champaign", 165.8 ) ;
		//cities.addEdge( "Elgin", "Bloomington", 148.1 ) ;
		cities.addEdge( "Elgin", "Decatur", 193.3 ) ;

		//cities.addEdge( "Waukegan", "Cicero", 50.7 ) ;
		cities.addEdge( "Waukegan", "Champaign", 180.5 ) ;
		//cities.addEdge( "Waukegan", "Bloomington", 167.9 ) ;
		cities.addEdge( "Waukegan", "Decatur", 213.1 ) ;

		//cities.addEdge( "Cicero", "Champaign", 140.8 ) ;
		cities.addEdge( "Cicero", "Bloomington", 130.9 ) ;
		//cities.addEdge( "Cicero", "Decatur", 176.1 ) ;

		cities.addEdge( "Champaign", "Bloomington", 50.7 ) ;
		//cities.addEdge( "Champaign", "Decatur", 49.1 ) ;

		cities.addEdge( "Bloomington", "Decatur", 46.3 ) ;
	}
}
