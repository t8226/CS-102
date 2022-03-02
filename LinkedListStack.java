public class LinkedListStack<T> implements StackADT<T>
{
	private LinkedUnorderedList<T> _stack ;

	public LinkedListStack()
	{
		_stack = new LinkedUnorderedList<T>() ;
	}
	

	public void push(T element) 
	{
		_stack.addToRear( element ) ;
	}


	public T pop() throws EmptyCollectionException 
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		return _stack.removeLast() ;
	}


	public T peek() throws EmptyCollectionException 
	{
		if( isEmpty() )
			throw new EmptyCollectionException() ;
		
		return _stack.last() ;
	}


	public boolean isEmpty() 
	{
		return _stack.isEmpty() ;
	}


	public int size() 
	{
		return _stack.size() ;
	}
	
	public String toString()
	{
		return _stack.toString() ;
	}
}
