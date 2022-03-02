public class NonComparableElementException extends RuntimeException 
{
	private static final long serialVersionUID = -910983264612956396L;
	
	public NonComparableElementException()
	{
		super( "The element supplied doesn't implement comparable." ) ;
	}
}
