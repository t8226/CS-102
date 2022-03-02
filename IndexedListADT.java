
public interface IndexedListADT<T> extends ListADT<T>
{
	public void add( int index , T element ) throws IndexOutOfBoundsException ;
	
	public void set( int index , T element ) throws IndexOutOfBoundsException ;
	
	public void add( T element ) ;
	
	public T get( int index ) throws IndexOutOfBoundsException ;
	
	public int indexOf( T element ) ;
	
	public T remove( int index ) throws IndexOutOfBoundsException ;
}
