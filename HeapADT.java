public interface HeapADT<T> extends BinaryTreeADT<T> 
{
	public T findMin() ;
	
	public void addElement( T obj ) ;
	
	public T removeMin() throws EmptyCollectionException ;
}
