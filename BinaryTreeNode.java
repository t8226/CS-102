
public class BinaryTreeNode<T>
{
	protected T						_element;
	protected BinaryTreeNode<T> 	_left 	;
	protected BinaryTreeNode<T>		_right 	;
	
	
	
	public BinaryTreeNode( T obj )
	{
		_element = obj ;
	}
	
	public BinaryTreeNode( T obj , LinkedBinaryTree<T> left , LinkedBinaryTree<T> right ) 
	{
		_element = obj ;
		
		if( left != null )
			_left = left.getRootNode() ;
		
		if( right != null )
			_right = right.getRootNode() ;
	}
	
	public int numChildren()
	{
		int children = 0 ;
		
		if( _left != null )
			children += 1 + _left.numChildren() ;
		
		if( _right != null )
			children += 1 + _right.numChildren() ;
		
		return children ;
	}
	
	public T getElement()
	{
		return _element ;
	}
	
	public void setElement( T elem )
	{
		_element = elem ;
	}
	
	public BinaryTreeNode<T> getLeft()
	{
		return _left ;
	}
	
	public void setLeft( BinaryTreeNode<T> node )
	{
		_left = node ;
	}
	
	public BinaryTreeNode<T> getRight()
	{
		return _right ;
	}
	
	public void setRight( BinaryTreeNode<T> node )
	{
		_right = node ;
	}
}





















