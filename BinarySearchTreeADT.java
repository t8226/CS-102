public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T>
{
	public void addElement( T element ) ;
	
	public T removeElement( T targetElement ) throws ElementNotFoundException ;
	
	public void removeAllOccurences( T targetElement ) ;
}
