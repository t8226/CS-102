

public class Graph<T>
{
	protected final int DEFAULT_CAPACITY = 15 ;
	protected int numVertices ;
	protected Double[][] adjMatrix ;
	protected T[] vertices ;
	
	@SuppressWarnings("unchecked")
	public Graph()
	{
		numVertices = 0;
	  	adjMatrix = new Double[ DEFAULT_CAPACITY ][ DEFAULT_CAPACITY ] ;
	  	vertices = (T[])( new Object[ DEFAULT_CAPACITY ] ) ;
	}
	
	public Double[] getAdjacencyMatrixRow( int rowIndex )
	{
		return adjMatrix[ rowIndex ] ;
	}
	
	public Double getAdjacencyMatrixValue( int rowIndex, int columnIndex )
	{
		return adjMatrix[ rowIndex ][ columnIndex ] ;
	}
	
	public T getVertexByIndex( int index )
	{
		return vertices[ index ] ;
	}
	
	public int size()
	{
		return numVertices ;
	}
	
	public boolean isEmpty()
	{
		return numVertices == 0 ;
	}
	
	protected int getIndex( T vertex )
	{
		for( int i = 0 ; i < numVertices ; ++i )
			if( vertices[ i ].equals( vertex ) )
				return i ;
		return -1 ;
	}
	
	protected boolean indexIsValid( int index )
	{
		return index < numVertices && index >= 0 ;
	}
	
	public void addEdge( T vertex1, T vertex2, Double cost )
	{
		addEdge( getIndex( vertex1 ), getIndex( vertex2 ), cost ) ;
	}
	
	protected void addEdge( int index1, int index2, Double cost )
	{
		if( indexIsValid( index1 ) && indexIsValid( index2 ) )
		{
			adjMatrix[ index1 ][ index2 ] = cost ;
			adjMatrix[ index2 ][ index1 ] = cost ;
		}
	}
	
	public void removeEdge( T vertex1, T vertex2 )
	{
		removeEdge( getIndex( vertex1 ), getIndex( vertex2 ) ) ;
	}
	
	protected void removeEdge( int index1, int index2 )
	{
		if( indexIsValid( index1 ) && indexIsValid( index2 ) )
		{
			adjMatrix[ index1 ][ index2 ] = Double.MAX_VALUE ;
			adjMatrix[ index2 ][ index1 ] = Double.MAX_VALUE ;
		}
	}
	
	public void addVertex( T vertex )
	{
		if( numVertices == vertices.length )
			expandCapacity() ;
	
		vertices[ numVertices ] = vertex ;
		for( int i = 0 ; i <= numVertices ; ++i )
		{
			adjMatrix[ numVertices ][ i ] = Double.MAX_VALUE ;
			adjMatrix[ i ][ numVertices ] = Double.MAX_VALUE ;
		}      
		
		++numVertices ;
	}
	
	public void removeVertex( T vertex )
	{
		for( int i = 0 ; i < numVertices ; ++i )
		{
			if( vertex.equals( vertices[ i ] ) )
			{
				removeVertex( i ) ;
				return ;
			}
		}
	}
	
	protected void removeVertex( int index )
	{
		if( indexIsValid( index ) )
		{
			--numVertices ;
	
			for( int i = index ; i < numVertices ; ++i )
				vertices[ i ] = vertices[ i + 1 ] ;
	
			for( int i = index ; i < numVertices ; ++i )
				for( int j = 0 ; j < numVertices ; ++j )
					adjMatrix[ i ][ j ] = adjMatrix[ i + 1 ][ j ] ;
	
			for( int i = index ; i < numVertices ; ++i )
				for( int j = 0 ; j < numVertices ; ++j )
					adjMatrix[ j ][ i ] = adjMatrix[ j ][ i + 1 ] ;
		}
	}

	protected void expandCapacity()
	{
		@SuppressWarnings("unchecked")
		T[] largerVertices = (T[])( new Object[ vertices.length * 2 ] ) ;
		Double[][] largerAdjMatrix =
			new Double[ vertices.length * 2 ][ vertices.length * 2 ] ;
	
		for( int i = 0 ; i < numVertices ; ++i )
		{
			for( int j = 0 ; j < numVertices ; ++j )
			{
				largerAdjMatrix[ i ][ j ] = adjMatrix[ i ][ j ] ;
			}
			largerVertices[ i ] = vertices[ i ] ;
		}
	
		vertices = largerVertices ;
		adjMatrix = largerAdjMatrix ;
	}
	
	public String toString()
	{
		if( numVertices == 0 )
			return "Graph is empty" ;
	
		String result = new String() ;
	
		result += "Vertex Values" ;
		result += "\n-------------\n" ;
		result += "index\tvalue\n\n" ;
	
		for( int i = 0 ; i < numVertices ; ++i )
		{
			result += "" + i + "\t" ;
			result += vertices[ i ].toString() + "\n" ;
		}

		result += "\n\nAdjacency Matrix\n" ;
		result += "----------------\n" ;
		result += "index\t" ;
	
		for( int i = 0 ; i < numVertices ; ++i ) 
		{
			result += String.format( "%5d ", i ) ;
		}
		result += "\n\n" ;
	
		for( int i = 0 ; i < numVertices ; ++i )
		{
			result += "" + i + "\t" ;
	  
			for( int j = 0 ; j < numVertices ; ++j )
			{
				if( adjMatrix[ i ][ j ] != null && adjMatrix[ i ][ j ] < Double.MAX_VALUE )
					result += String.format( "%5.1f ", adjMatrix[ i ][ j ] ) ;
				else
					result += "      " ;
			}
			result += "\n" ;
		}
	
		result += "\n" ;
		return result ;
	}
}
