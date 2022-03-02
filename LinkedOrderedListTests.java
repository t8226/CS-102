import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class LinkedOrderedListTests {

	@SuppressWarnings("unused")
	@Test
	public void Construction() 
	{
		try
		{
			LinkedOrderedList<Integer> loli = new LinkedOrderedList<>() ;								// Making sure construction does not cause an excpetion
		}
		catch( Exception exc )
		{
			fail( "Construction() unexpected exception: " + exc.getMessage() ) ;
		}
	}
	
	@Test
	public void ConstructionState()
	{
		try
		{
			LinkedOrderedList<Integer> loli = new LinkedOrderedList<>() ;
			assertTrue( loli.isEmpty() , "ConstructionState() empty list not reported as empty." ) ;	// Asserting is trying it and if not true then throws excpetion
			assertEquals( 0 , loli.size() , "ConstructionState() empty list not reported as size 0." ) ;
		}
		catch( Exception exc )
		{
			fail( "ConstructionState() unexpected exception: " + exc.getMessage() ) ;
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void ConstructionStateFirstLast()
	{
		try
		{
			LinkedOrderedList<Integer> loli = new LinkedOrderedList<>() ;
			
			try
			{
				Integer first = loli.first() ;
				fail( "ConstructionStateFirstLast() expected exception (first()) not thrown." ) ;		// Fails because we expected the exception before now
			}
			catch( EmptyCollectionException exc )														// Expecting the exception
			{
				// We wanted this exception to be thrown
			}
			
			try
			{
				Integer alst = loli.last() ;
				fail( "ConstructionStateFirstLast() expected exception (last()) not thrown." ) ;
				
			}
			catch( EmptyCollectionException exc )
			{
				// We wanted this exception
			}
		}
		catch( Exception exc )
		{
			fail( "ConstructionStateFirstLast() unexpected exception: " + exc.getMessage() ) ;
		}
	}
	
	@Test
	public void Add()
	{
		try
		{
			LinkedOrderedList<Integer> loli = new LinkedOrderedList<>() ;
			loli.add( 5 ) ;
			assertFalse( loli.isEmpty() , "Add() Non-empty list reported empty." ) ;
			assertEquals( 1 , loli.size() , "Add() List of size 1 not reported as 1." ) ;
			assertEquals( 5, loli.first(), "Add() First element not equal to 5." ) ;
			assertEquals( 5 , loli.last(), "Add() Last element not equal to 5." ) ;
			
			loli.add( 3 ) ;
			assertEquals( 2, loli.size() , "Add() List of size 2 not reported as 2." ) ;
			assertEquals( 3 , loli.first() , "Add() First element not equal to 3." ) ;
			assertEquals( 5 , loli.last() , "Add() Last elemenet not equal to 5 (2)." ) ;
			
			loli.add( 9 ) ;
			assertEquals( 3 , loli.size() , "Add() List of size 3 not reported as 3." ) ;
			assertEquals( 3 , loli.first() , "Add() First element not equal to 3 (2)." ) ;
			assertEquals( 9 , loli.last() , "Add() Last elemenet not equal to 9." ) ;
			
			loli.add( 7 ) ;
			assertEquals( 4 , loli.size(), "Add() List of size 4 not reported as 4." ) ;
			assertEquals( 3 , loli.first() , "Add() First element not equal to 3 (3)." ) ;
			assertEquals( 9, loli.last(), "Add() Last element not equal to 9 (2)." ) ;
			
			Iterator<Integer> iti = loli.iterator() ;													// So we can get access to the 3rd element
			iti.next() ;
			iti.next() ;
			Integer seven = iti.next() ;
			assertEquals( 7 , seven , "Add() Third Item was not equal to 7." ) ;
			
			try
			{
				LinkedOrderedList<NonComparableElementException> lol = new LinkedOrderedList<>() ;
				lol.add( new NonComparableElementException() ) ;
				fail( "Add() Non-comparable element 'successfully' added to the ordered list." ) ;
			}
			catch( NonComparableElementException exc ) 
			{
				// We wanted this exception
			}
		}
		catch( Exception exc )
		{
			fail( "Add() unexpected exception: " + exc.getMessage() ) ;
		}
	}

}
