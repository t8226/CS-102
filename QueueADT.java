
public interface QueueADT <T>{
	
	public void enqueue(T element);
	
	public T dequeue() throws EmptyCollectionException;
	
	public T first() throws EmptyCollectionException;
	
	public int size();
	
	public boolean isEmpty();
}
