import java.util.Arrays;

public class IntStack {

	private final static int DEFAULT_CAPACITY = 100;
	
	private Integer[] _stack;
	private int _top;
	
	public IntStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public IntStack(int initialCapacity) //Overloaded
	{
		_stack = new Integer[initialCapacity];
		_top = 0;
	}
	
	public void push(Integer element)
	{
		if(size() == _stack.length)
		{
			expandCapacity();
		}
		_stack [_top] = element;
		_top++;
	}
	
	public Integer pop() throws EmptyCollectionException
	{
		if(isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}
		
		_top--;
		
		Integer result = _stack[_top];
		
		_stack[_top] = null;
		
		return result;
	}
	
	public Integer peek() throws EmptyCollectionException
	{
		if(isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}
		
		return _stack[_top - 1];
	}
	
	public boolean isEmpty()
	{
		return _top <= 0;
	}
	
	public int size()
	{
		return _top;
	}
	
	private void expandCapacity()
	{
		_stack = Arrays.copyOf(_stack, _stack.length * 2);		//*2 as a guess about how much room will be needed
	}
	
	public String toString()
	{
		String output = "[ ";
		
		for(int i = 0 ; i < _top ; i++)
		{
			output += _stack[ i ].toString() + " ";
		}
		
		return output + " ]";
	}
}
