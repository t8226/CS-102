import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> , Iterable<T>
{
	protected BinaryTreeNode<T> _root = null ;
	
	public LinkedBinaryTree() {}
	
	public LinkedBinaryTree( T element ) 
	{
		_root = new BinaryTreeNode<T>( element ) ;
	}
	
	public LinkedBinaryTree( T element , LinkedBinaryTree<T> left , LinkedBinaryTree<T> right ) 
	{
		_root = new BinaryTreeNode<T>( element ) ;
		_root.setLeft( left.getRootNode() ) ;
		_root.setRight( right.getRootNode() ) ; 
	}
	
	public T getRootElement() 
	{
		return _root.getElement() ;
	}
	
	public BinaryTreeNode<T> getRootNode()
	{
		return _root ;
	}

	public boolean contains(T targetElement) 
	{
		return findNode( targetElement , _root ) != null ;
	}

	public T find(T targetElement) throws ElementNotFoundException 
	{
		BinaryTreeNode<T> found = findNode( targetElement , _root ) ;
		
		if( found == null )
			throw new ElementNotFoundException(null) ;
		
		return found.getElement() ;
	}
	
	private BinaryTreeNode<T> findNode( T targetElement , BinaryTreeNode<T> next )
	{
		if( next == null )														// If nothing is found
			return null ;
		
		if( next.getElement().equals( targetElement ) )							// If next element is target
			return next ;
		
		BinaryTreeNode<T> found = findNode( targetElement , next.getLeft() ) ;
		if( found == null )
			found = findNode( targetElement , next.getRight() ) ;
		
		return found ;
	}

	public boolean isEmpty() 
	{
		return _root == null ;
	}

	public int size() 
	{
		return size( _root ) ;
	}
	
	protected int size( BinaryTreeNode<T> node )
	{
		if( node == null )
			return 0 ;
		
		int retVal = 1 ;
		
		retVal += size( node.getLeft() ) ;
		retVal += size( node.getRight() ) ;
		
		return retVal ;
	}
	
	public int getHeight()
	{
		return getHeight( _root ) - 1 ;											// - 1 accounts for the number of edges, tree height is a 0 index
	}
	
	protected int getHeight( BinaryTreeNode<T> node )
	{
		if( node == null )
			return 0 ;
		
		int leftHeight = 1 + getHeight( node.getLeft() ) ;
		int rightHeight = 1 + getHeight( node.getRight() ) ;
		
		return Math.max( leftHeight, rightHeight ) ;							// Automatically returns the bigger
	}
	
	public Iterator<T> iteratorInOrder() 
	{
		ArrayList<T> collector = new ArrayList<T>() ;
		inOrder( _root , collector ) ;
		return collector.iterator() ;
	}

	public Iterator<T> iteratorPreOrder() 
	{
		ArrayList<T> collector = new ArrayList<T>() ;
		preOrder( _root , collector ) ;
		return collector.iterator() ;
	}

	public Iterator<T> iteratorPostOrder() 
	{
		ArrayList<T> collector = new ArrayList<T>() ;
		postOrder( _root , collector ) ;
		return collector.iterator() ;
	}
	
	protected void inOrder( BinaryTreeNode<T> node , ArrayList<T> collector )
	{
		if( node != null )
		{
			inOrder( node.getLeft() , collector ) ;
			collector.add( node.getElement() ) ;
			inOrder( node.getRight() , collector ) ;
		}
	}
	
	protected void preOrder( BinaryTreeNode<T> node , ArrayList<T> collector )
	{
		if( node != null )
		{
			collector.add( node.getElement() ) ;
			preOrder( node.getLeft() , collector ) ;
			preOrder( node.getRight() , collector ) ;
		}
	}
	
	protected void postOrder( BinaryTreeNode<T> node , ArrayList<T> collector )
	{
		if( node != null )
		{
			postOrder( node.getLeft() , collector ) ;
			postOrder( node.getRight() , collector) ;
			collector.add( node.getElement() ) ;
		}
	}
	
	public Iterator<T> iterator() 
	{
		return iteratorInOrder() ;
	}

	
    public String toString() 
    {
		ArrayList<BinaryTreeNode<T>> nodes = new ArrayList<>() ;
		ArrayList<Integer> levelList = new ArrayList<>() ;
        BinaryTreeNode<T> current ;
        String result = "" ;
        int printDepth = this.getHeight() ;
        int possibleNodes = (int) Math.pow( 2 , printDepth + 1 ) ;
        int countNodes = 0 ;
        Integer currentLevel = 0 ;
        Integer previousLevel = -1 ;
        
        nodes.add( _root ) ;
        levelList.add( currentLevel ) ;

        while( countNodes < possibleNodes ) 
        {
            countNodes = countNodes + 1 ;
            current = nodes.remove( 0 ) ;
            currentLevel = levelList.remove( 0 ) ;
            
            if( currentLevel > previousLevel )
            {
                result = result + "\n\n" ;
                previousLevel = currentLevel ;
                double stop = Math.pow( 2, ( printDepth - currentLevel ) ) - 1 ;
                for( int i = 0 ; i < stop ; ++i )
                    result = result + " " ;
            }
            else
            {
            	double stop = Math.pow( 2, ( printDepth - currentLevel + 1 ) ) - 1 ;
                for( int i = 0 ; i < stop ; ++i )
                    result = result + " " ;
            }
            
            if( current != null )
            {
                result = result + ( current.getElement() ).toString() ;
                nodes.add( current.getLeft() ) ;
                levelList.add( currentLevel + 1 ) ;
                nodes.add( current.getRight() ) ;
                levelList.add( currentLevel + 1 ) ;
            }
            else 
            {
                nodes.add( null ) ;
                levelList.add( currentLevel + 1 ) ;
                nodes.add( null ) ;
                levelList.add( currentLevel + 1 ) ;
                result = result + " " ;
            }
        }
        
        while( result.length() > 0 && result.charAt( 0 ) == '\n' )
        	result = result.substring( 1 ) ;
        
        while( result.length() > 0 && Character.isWhitespace( result.charAt( result.length() - 1 ) ) )
        	result = result.substring( 0, result.length() - 1 ) ;

        return result ;
    }
}
