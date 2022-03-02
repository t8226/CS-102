
public class LinkedIndexedList<T> extends LinkedList<T> implements IndexedListADT<T> 
{

	public void add(int index, T element) throws IndexOutOfBoundsException 
	{
		if( index >= _count || index == 0 )
			throw new IndexOutOfBoundsException() ;
		
		LinearNode<T> current = _head ;
		LinearNode<T> previous = null ;
		
		for( int i = 0 ; i < index ; ++i )
		{
			previous = current ;
			current = current.getNext() ;
		}
		
		LinearNode<T> newNode = new LinearNode<T>( element ) ;
		
		newNode.setNext( current ) ;

		if( previous == null )
			_head = newNode ;
		
		else
			previous.setNext( newNode ) ;
		
		if( current == null )
			_tail = newNode ;
		
		
		++_count ;
		++_modCount ;
	}

	public void set(int index, T element) throws IndexOutOfBoundsException 
	{
		if( index >= _count || index == 0 )
			throw new IndexOutOfBoundsException() ;
		
		LinearNode<T> current = _head ;
		for( int i = 0 ; i < index ; ++i )
			current = current.getNext() ;
		
		current.setElement( element ) ; 
	}

	public void add(T element) 
	{
			LinearNode<T> newNode = new LinearNode<T>( element ) ;
			
			if( _count == 0 )
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

	public T get(int index) throws IndexOutOfBoundsException 
	{
		if( index >= _count || index == 0 )
			throw new IndexOutOfBoundsException() ;
		
		LinearNode<T> current = _head ;
		
		for( int i = 0 ; i < index ; ++i )
			current = current.getNext() ;
		
		return current.getElement() ;
	}

	public int indexOf(T element) 
	{
		LinearNode<T> current = _head ;
		
		for( int i = 0 ; i < _count ; ++i )
		{
			if( current == null && element == null )
				return i ;
			if( current.getElement().equals( element ) )
				return i ;

			current = current.getNext() ;
		}
		
		return -1 ;
	}

	public T remove(int index) throws IndexOutOfBoundsException 
	{
		if( index >= _count || index == 0 )
			throw new IndexOutOfBoundsException() ;
		
		LinearNode<T> current = _head ;
		LinearNode<T> previous = null ;
		
		for( int i = 0 ; i < index ; ++i )
		{
			previous = current ;
			current = current.getNext() ;
		}
		
		if( previous == null )
			_head = current.getNext() ;
		
		else
			previous.setNext( current.getNext() ) ;
		
		if( current.getNext() == null )
			_tail = previous ;
			
		--_count ;
		++_modCount ;
		
		return current.getElement() ;
	}
	

}
