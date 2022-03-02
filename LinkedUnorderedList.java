public class LinkedUnorderedList <T> extends LinkedList<T> implements UnorderedListADT<T> 
{

	public void addToFront(T element) 
	{
		LinearNode<T> newNode = new LinearNode<T>( element ) ;
		
		if( isEmpty() )
		{
			_head = _tail = newNode ;
		}
		else
		{
			newNode.setNext( _head ) ;
			_head = newNode ;
		}
		
		++_count ;
		++_modCount ;
	}

	
	public void addToRear(T element) 
	{	
		LinearNode<T> newNode = new LinearNode<T>( element ) ;
		
		if( isEmpty() )
		{
			_head = _tail = newNode ;
		}
		else
		{
			_tail.setNext( newNode ) ;
			_tail = newNode ;
		}
		
		++_count ;
		++_modCount ;
	}

	
	public void addAfter(T element, T target) throws ElementNotFoundException 
	{			
		boolean found = false ;
		LinearNode<T> current = _head ;
		
		while( current != null )
		{
			if( target.equals( current.getElement() ) )
			{
				found = true ;
				break ;
			}
			else
			{
				current = current.getNext() ;
			}
		}
		
		if( ! found )
			throw new ElementNotFoundException(null) ;
		
		LinearNode<T> newNode = new LinearNode<T>( element ) ;
		
		newNode.setNext( current.getNext() ) ;
		current.setNext( newNode ) ;
		
		++_count ;
		++_modCount ;
	}

}
