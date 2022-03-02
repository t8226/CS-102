import java.util.Iterator ;

public interface BinaryTreeADT<T>
{
	public T getRootElement() ;
	
	public boolean isEmpty() ;
	
	public int size() ;
	
	public boolean contains( T targetElement ) ;
	
	public T find( T targetElement ) throws ElementNotFoundException ;
	
	public Iterator<T> iteratorInOrder() ;
	
	public Iterator<T> iteratorPreOrder() ;
	
	public Iterator<T> iteratorPostOrder() ;
}
