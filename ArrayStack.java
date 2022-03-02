import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T>{    //<T> is short for Type

    private final static int DEFAULT_CAPACITY = 100;

    private T[] _stack;
    private int _top;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public ArrayStack(int defaultCapacity) //Overloaded
    {
        _stack = (T[])(new Object[defaultCapacity]);
        _top = 0;
    }

    public void push(T element)
    {
        if(size() == _stack.length)
        {
            expandCapacity();
        }
        _stack [_top] = element;
        _top++;
    }

    public T pop() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }

        _top--;

        T result = _stack[_top];

        _stack[_top] = null;

        return result;
    }

    public T peek() throws EmptyCollectionException
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

        for(int i = _top - 1 ; i >= 0 ; i--)
        {
            output += _stack[ i ].toString() + " ";
        }

        return output + "]";
    }
}

