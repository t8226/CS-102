public class LinkedBinarySearchTree<T extends Comparable<T>>
	extends LinkedBinaryTree<T>
	implements BinarySearchTreeADT<T>
{
	public LinkedBinarySearchTree()
	{
		super() ;
	}
	
	public LinkedBinarySearchTree( T element )
	{
		super( element ) ;
	}
	
	public void addElement(T element) 
	{
		if( isEmpty() )																// Empty
		{
			_root = new BinaryTreeNode<T>( element ) ;
		}
		
		else if( element.compareTo( _root.getElement() ) < 0 )						// Goes on the left
		{
			if( _root.getLeft() == null )
				getRootNode().setLeft( new BinaryTreeNode<T>( element ) ) ;
			else
				addElement( element , _root.getLeft() ) ;
		}
		else																		// Goes on the right
		{
			if( _root.getRight() == null )
				getRootNode().setRight( new BinaryTreeNode<T>( element ) ) ;
			else
				addElement( element , _root.getRight() ) ;
		}
	}
	
	
	private void addElement( T element , BinaryTreeNode<T> node )					// We know that the node passed in is not null because of addElement( T element)
	{
		if( element.compareTo( node.getElement() ) < 0 )							// Goes on left
		{
			if( node.getLeft() == null )											// There is no child on the left
				node.setLeft( new BinaryTreeNode<T>( element ) ) ;
			else																	// There is a child, recursive call
				addElement( element , node.getLeft() ) ;
		}
		else																		// Goes to the right
		{
			if( node.getRight() == null )
				node.setRight( new BinaryTreeNode<T>( element ) ) ;
			else
				addElement( element , node.getRight() ) ;
		}
	}
	

	public T removeElement(T targetElement) throws ElementNotFoundException 
	{
		if( isEmpty() )
			throw new ElementNotFoundException(null) ;
		
		T result = null ;
		
		if( targetElement.equals( _root.getElement() ) )							// if it is the root node
		{
			result = _root.getElement() ;
			BinaryTreeNode<T> temp = replacement( _root ) ;
			if( temp == null )
			{
				_root = null ;
			}
			else
			{
				_root.setElement( temp.getElement() ) ;
				_root.setLeft( temp.getLeft() ) ;
				_root.setRight( temp.getRight() ) ;
			}
		}
		else
		{
			BinaryTreeNode<T> parent = _root ;
			if( targetElement.compareTo( _root.getElement() ) < 0 )
				result = removeElement( targetElement , _root.getLeft() , parent ) ;
			else
				result = removeElement( targetElement , _root.getRight() , parent ) ;
		}
		
		
		return result ;
	}
	
	
	private T removeElement( T targetElement , BinaryTreeNode<T> node , BinaryTreeNode<T> parent )
	{
		if( node == null )
			throw new ElementNotFoundException(null) ;
		
		T result = null ;
		
		if( targetElement.equals( node.getElement() ) )
		{
			result = node.getElement() ;
			BinaryTreeNode<T> temp = replacement( node ) ;
			if( parent.getRight() == node )
				parent.setRight( temp ) ;
			else
				parent.setLeft( temp ) ;
		}
		else
		{
			parent = node ;
			if( targetElement.compareTo( node.getElement() ) < 0 )
				result = removeElement( targetElement , node.getLeft(), parent ) ;
			else
				result = removeElement( targetElement , node.getRight(), parent ) ;
		}
		
		return result ;
	}

	public BinaryTreeNode<T> replacement( BinaryTreeNode<T> node )
	{
		BinaryTreeNode<T> result = null ;
		
		if( ( node.getLeft() == null ) && ( node.getRight() == null ) )					// Both are null
		{
			result = null ;
		}
		else if( ( node.getLeft() != null ) && ( node.getRight() == null ) )			// Has left but no right
		{
			result = node.getLeft() ;
		}
		else if( ( node.getLeft() == null ) && ( node.getRight() != null ) )			// Has right but no left
		{
			result = node.getRight() ;
		}
		else																			// Has both children
		{
			BinaryTreeNode<T> parent = node ;
			BinaryTreeNode<T> current = node.getRight() ;
			while( current.getLeft() != null )											// Searching for the in order successor
			{
				parent = current ;
				current = current.getLeft() ;
			}
			
			current.setLeft( node.getLeft() ) ;
			if( node.getRight() != current )
			{
				parent.setLeft( current.getRight() ) ;
				current.setRight( node.getRight() ) ;
			}
			
			result = current ;
		}
		
		return result ;
	}
	public void removeAllOccurences(T targetElement) 
	{
		while( contains( targetElement ) )
			removeElement( targetElement ) ;
	}
	
}
