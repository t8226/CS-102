public class IntersectionSimulation
{
	private final static int   EAST_WEST_GREEN_TIME    = 30 ;
	private final static int[] NORTH_SOUTH_GREEN_TIMES = { 20, 24, 30, 42 } ;
	private final static int[] CAR_INTERSECTION_RATES  = { 3,  5, 10 } ;
	private final static int[] CAR_QUEUEING_RATES      = { 5, 10, 30 } ;
	private final static int[] EXPERIMENT_DURATIONS    = { 3*60, 5*60, 10*60 } ;
			
	public static void main( String[] args )
	{
		CircularArrayQueue< Car > northBoundVehicles = new CircularArrayQueue< Car >() ;
		CircularArrayQueue< Car > southBoundVehicles = new CircularArrayQueue< Car >() ;
		CircularArrayQueue< Car > eastBoundVehicles = new CircularArrayQueue< Car >() ;
		CircularArrayQueue< Car > westBoundVehicles = new CircularArrayQueue< Car >() ;
		
		System.out.println( "E/W Green  N/S Green  Int. Rate  Q. Rate  Duration  N Cars  S Cars  E Cars  W Cars" ) ;
		System.out.println( "----------------------------------------------------------------------------------" ) ;
		
		for( int i = 0 ; i < 4 ; ++i )					
		{
			for( int j = 0 ; j < 3 ; ++j )				
			{
				for( int k = 0 ; k < 3 ; ++k )			
				{
					for( int l = 0 ; l < 3 ; ++l )		
					{
						int northSouthGreenTime = NORTH_SOUTH_GREEN_TIMES[ i ] ;
						int eastWestGreenTime = EAST_WEST_GREEN_TIME ;
						int carIntersectionRate = CAR_INTERSECTION_RATES [ j ] ;
						int carQueueingRate     = CAR_QUEUEING_RATES     [ k ] ;
						int experimentDuration  = EXPERIMENT_DURATIONS   [ l ] ;
						
						int greenLightTimer = 1 ;											// Starting the green light timer at 1 because the count also starts at 1
						
						boolean northSouthGreen = true ;									// Assigning the green lights where N/S starts green and E/W is red
						boolean eastWestGreen = false ;	
						
						for( int m = 1 ; m <= experimentDuration ; m++ ) 					// Evaluating each situation
						{
							// Dequeueing logic
							
							if( m % greenLightTimer == 0 )									// Testing to see if the current time % time passed at the light == 0
							{
								if( northSouthGreen && ! northBoundVehicles.isEmpty() )		// Checking that N/S lane has green light and that the lanes are not empty
								{															// to avoid getting an element not found exception
									northBoundVehicles.dequeue() ;
									southBoundVehicles.dequeue() ;
								}
								
								if( eastWestGreen && ! eastBoundVehicles.isEmpty() )		// Checking that E/W lane has green light and that the lanes are not empty 
								{															// to avoid getting an element not found exception
									eastBoundVehicles.dequeue() ;
									westBoundVehicles.dequeue() ;
								}
							}
							
							
							// Enqueueing logic
							
							if( m % carQueueingRate == 0 )									// Testing to see if current time % how often cars arrive at the intersection																
							{																// == 0, then adds a car to each of the individual lanes.
								northBoundVehicles.enqueue( new Car() ) ;
								southBoundVehicles.enqueue( new Car() ) ;
								eastBoundVehicles.enqueue( new Car() ) ;
								westBoundVehicles.enqueue( new Car() ) ;
							}
								
							
							// Changing Lights
							
							if( greenLightTimer == northSouthGreenTime && northSouthGreen )	// Testing to see if the running green light timer is equal to how long the light
							{																// is supposed to stay green, and that the light is green.
								greenLightTimer = 0 ;										// Resetting timer to 0 so that when it goes up by 1 it is started at the right index
								
								northSouthGreen = false ;									// Reassigning which light is currently green
								eastWestGreen = true ;
							}
							
							if( greenLightTimer == eastWestGreenTime && eastWestGreen )		// Testing to see if the running green light timer is equal to how long the light
							{																// is supposed to stay green, and that the light is green.
								greenLightTimer = 0 ;										// Resetting timer to 0 so that when it goes up by 1 it is started at the right index
									
								northSouthGreen = true ;									// Reassigning which light is currently green
								eastWestGreen = false ;
							}
														
							greenLightTimer++ ;
						}
						
						
						// Printing all values for the current situation
						
						System.out.printf( "%6d %10d %9d %9d %9d %8d %7d %7d %7d %n" , EAST_WEST_GREEN_TIME , northSouthGreenTime , carIntersectionRate , carQueueingRate ,
								experimentDuration , northBoundVehicles.size() , southBoundVehicles.size() , eastBoundVehicles.size() , westBoundVehicles.size() ) ;
						
						clear( northBoundVehicles ) ;										// Clearing all of the queues so that they are ready to be used in the next test
						clear( southBoundVehicles ) ;
						clear( eastBoundVehicles ) ;
						clear( westBoundVehicles ) ;
					}
				}
			}
		}
	}
	
	private static void clear( CircularArrayQueue< Car > queue)								// Used to clear the queues
	{
		int size = queue.size() ;
		
		for( int i = 0 ; i < size ; i++ )
		{
			queue.dequeue() ;
		}
	}
	
	private static class Car
	{
		//This class can be completely empty.
		// We just need *something* in our queues.
		// It's the count of items in the queues we are concerned with,
		//  not the properties of the items in the queues.
	}
}
