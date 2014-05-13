package maze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.List;
import java.util.Stack;
/*
 * 	@author: Chris Purta
 * 
 * 	Description: This is a Maze class that holds as the underlying structure a 2-d array of
 * 	ints which ensures that there is at least one path to the exit, which is then converted 
 * 	to a 2-d array of rooms with locked doors in the correct place to ensure that 
 */

public class Maze
{
	private int[][] numMaze;
	private Cell[][] cellMaze;
	private Room[][] roomMaze;
	private int startX, startY, endX, endY;
	private static final int rows = 10;
	private static final int cols = 10;
	
	private class Cell
	{
		private int x, y;
		private boolean visited, northWall, southWall, eastWall, westWall;
		
		public Cell(int i, int j, boolean iM)
		{
			this.x = i;
			this.y = j;
			this.visited = iM;
			this.northWall = true;
			this.southWall = true;
			this.eastWall = true;
			this.westWall = true;
		}

		public void setNorthWall(boolean northWall) {
			this.northWall = northWall;
		}

		public void setSouthWall(boolean southWall) {
			this.southWall = southWall;
		}

		public void setEastWall(boolean eastWall) {
			this.eastWall = eastWall;
		}

		public void setWestWall(boolean westWall) {
			this.westWall = westWall;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean inMaze) {
			this.visited = inMaze;
		}
		
		
	}//end Cell class
	
	
	public Maze()
	{
		this.startX = 0;
		this.startY = 0;
		this.endX = rows - 1;
		this.endY = cols - 1;
		
		this.numMaze = new int[rows][cols];
		primsMazeGenerator();
	}
	
	private void primsMazeGenerator()
	{
		this.cellMaze = new Cell[rows][cols];
		Cell curCell;
		int totalCells = rows * cols;
		int visitedCells = 0;
		Stack<Cell> cellStack = new Stack<Cell>();
		Random rand = new Random();
		ArrayList<Cell> visitedNeighbors;
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				cellMaze[i][j] = new Cell(i, j, false);
		
		curCell = cellMaze[startX][startY];
		curCell.setVisited(true);
		visitedCells++;
		
		while(visitedCells < totalCells)
		{
			visitedNeighbors = getVisitedNeighbors(curCell);
			
			if(visitedNeighbors.size() > 0)
			{
				int randIndex = rand.nextInt(visitedNeighbors.size());
				Cell randCell = visitedNeighbors.get(randIndex);
				
				cellStack.push(curCell);
				removeWalls(curCell, randCell);
				curCell = randCell;
				curCell.setVisited(true);
				visitedCells++;
			}//end if
			
			else if(!cellStack.empty())
				curCell = cellStack.pop();
			
			else
			{
				curCell = cellMaze[rand.nextInt(rows)][rand.nextInt(cols)];
				
				while(curCell.isVisited())
					curCell = cellMaze[rand.nextInt(rows)][rand.nextInt(cols)];
				visitedCells++;
			}//end else
			
		}//end while
		
	}//end primsMazeGenerator

	
	private void removeWalls(Cell curCell, Cell randCell) {
		
		/*
		 * All the possible cases for removal of walls
		 * 
		 * 						[Top]
		 * 					-------------
		 * 					|			|
		 * 					|	rand	|
		 * 		[Left]		-------------	[Right]
		 *   -------------	------------- -------------
		 * 	 |			 |	|			| |			  |
		 * 	 |	 rand    |	|	 cur 	| |	  rand	  |
		 * 	 -------------	------------- -------------
		 * 		  			-------------
		 * 					|			|
		 * 					|	rand  	|
		 * 					-------------
		 * 					   [Bottom]
		 */
		
		//Rand: Top
		if(randCell.getY() == curCell.getY() && randCell.getX() == curCell.getX() - 1)
		{
			randCell.setSouthWall(false);
			curCell.setNorthWall(false);
		}//end if
		
		//Rand: Bottom
		if(randCell.getY() == curCell.getY() && randCell.getX() == curCell.getX() + 1)
		{
			randCell.setNorthWall(false);
			curCell.setSouthWall(false);
		}//end if
		
		//Rand: Right
		if(randCell.getX() == curCell.getX() && randCell.getY() == curCell.getY() + 1)
		{
			randCell.setWestWall(false);
			curCell.setEastWall(false);
		}//end if
		
		//Rand: Left
		if(randCell.getX() == curCell.getX() && randCell.getY() == curCell.getY() - 1)
		{
			randCell.setEastWall(false);
			curCell.setWestWall(false);
		}//end if
	}//end removeWalls

	private ArrayList<Cell> getVisitedNeighbors(Cell curCell) {
		
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		
		//Look at top...
		if(curCell.getX() - 1 >= 0 && cellMaze[curCell.getX() - 1][curCell.getY()].isVisited())
			neighbors.add(cellMaze[curCell.getX() - 1][curCell.getY()]);
		
		//Look at bottom...
		if(curCell.getX() + 1 < rows && cellMaze[curCell.getX() + 1][curCell.getY()].isVisited())
			neighbors.add(cellMaze[curCell.getX() + 1][curCell.getY()]);
		
		//Look at right...
		if(curCell.getY() + 1 < cols && cellMaze[curCell.getX()][curCell.getY() + 1].isVisited())
			neighbors.add(cellMaze[curCell.getX()][curCell.getY() + 1]);
		
		//Look at right...
		if(curCell.getY() - 1 >= 0 && cellMaze[curCell.getX()][curCell.getY() - 1].isVisited())
			neighbors.add(cellMaze[curCell.getX()][curCell.getY() - 1]);
		
		neighbors.trimToSize();
				
		return neighbors;
	}//end getVisitedNeighbors

	public String toString()
	{
		String str = "";
		
		for(int i = 1; i <= rows; i++)
		{
			for(int j = 1; j <= cols; j++)
				str += this.numMaze[i][j] + " ";
				
			str += "\n";
		}//end for i
		
		return str;
	}//end printMaze
	
	private boolean solutionExists(int i, int j)
	{	
		if(i <= 0 || j <= 0 || i >= this.numMaze[j].length - 1 || j >= this.numMaze.length - 1) 
			return false;
			
		if(i == this.endX && j == this.endY)
		{
			numMaze[i][j] = 7;
			return true;
		}
			
		if(!isOpen(numMaze[i][j]))
			return false;
			
		this.numMaze[i][j] = 7;
			
		if(solutionExists(i, j - 1))//North
			return true;
		if(solutionExists(i + 1, j))//East
			return true;
		if(solutionExists(i, j + 1))//South
			return true;
		if(solutionExists(i - 1, j))//West
			return true;
			
		this.numMaze[i][j] = 3;
			
		return false;
	}//end findSolution
	
	private static boolean isOpen(int numMazeVal)
	{
		return numMazeVal == 1;
	}//end isWall
	
}//end Maze class

