public interface ListADT<T> 
{
	public T removeFirst() throws EmptyCollectionException ;
	
	public T removeLast() throws EmptyCollectionException ;
	
	public T remove ( T element ) throws EmptyCollectionException , ElementNotFoundException ;
	
	public T first() throws EmptyCollectionException ;
	
	public T last() throws EmptyCollectionException ;
	
	public boolean contains ( T target ) throws EmptyCollectionException ;
	
	public int size() ;
	
	public boolean isEmpty() ;
}
