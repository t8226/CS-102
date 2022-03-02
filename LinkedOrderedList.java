
public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>
{

	public void add(T element) throws NonComparableElementException 
	{
		if( ! ( element instanceof Comparable ) )									// instanceof returns if it implements the comparable interface
			throw new NonComparableElementException() ;
		
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = ( Comparable<T> ) element ;
		
		LinearNode<T> newNode = new LinearNode<T>( element ) ;
		
		if( isEmpty() )
		{																			// adding to an empty list
			_head = _tail = newNode ;
		}
		else if( comparableElement.compareTo( _head.getElement() ) <= 0 )			// will return less than 0 if left is smaller number than right
		{																			// will return 0 with no difference in the comparableElement and the _head
			newNode.setNext( _head ) ;												// adding to the front of the list
			_head = newNode ;
		}
		else if( comparableElement.compareTo( _tail.getElement() ) >= 0 )
		{																			// adding to the end of the list
			_tail.setNext( newNode ) ;
			_tail = newNode ;
		}
		else																		// adding to somwhere between the front and the end
		{
			LinearNode<T> current = _head ;
			LinearNode<T> previous = null ;
			
			while( comparableElement.compareTo( current.getElement () ) > 0 )
			{
				previous = current ;
				current = current.getNext() ;
			}
			
			newNode.setNext( current ) ;
			previous.setNext( newNode ) ;
			
		}
		
		++_count ; 
		++_modCount ;
	}
	
}
