public class LinkedHeap<T extends Comparable<T>> 
	extends LinkedBinaryTree<T>
	implements HeapADT<T>
{
	private HeapNode<T> _lastNode ;
	
	public LinkedHeap()
	{
		super() ;
	}
	
	public T findMin() 
	{
		return _root.getElement() ;
	}

	public void addElement(T obj) 
	{
		HeapNode<T> node = new HeapNode<T>( obj ) ;
		
		if( _root == null )
		{
			_root = node ;
		}
		else
		{
			HeapNode<T> nextParent = getNextParentAdd() ;
			if( nextParent.getLeft() == null ) 
				nextParent.setLeft( node ) ;
			else
				nextParent.setRight( node) ;
			
			node.setParent( nextParent ) ;
		}
		
		if( size() > 1 )
			heapifyAdd() ;
	}
	
	private HeapNode<T> getNextParentAdd()
	{
		HeapNode<T> result = _lastNode ;
		
		while( ( result != _root ) && ( result.getParent().getLeft() != result ) )
			result = result.getParent() ;
		
		if( result != _root )
		{
			if( result.getParent().getRight() == null )
			{
				result = result.getParent() ;
			}
			else
			{
				result = (HeapNode<T>) result.getParent().getRight() ;
				while( result.getLeft() != null )
					result = ( HeapNode<T>) result.getLeft() ;
			}
		}
		else {
			while( result.getLeft() != null )
				result = (HeapNode<T>) result.getLeft() ;
		}
		
		return result ;
	}
	
	private void heapifyAdd()
	{
		HeapNode<T> next = _lastNode ;
		T temp = next.getElement() ;
		
		while( ( next != _root ) && ( temp.compareTo( next.getParent().getElement() ) < 0 ) ) 
		{
			next.setElement( next.getParent().getElement() ) ;
			next = next.getParent() ;
		}
		
		next.setElement( temp ) ; 
	}

	public T removeMin() throws EmptyCollectionException 
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		T minElement = _root.getElement() ;
		
		if( size() == 1 )
		{
			_root = _lastNode = null ;
		}
		else
		{
			HeapNode<T> nextLast = getNewLastNode() ;
			if( _lastNode.getParent().getLeft() == _lastNode )
				_lastNode.getParent().setLeft( null ) ;
			else
				_lastNode.getParent().setRight( null ) ;
			
			_root.setElement( _lastNode.getElement() ) ;
			_lastNode = nextLast ;
			heapifyRemove() ;
		}
		
		return minElement ;
	}
	
	private HeapNode<T> getNewLastNode()
	{
		HeapNode<T> result = _lastNode ;
		
		while( ( result != _root ) && ( result.getParent().getLeft() == result ) )
			result = result.getParent() ;
		
		if( result != _root )
			result = (HeapNode<T>) result.getParent().getLeft() ;
		
		while( result.getRight() != null )
			result = (HeapNode<T>) result.getRight() ;
		
		return result ;
	}
	
	private void heapifyRemove()
	{
		HeapNode<T> node = (HeapNode<T>) _root ;
		HeapNode<T> left = (HeapNode<T>) node.getLeft() ;
		HeapNode<T> right = (HeapNode<T>) node.getRight() ;
		HeapNode<T> next ;
		
		if( ( left == null ) && ( right == null ) )
			next = null ;
		else if( right == null )
			next = left ;
		else if ( left.getElement().compareTo( right.getElement() ) < 0 )
			next = left ;
		else
			next = right ;
		
		T temp = node.getElement() ;
		
		while( ( next != null ) && ( next.getElement().compareTo( temp ) < 0 ) )
		{
			node.setElement( next.getElement() ) ;
			node = next ;
			left = (HeapNode<T>) node.getLeft() ;
			right = (HeapNode<T>) node.getRight() ;
			
			if( ( left == null ) && ( right == null ) )
				next = null ;
			else if( right == null )
				next = left ;
			else if ( left.getElement().compareTo( right.getElement() ) < 0 )
				next = left ;
			else
				next = right ;
		}
		
		node.setElement( temp ) ;
	}
	
}







