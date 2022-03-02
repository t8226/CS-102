
public class Contact implements Comparable<Contact>		// Needs to be able to compare with itself
{
	private String _firstName ;
	private String _lastName ;
	private String _phone ;
	
	public Contact( String first , String last , String phone ) 
	{
		_firstName = first ;
		_lastName = last ;
		_phone = phone ;
	}
	
	public String toString()
	{
		return _lastName + ", " + _firstName + " - (" + _phone + ")" ;
	}
	
	public int compareTo( Contact o ) // Java doesn't know how to compare contacts so we have to do it for it
	{
		int result = _lastName.compareTo( o._lastName ) ; // Will return 0, negative, or positive
		
		if( result == 0 )
			result = _firstName.compareTo( o._firstName ) ;

		
		return result ;
	}
	
	public boolean equals( Object o )
	{
		return compareTo ( ( Contact ) o ) == 0 ;
	}
	
}
