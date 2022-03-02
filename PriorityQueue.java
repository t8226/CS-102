
public class PriorityQueue<T> extends ArrayHeap<PrioritizedObject<T>>
{
	public PriorityQueue()
	{
		super() ;
	}
	
	public void addElement( T object , int priority )
	{
		PrioritizedObject<T> obj = new PrioritizedObject<T>( object , priority ) ;
		super.addElement( obj ) ;
	}
	
	public T removeNext()
	{
		PrioritizedObject<T> obj = ( PrioritizedObject<T> )super.removeMin() ;
		return obj.getElement() ;
	}
}
