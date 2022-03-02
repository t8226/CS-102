
public class ElementNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 8707268377524493433L;
	
	public ElementNotFoundException ( String collection )
	{
		super ( "The target element is not in this " + collection + "." ) ;
	}
}
