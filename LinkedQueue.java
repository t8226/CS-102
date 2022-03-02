
public class LinkedQueue <T> implements QueueADT<T>
{
	private int _count;
	private LinearNode<T> _head;	//Also sometimes called _front
	private LinearNode<T> _tail;	//Also sometimes called _rear
	
	public LinkedQueue()
	{
		_count = 0;
		_head = _tail = null;		//Chained assignments - gets null into both
	}
	
	public void enqueue(T element) 
	{
		LinearNode<T> node = new LinearNode<T>(element);
		
		if(isEmpty())
			_head = node;
		else
			_tail.setNext(node);
		
		_tail = node;
		++_count;
	}

	public T dequeue() throws EmptyCollectionException 
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		T result = _head.getElement();
		_head = _head.getNext();
		
		--_count;
		
		if(isEmpty())
			_tail = null;
		
		return result;
			
	}

	public T first() throws EmptyCollectionException 
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return _head.getElement();
	}
	
	public T last() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return _tail.getElement() ;
	}

	public int size() 
	{
		return _count;
	}

	public boolean isEmpty() 
	{
		return _count <= 0;		//Less than or equal to just in case of negatives
	}
	
	public String toString()
	{
		String output = "[ ";
		
		LinearNode<T> current = _head;
		while(current != null)
		{
			output += current.getElement() + " ";
			current = current.getNext();
		}
		
		return output + "]";
	}
	
}
