public class NotSortedException extends RuntimeException
{
	private static final long serialVersionUID = 2365248600666122924L;

	public NotSortedException()
	{
		super( "The collection of data is not sorted." ) ;
	}
}
