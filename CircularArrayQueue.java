
public class CircularArrayQueue <T> implements QueueADT<T>
{
	
	private final static int DEFAULT_CAPACITY = 100;
	
	private int _front;		//Underscore means it is a member variable and is private.
	private int _rear;
	private int _count;
	private T[] _queue;
	
	public CircularArrayQueue()
	{
		this( DEFAULT_CAPACITY );
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue( int initialCapacity)
	{
		_front = _rear = _count = 0;
		_queue = (T[]) new Object[ initialCapacity ];
	}
	
	public void enqueue(T element) 
	{
		if( size() == _queue.length ) //Queue is full
			exapndCapacity();
		
		_queue[ _rear ] = element;
		_rear = (_rear + 1) % _queue.length;
		
		++_count;
	}



	public T dequeue() throws EmptyCollectionException 
	{
		if ( isEmpty() )
			throw new EmptyCollectionException() ;
		
		T result = _queue[ _front ] ;
		_queue[ _front ] = null ;		//Reassigning our empty space to null, could replace but helps w/ debugging
		_front = (_front + 1) % _queue.length ;
		
		--_count ;
		
		return result;
	}

	public T first() throws EmptyCollectionException 
	{
		if ( isEmpty() )
			throw new EmptyCollectionException() ;
		
		return _queue[ _front ] ;
	}

	public int size() 
	{
		return _count;
	}

	public boolean isEmpty() 
	{
		return _count <= 0;
	}
	
	public String toString()
	{
		String output = "[ " ;
		
		for( int i = 0, index = _front ; i < _count ; i++ )	//Comma lets you initialize multiple variables
		{
			output += _queue[ index ] + " " ;
			index = (index + 1 ) % _queue.length;
		}
		
		return output + "]" ;
	}
	
	@SuppressWarnings("unchecked")
	private void exapndCapacity() 
	{
		T[] larger = (T[]) new Object [ _queue.length * 2];
		
		for( int i = 0 ; i < _count ; ++i)
		{
			larger[ i ] = _queue [ _front ] ;
			_front = (_front + 1) % _queue.length;
			
		}
		
		_front = 0 ;
		_rear = _count ;
		_queue = larger ;
	}

}
