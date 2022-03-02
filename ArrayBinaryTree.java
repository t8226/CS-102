import java.util.* ;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    private static final int DEFAULT_CAPACITY = 50 ;
	
    protected int count ;
    protected T[] tree  ;

    @SuppressWarnings("unchecked")
	public ArrayBinaryTree() 
    {
        count = 0 ;
        tree = (T[]) new Object[ DEFAULT_CAPACITY ] ;
    }
    
    @SuppressWarnings("unchecked")
	public ArrayBinaryTree( T element ) 
    {
        count = 1 ;
        tree = (T[]) new Object[ DEFAULT_CAPACITY ] ;
        tree[ 0 ] = element ;
    }

    protected void expandCapacity()
    {
    	tree = Arrays.copyOf( tree, tree.length * 2 ) ;  
	}

	@Override
	public Iterator<T> iterator()
	{
		return iteratorInOrder() ;
	}

	@Override
	public T getRootElement()
	{
		if( isEmpty() )
			throw new EmptyCollectionException( "ArrayBinaryTree" ) ;

		return tree[ 0 ] ;
	}

	@Override
	public boolean isEmpty()
	{
		return count == 0 ;
	}

	@Override
	public int size()
	{
		return count ;
	}

	@Override
	public boolean contains( T targetElement )
	{
		for( int i = 0 ; i < count ; ++i )
		     if( targetElement.equals( tree[ i ] ) )
		    	 return true ;
		
		return false ;
	}

	@Override
	public T find( T targetElement )
	{
		for( int i = 0 ; i < count ; ++i )
		     if( targetElement.equals( tree[ i ] ) )
		        return tree[ i ] ;

		throw new ElementNotFoundException("binary tree");
	}

	@Override
	public Iterator<T> iteratorInOrder()
	{
		ArrayList<T> collector = new ArrayList<T>() ;
        inOrder( 0, collector ) ;
        return collector.iterator() ;
	}

	@Override
	public Iterator<T> iteratorPreOrder()
	{
		ArrayList<T> collector = new ArrayList<T>() ;
        preOrder( 0, collector ) ;
        return collector.iterator() ;
	}

	@Override
	public Iterator<T> iteratorPostOrder()
	{
		ArrayList<T> collector = new ArrayList<T>() ;
        postOrder( 0, collector ) ;
        return collector.iterator() ;
	}

    protected void inOrder( int node, ArrayList<T> collector ) 
    {
        if( node < tree.length )
        {
            if( tree[ node ] != null )
            {
            	inOrder( node * 2 + 1, collector ) ;
            	collector.add( tree[ node ] ) ;
            	inOrder( ( node + 1 ) * 2, collector ) ;
            }
        }
    }

    protected void preOrder( int node, ArrayList<T> collector ) 
    {
        if( node < tree.length )
        {
            if( tree[ node ] != null )
            {
            	collector.add( tree[ node ] ) ;
            	preOrder( node * 2 + 1, collector ) ;
            	preOrder( ( node + 1 ) * 2, collector ) ;
            }
        }
    }

    protected void postOrder( int node, ArrayList<T> collector ) 
    {
        if( node < tree.length )
        {
            if( tree[ node ] != null )
            {
            	postOrder( node * 2 + 1, collector ) ;
            	postOrder( ( node + 1 ) * 2, collector ) ;
            	collector.add( tree[ node ] ) ;
            }
        }
    }
}