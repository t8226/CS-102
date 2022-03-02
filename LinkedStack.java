
public class LinkedStack <T> implements StackADT<T>		//Says we will follow the contract of StackADT
{
	
	private int _count;
	private LinearNode<T> _top;
	
	public LinkedStack()
	{
		_count = 0;
		_top = null;
	}
	
	public void push(T element)
	{
		LinearNode<T> temp = new LinearNode<T>(element);
		
		temp.setNext(_top);
		_top = temp;
		++_count;
	}
	
	public T pop() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		T result = _top.getElement();
		_top = _top.getNext();								//Reassigning our top
		--_count;
		
		return result;
	}
	
	public T peek() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		return _top.getElement();
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
		String output = "[ ";
		
		LinearNode<T> current = _top;
		while (current != null)
		{
			output += current.getElement() + " ";
			current = current.getNext();
		}
		
		return output + "]";
	}
}
