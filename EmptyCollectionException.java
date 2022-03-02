
public class EmptyCollectionException extends RuntimeException
{
	private static final long serialVersionUID = 3017639590368587781L;

	public EmptyCollectionException()
	{
		super("The collection is empty.");
	}
	
	public EmptyCollectionException(String collectionType)
	{
		super("The " + collectionType + " is empty.");
	}
	
	
	
}
