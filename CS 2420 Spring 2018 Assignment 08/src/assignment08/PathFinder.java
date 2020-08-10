package assignment08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class will solve a maze by using shortest path. Replace X for wall, S
 * for start point, Goal for end point, and dot means path.
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/15/2018
 *
 */
public class PathFinder {
	private static int height;
	private static int width;

	/**
	 * Constructor.
	 */
	public PathFinder() {
		height = 0;
		width = 0;
	}
	
	/**
	 * This method will takes in a file, and find the shorest path solution for
	 * your maze game. It will be using breadth first search idea to solve the problem,
	 * and create a whole new file with path solutions. 
	 * 
	 * @param inputFile name
	 * @param outputFile name
	 * @throws IOException
	 */
	public static void solveMaze(String inputFile, String outputFile) throws IOException {
		// if input from user is null, throw NPE
		if (inputFile == null || outputFile == null) {
			throw new NullPointerException();
		}

		try {
			Scanner scan = new Scanner(new File(inputFile));
			// scan the file's height and width.
			if (scan.hasNext()) {
				height = scan.nextInt();
				width = scan.nextInt();
				// let scanner points to the second line of the file, and that is 
				// where maze begins 
				if (scan.hasNextLine())
					scan.nextLine();
			}
			
			Node start = null;
			Node goal = null;
			// it's -1 because we want to ignore the heigh and width on the first line.
			int column = -1;
			
		
			Graph graph = new Graph(height, width);

			while (scan.hasNextLine()) {
				// convert every characters into an array.
				char[] characters = scan.nextLine().toCharArray();
				column++;
				int row = 0;
				
				
				 // Store every character into graph with different column and row.
				for (char character : characters) {
					graph.twoDArray[column][row] = new Node(character + "");
					if (character == 'S' ) {
						start = graph.twoDArray[column][row];
					} else if (character == 'G') {
						goal = graph.twoDArray[column][row];
					}
					row++;
				}
			}

			// if start or goal is null, then there is return NPE.
			if (start == null || goal == null) {
				scan.close();
				throw new NullPointerException();
			}
			
			// go through the graph, and find every neighbors for every element in the graph.
			for (int hei = 0; hei < height; hei++) {
				for (int wid = 0; wid < width; wid++) {
					graph.addNeighbors(graph.twoDArray[hei][wid], hei, wid);
				}
			}
			
			// find the shortest path now.
			graph.bfs(start, goal);
			
			// do dots on the path.
			graph.generateDot(start, goal);


			// write the datas from 2d array into a file.
			try (PrintWriter output = new PrintWriter(new FileWriter(outputFile))) {
				// first line of the output file will be height and width.
				output.println(height + " " + width);
				
				for (int j = 0; j < height; j++) {
					for (int k = 0; k < width; k++) {
						output.write(graph.twoDArray[j][k].element);
					}
					output.println(); // start a new line.
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}
}