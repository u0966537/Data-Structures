import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 	This class is used to test PathFinder class.
 * 	The idea of these tests are comparing the number of 
 * 	walls and dots(solution file and output file).
 *  
 * @author Junjun He && Xi Zheng
 * @version 03/15/2018
 *
 */
public class PathFinderTest {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Will scan through my output file's number of dots and walls and 
	 * compare with solution's number of dots and walls.
	 */
	@Test
	public void TestBigMaze() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("bigMazeOutput.txt");
		String solution = this.scan_X_And_Dots("bigMazeSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestClassic() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("classicOutput.txt");
		String solution = this.scan_X_And_Dots("classicSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestDemoMaze() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("demoMazeOutput.txt");
		String solution = this.scan_X_And_Dots("demoMazeSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestMediumMaze() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("mediumMazeOutput.txt");
		String solution = this.scan_X_And_Dots("mediumMazeSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestRandomMaze() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("randomMazeOutput.txt");
		String solution = this.scan_X_And_Dots("randomMazeSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestStraight() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("straightOutput.txt");
		String solution = this.scan_X_And_Dots("straightSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestTinyMaze() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("tinyMazeOutput.txt");
		String solution = this.scan_X_And_Dots("tinyMazeSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestTinyOpen() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("tinyOpenOutput.txt");
		String solution = this.scan_X_And_Dots("tinyOpenSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestTurn() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("turnOutput.txt");
		String solution = this.scan_X_And_Dots("turnSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestUnsolvable() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("unsolvableOutput.txt");
		String solution = this.scan_X_And_Dots("unsolvableSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestendPointArounded() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("endPointAroundedOutput.txt");
		String solution = this.scan_X_And_Dots("endPointAroundedSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TestNoAnswer() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("NoAnswerOutput.txt");
		String solution = this.scan_X_And_Dots("NoAnswerSol.txt");
		assertEquals(output, solution);
	}
	
	@Test
	public void TeststartPointArounded() throws FileNotFoundException {
		String output = this.scan_X_And_Dots("startPointAroundedOutput.txt");
		String solution = this.scan_X_And_Dots("startPointAroundedSol.txt");
		assertEquals(output, solution);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/*
	 * Compare two file's wall, if they have all the same at the same column and row,
	 * then return true;
	 */
	@Test
	public void bigNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("bigMazeSol.txt", "bigMazeOutput.txt"));
	}
	
	@Test
	public void classicNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("classicSol.txt", "classicOutput.txt"));
	}
	
	@Test
	public void demoNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("demoMazeSol.txt", "demoMazeOutput.txt"));
	}
	
	@Test
	public void mediumNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("mediumMazeSol.txt", "mediumMazeOutput.txt"));
	}
	
	@Test
	public void randomNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("randomMazeSol.txt", "randomMazeOutput.txt"));
	}
	
	@Test
	public void straightNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("straightSol.txt", "straightOutput.txt"));
	}
	
	@Test
	public void tinyNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("tinyMazeSol.txt", "tinyMazeOutput.txt"));
	}
	
	@Test
	public void turnNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("turnSol.txt", "turnOutput.txt"));
	}
	
	@Test
	public void unsolvableNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("unsolvableSol.txt", "unsolvableOutput.txt"));
	}
	
	@Test
	public void endPointAroundedNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("endPointAroundedSol.txt","endPointAroundedOutput.txt"));
	}
	
	@Test
	public void NoAnswerNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("NoAnswerSol.txt","NoAnswerOutput.txt"));
	}
	
	@Test
	public void startPointAroundedNumberOfWalls() throws FileNotFoundException {
		assertTrue(this.scanNumberOfWalls("startPointAroundedSol.txt","startPointAroundedOutput.txt"));
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	/**
	 * This is a private method that will help us to count the number of 
	 * walls and dots in the graph. (For Testing purpose)
	 * @param fileName
	 * @return A string of number of walls and dots.
	 * @throws FileNotFoundException
	 */
	private String scan_X_And_Dots(String fileName) throws FileNotFoundException {
		int XCount = 0;
		int DotCount = 0;
		Scanner scan = new Scanner (new File(fileName));
		
		while(scan.hasNextLine()) {
			
			char[] characters = scan.nextLine().toCharArray();
			
			for(char character : characters) {
			if(character =='.') {
				DotCount++;
			}
			else if(character =='X') {
				XCount++;
			}
		}
	}
		scan.close();
		return XCount + " " + DotCount;
}
	/**
	 * This is a private method that use for testing only.
	 * It will takes in two files, and scan two files each time, 
	 * Once either one of the file found a wall("X"), then compare to each other.
	 * @param fileName1
	 * @param fileName2
	 * @return true if two file's wall are in the same position.
	 * @throws FileNotFoundException
	 */
	private boolean scanNumberOfWalls(String fileName1, String fileName2) throws FileNotFoundException {
		Scanner scan1 = new Scanner(new File(fileName1));
		Scanner scan2 = new Scanner(new File(fileName2));
		
		scan1.nextLine(); // because first line is unnecessary.
		scan2.nextLine();
		
		while(scan1.hasNextLine() && scan2.hasNextLine()) {
			char[] line1 = scan1.nextLine().toCharArray();
			char[] line2 = scan2.nextLine().toCharArray();
			
			for(int index = 0; index < line1.length ; index++) {
				/* solution could be different.
				 * However, they should have Wall, start, and goal points at the 
				 * same position no matter wall.  
				 */
				//when both of them not equal to dot, then they should have the same element.
				if(line1[index] != '.' && line2[index] !='.') {
					if(line1[index]!= line2[index]) {
						scan1.close();
						scan2.close();
						return false;
					}
				}
			}
		}
		scan1.close();
		scan2.close();
		return true;
	}
}
