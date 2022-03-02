public class HeapNode<T> extends BinaryTreeNode<T>
{
	protected HeapNode<T> _parent ;
	
	public HeapNode( T obj)
	{
		super( obj ) ;
		_parent = null ;
	}
	
	public HeapNode<T> getParent()
	{
		return _parent ;
	}
	
	public void setElement( T obj )
	{
		_element = obj ;
	}
	
	public void setParent( HeapNode<T> node )
	{
		_parent = node ;
	}
	
	
}
