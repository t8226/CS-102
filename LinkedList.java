import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListADT<T>, Iterable<T>
{
	// Abstract because it is not useful, and is only good for inheriting
	
	// No private because it is inherited from and they need to be seen by the classes below it
	
	protected LinearNode<T> _head ;
	protected LinearNode<T> _tail ;
	protected int _count ;
	protected int _modCount ;
	
	public LinkedList()
	{
		_head = _tail = null ;
		_count = _modCount = 0 ;
	}
	
	public T removeFirst() throws EmptyCollectionException 	   // throws indicates that method can throw not that it is
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;             // throw is actually throwing the exception itself
		
		LinearNode<T> result = _head ;
		_head = _head.getNext() ;                              // head is no longer head, it incriments one
		if( _head == null )
			_tail = null ;
		
		--_count ;
		++_modCount ;
		
		return result.getElement() ;
	}
	
	
	public T removeLast() throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		LinearNode<T> previous = null ;
		LinearNode<T> current = _head ;
		
		while( current.getNext() != null )
		{
			previous = current ;
			current = current.getNext() ;
		}
		
		LinearNode<T> result = _tail ;
		_tail = previous ;
		
		if( _tail == null )
			_head = null ;
		else
			_tail.setNext( null ) ;                               // Setting next to null
		
		--_count ; 
		++_modCount ;
		
		return result.getElement() ;
	}
	
	public T remove( T targetElement ) throws EmptyCollectionException , ElementNotFoundException
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		boolean found = false ;
		LinearNode<T> previous = null ;
		LinearNode<T> current = _head ;
		
		while( current != null )
		{
			if( targetElement.equals( current.getElement() ) )
			{
				found = true ;
				break ;
			}
			else
			{
				previous = current ;
				current = current.getNext() ;
			}
		}
		
		if( ! found )
			throw new ElementNotFoundException(null) ;
		
		if( size() == 1 )                            // Case 1: Only one item in the list
		{
			_head = _tail = null ;
		}
		else if( current.equals( _head ) )           // Case 2: Removing the first item in the list
		{
			_head = current.getNext() ;
		}
		else if( current.equals( _tail ) )           // Case 3: Removing the last item in the list
		{
			_tail = previous ;
			_tail.setNext( null ) ; 
		}
		else                                         // Case 4: Removing something in the middle
		{
			previous.setNext( current.getNext() ) ;
		}
		
		--_count ;
		++_modCount ;
		
		return current.getElement() ;
	}
	
	public T first() throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		return _head.getElement() ;
	}
	
	public T last() throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		return _tail.getElement() ;
	}
	
	public boolean contains( T targetElement ) throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		LinearNode<T> current = _head ;
		
		while( current != null )
		{
			if( targetElement.equals( current.getElement() ) )
				return true ;
			
			current = current.getNext();
		}
		
		return false ;
	}
	
	public int size()
	{
		return _count ;
	}
	
	public boolean isEmpty()
	{
		return _count <= 0 ;
	}
	
	public String toString()
	{
		String output = "[ " ;
		
		LinearNode<T> current = _head ;
		while( current != null )
		{
			output += current.getElement() + " " ;
			current = current.getNext() ;
		}
		
		return output + "]" ;
	}

	public Iterator<T> iterator() 
	{
		return new LinkedListIterator( this ) ;
	}
	
	private class LinkedListIterator implements Iterator<T>
	{
		private LinkedList<T> _ll ;
		private LinearNode<T> _current ;
		private int _iteratorModCount ;
		
		public LinkedListIterator( LinkedList<T> ll )
		{
			_ll = ll ;
			_current = _ll._head ;
			_iteratorModCount = _ll._modCount ;
		}
		
		public boolean hasNext() 
		{
			if( _iteratorModCount != _ll._modCount )
				throw new ConcurrentModificationException() ;
			
			return _current != null ;
		}

		public T next() 
		{
			if( ! hasNext() )
				throw new NoSuchElementException() ;
			
			T result = _current.getElement() ;
			_current = _current.getNext();
			return result ;
		}
		
	}
}
