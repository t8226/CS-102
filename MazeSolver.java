import java.util.* ;

/*
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the 
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent loacations in the maze that have been TRIED
 * and that are part of the solution PATH.
 */

public class MazeSolver 
{
	private Maze maze ;
	
	public MazeSolver ( Maze maze )
	{
		this.maze = maze;
	}
	
	public boolean traverse ( int row , int column )
	{
		boolean done = false ;
		
		if( maze.validPosition( row , column ) )
		{
			maze.tryPosition( row ,  column ) ;
			
			if( row == maze.getRows() - 1 && column == maze.getColumns() - 1 )
				done = true ; 																// The maze is solved
			
			else
			{
				done = traverse( row + 1 , column ) ;
				if( !done )
					done = traverse( row , column + 1 ) ;
				if( !done )
					done = traverse( row - 1 , column ) ;
				if( !done )
					done = traverse( row , column - 1 ) ;
			}
			
			if( done ) 
				maze.markPath( row ,  column ) ;
		}
		
		return done ;
	}
}
