import java.io.IOException;

/**
 * 	This class will generate a solution graph buy using
 * 	PathFinder class.
 *  
 * @author Junjun He && Xi Zheng
 * @version 03/15/2018
 *
 */
public class TestPathFinder {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * The below code assumes you have a file "tinyMaze.txt" in your project folder.
		 * If PathFinder.solveMaze is implemented, it will create a file "tinyMazeOutput.txt" in your project folder.
		 * 
		 * REMEMBER - You have to refresh your project to see the output file in your package explorer. 
		 * You are still required to make JUnit tests. 
		 */
		PathFinder.solveMaze("tinyMaze.txt", "tinyMazeOutput.txt");
		PathFinder.solveMaze("bigMaze.txt", "bigMazeOutput.txt");
		PathFinder.solveMaze("classic.txt", "classicOutput.txt");
		PathFinder.solveMaze("demoMaze.txt", "demoMazeOutput.txt");
		PathFinder.solveMaze("mediumMaze.txt", "mediumMazeOutput.txt");
		PathFinder.solveMaze("randomMaze.txt", "randomMazeOutPut.txt");
		PathFinder.solveMaze("straight.txt", "straightOutput.txt");
		PathFinder.solveMaze("tinyOpen.txt", "tinyOpenOutput.txt");	
		PathFinder.solveMaze("turn.txt", "turnOutput.txt");		
		PathFinder.solveMaze("unsolvable.txt", "unsolvableOutput.txt");
		PathFinder.solveMaze("endPointArounded.txt", "endPointAroundedOutput.txt");
		PathFinder.solveMaze("NoAnswer.txt", "NoAnswerOutput.txt");
		PathFinder.solveMaze("startPointArounded.txt", "startPointAroundedOutput.txt");
	}
}
