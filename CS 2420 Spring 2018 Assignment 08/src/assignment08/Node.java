package assignment08;

import java.util.ArrayList;
/**
 * Node class to store its neighbor, visited or not, and came from which node.
 * By using this class, we could find the path from start to the goal.
 *
 * @author Junjun He && Xi Zheng
 * @version 03/15/2018
 */
public  class Node 
{
	String element;
	ArrayList<Node> neighbors;
	boolean visited;
	Node from;

	//Constructor for node class
	public Node(String element)
	{
		neighbors = new ArrayList<>();
		this.element = element;
		visited = false;
		from = null;
	}
}