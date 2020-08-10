package assignment08;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This class will store the data from the graph by using 2d array, 
 * and find the paths by using breadth first search.
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/15/2018
 *
 */
public class Graph {
	
	// 2d array to store as a graph
	Node[][] twoDArray; 
	int height;
	int width;
	
	/**
	 * Constructor, and set the 2d array as the maze's height and weight.
	 * @param height
	 * @param width
	 */
	public Graph(int height, int width) {
		this.twoDArray = new Node[height][width];
		this.height = height;
		this.width = width;
	}
	
	/**
	 * This method will find the shortest path to the goal point by
	 * using breadth first search idea.
	 * (Code from lecture)
	 * 
	 * @param start point in the graph
	 * @param goal point in the graph
	 */
	public void bfs(Node start, Node goal)
	{
		//using java's queue implenmened by linked list.
		Queue<Node> queue = new LinkedList<Node>();
		//start at the start point.
		Node current =  start;
		current.visited = true;
		queue.add(start);
		
		/*
		 * When queue ie empty, that means there is no path to the goal point.
		 * else, it will do the breadth first search idea to find the shortest path.
		 * 
		 */
		while(!queue.isEmpty()) {
			current = queue.remove();
			if(current.equals(goal))
				return;
			
			for(Node next: current.neighbors) {
				if(!next.visited) {
					next.visited = true;
					next.from = current;
					queue.add(next)	;
					}
				}
			}	 
		}
	/**
	 * This code will go through the shortest path, and put dots on the paths.
	 * 
	 * @param start point
	 * @param goal point
	 */
	public void generateDot(Node start, Node goal) {
		Node current = goal;
		/*
		 * If there is no path, then it will do nothing,
		 * else put dots in the shortest path.
		 */
		while(current.from !=null) {
			current =  current.from;
			current.element = ".";
			if(current.from.element.equals("S")) {
				break;
			}
			
		}
	}

	/**
	 * This method will find the neighbors on a node's top,bottom,left, and right side.
	 * If it's neighbors are wall("X"),then it will not put them into its neighbor list.
	 * 
	 * @param node that needs to find its neighbors
	 * @param height of its position
	 * @param width of its position
	 */
	public void addNeighbors(Node node, int height, int width) {
		//up
		if(height-1 >= 0 && !twoDArray[height-1][width].element.equals("X")) { 
			node.neighbors.add(twoDArray[height-1][width]);
		}
		//down
		if(height+1 < this.height && !twoDArray[height+1][width].element.equals("X")) {
			node.neighbors.add(twoDArray[height+1][width]);
		}
		//left
		if(width-1 >= 0 && !twoDArray[height][width-1].element.equals("X") ) {
			node.neighbors.add(twoDArray[height][width-1]);
		}
		//right
		if(width+1 < this.width && !twoDArray[height][width+1].element.equals("X") ) {
			node.neighbors.add(twoDArray[height][width+1]);
		}		
	}
}
