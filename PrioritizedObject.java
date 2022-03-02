
public class PrioritizedObject<T> implements Comparable<PrioritizedObject>
{
	private static int nextOrder = 0 ;
	private int priority ;
	private int arrivalOrder ;
	private T element ;
	
	public PrioritizedObject( T element , int priority )
	{
		this.element = element ;
		this.priority = priority ;
		arrivalOrder = nextOrder ;
		nextOrder++ ;
	}
	
	public T getElement()
	{
		return element ;
	}
	
	public int getPriority()
	{
		return priority ;
	}
	
	public int getArrivalOrder()
	{
		return arrivalOrder ;
	}
	
	public String toString()
	{
		return ( element + " (" + priority + ";" + arrivalOrder + ")" ) ;
	}
	
	public int compareTo( PrioritizedObject obj )
	{
		int result ;
		if( priority > obj.getPriority() )
			result = 1 ;
		else if( priority < obj.getPriority() )
			result = -1 ;
		else if( arrivalOrder > obj.getArrivalOrder() )
			result = 1 ;
		else
			result = -1 ;
		
		return result ;
	}
}
