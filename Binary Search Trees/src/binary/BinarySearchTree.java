import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Represents a generically-typed binary search tree.
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/05/2018
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements SortedSet<E> {

	private BinaryNode<E> 	root;
	private int 				size;
	private int 				countForArray; // for toArray method.

	/**
	 * Constructor for BinarySearchTree class.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		countForArray = 0;
	}

	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E first() throws NoSuchElementException {
		if (root == null)
			throw new NoSuchElementException();

		BinaryNode<E> current = root;
		
		//looking for the most left item.
		while (current.left != null) {
			current = current.left;
		}
		return current.element;
	}

	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E last() throws NoSuchElementException {
		if (root == null)
			throw new NoSuchElementException();

		BinaryNode<E> current = root;

		//looking for most right element.
		while (current.right != null) {
			current = current.right;
		}
		return current.element;
	}

	/**
	 * Adds the specified element to this set if it is not already present and not
	 * set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	@Override
	public boolean add(E element) {
		if (element == null)
			throw new NullPointerException();
		
		if (this.contains(element))
			return false;

		if (root == null) {
			root = new BinaryNode<E>(element);
			size++;
			return true;
		}
		
		else {
			BinaryNode<E> current = root;
			while (true) {
				// if the left is not null, then keep find until an open position
				if (element.compareTo(current.element) < 0) {
					if (current.left == null) {
						current.left = new BinaryNode<E>(element);
						break;
						} 
					else {  // else loop through again.
						current = current.left;
						continue;
						}
				}
			    else {
			    	// if the right is not null, then keep find until an open position
					if (current.right == null) {
						current.right = new BinaryNode<E>(element);
						break;
						} 
					else {  // else loop through again.
						current = current.right;
						continue;
						}
			    		}
				}
			}
		size++;
		return true;
	}
	/**
	 * Adds all of the elements in the specified collection to this set if they are
	 * not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		boolean check = false;
		for (E element : elements) {
			check = this.add(element);
		}
		return check;
	}

	/**
	 * Removes all of the elements from this set. The set will be empty after this
	 * call returns.
	 */
	@Override
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	@Override
	public boolean contains(Object element) {
		if(element ==null) 
			throw new NullPointerException();
		
		if (size == 0) 
			return false;
		
		@SuppressWarnings("unchecked")
		E data = (E) element;
		BinaryNode<E> current= root;
		
		// if find a null, then it does not exist in the tree.
		while (true) {
			if (data.compareTo(current.element) == 0)
				return true;

			else if (data.compareTo(current.element) < 0) {
				// if found until a null position, then there is no exist element
				if (current.left == null)
					return false;
				else
					// else go ahead do the loop again.
					current = current.left;
			}
			else {
				// if found until a null position, then there is no exist element
				if (current.right == null)
					return false;
				else
					// else go ahead do the loop again.
					current = current.right;
			}
		}
	}

	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	@Override
	public boolean containsAll(Collection<?> elements) {
		for (Object element : elements) {
			// if one of the elements not in the tree, return false
			if (!this.contains(element)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return true if this set contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	@Override
	public boolean remove(Object element) {
		if(element == null) {
			throw new NullPointerException();
		}
		if (!this.contains(element) || size==0) {
			return false;
		}
		//removing null
		//what if empty tree.
		
		@SuppressWarnings("unchecked")
		E data = (E) element;
		BinaryNode<E> current = root;
		BinaryNode<E> parent= current;
		
		// found the position of the removing element and its parent;
		while (true) {
			if (data.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
			}
			else if (data.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
			}
			else
				break; // found it, go out the loop.
		}
		
		/*
		 * case 1:Removing a node with 0 subtrees;
		 */
		
		if(current.left==null&& current.right ==null) {
			//if the removing element is root, then set root to null.
			if(element.equals(root.element)) 
				root = null;
			// else linked parent.left to null
			else if( parent.left !=null && parent.left.element.equals(element)) 
				parent.left =null;
			else  // else linked parent.right to null
				parent.right = null;
		}
		
		/*
		 * case 2: Removing a node with 2 subtrees.
		 */
		else if(current.left !=null && current.right !=null) {
			BinaryNode<E> minNode;
			
			if(current.right.left ==null) {
				//check to see if the removing element is in root or not.
				if(element.equals(root.element)) {
					root.element = current.right.element;
					if(current.right.right!=null) { //check to see if the removing element has right or not.
						root.right =current.right.right;
					}
					else {
						root.right = null;
					}
				}
				// check to see if the element is in left or right.
				else if(parent.left !=null && parent.left.element.equals(element)) {
					parent.left.element = current.right.element;
					if(current.right.right!=null) { //check to see if the removing element has right or not.
						current.right =current.right.right;
					}
					else {
						current.right = null;
					}
				}
				else {
					parent.right.element = current.right.element;
					if(current.right.right!=null) { //check to see if the removing element has right or not.
						current.right =current.right.right;
					}
					else {
						current
						.right = null;
					}
				}
			}
			else {
				// second case of case 2. when the element.right.left isnt null.
				BinaryNode<E>minParent = current.right;
				minNode = current.right.left;
				//find the right most left node.
				while(minNode.left!=null) {
					minParent = minNode;
					minNode = minNode.left;
				}
				// found element.right.left, but check if its right is null or not
				// if right child of the removing element is null, then just swap the current and the removing element
				if(minNode.right ==null) {
					//check to see if the removing element is in root or not.
					if(element.equals(root.element)) { 
							root.element = minNode.element;
							minParent.left = null;
					}
					else { 
						if(parent.left !=null && parent.left.element.equals(element)) {
							parent.left.element = minNode.element;
							minParent.left =null;
						}
						else {
							parent.right.element = minNode.element;
							minParent.left =null;
						}
					}
				}
					
				else {   // if its right is not null, then replace its right element into its position.
					//check to see if the removing element is in root or not.
					if(root.element.equals(element)) {
						root.element = minNode.element;
						minParent.left = minNode.right;
						
					}
					
					else {
						if(parent.left !=null && parent.left.element.equals(element)) {
							parent.left.element = minNode.element;
							minParent.left = minNode.right;
						}
						else {
							parent.right.element = minNode.element;
							minParent.left = minNode.right;
				
						}	
					}
				}
			}
		}
		
		/*
		 * case 3: Removing a node with 1 subtrees
		 */
		else if(current.left ==null) {
			
			/*
			 * 1) check which side is null. left or right.
			 * 2) which side is the element on. parent left or right.
			 */
			
			//always check if the element in root or not first.
			if(element.equals(root.element)) {
				root = current.right;
			}
	
			else if(parent.left !=null &&parent.left.element.equals(element)) {
				parent.left = current.right;
			}
			
			else {
				parent.right= current.right;
			}
		}
		
		else {
			//else right is null.
			//check if it is root or not.
			if(element.equals(root.element)) {
				root = current.left;
			}
			//then check which side is the removing element on.
			else if(parent.left !=null && parent.left.element.equals(element)) {
				parent.left = current.left;
			}
			else
				parent.right= current.left;
			}
		size--;
		return true;
	
	}
	
	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean removeAll(Collection<?> elements) {
		boolean check = false;
		for (Object element: elements) {
			check = remove(element);
		}
		return check;
	}

	/**
	 * @return the number of elements in this set
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	@Override
	public Object[] toArray() {
		if (size == 0) {
			return new Object[0];
		}

		Object[] array = new Object[size];
		toArray(root, array); //recursion.
		return array;
		
	}
	
	/**
	 * Generates a string containing all of the edges in a BST, in DOT format.
     * Assumes root reference of this BST is called “root”.
	 * 
	 * @return DOT format string to enter at http://www.webgraphviz.com
	 */

	public String generateDot() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("BST not large enough to visualize.");
		}
		String result = "digraph BST {\n";
		result += "  node [shape=record]\n";
		result += root.generateDot();
		
		return result + "}";
	}

	/**
	 * Private helper recursion method for changing BST into array.
	 * 
	 * @param current
	 *            node
	 * @param array
	 * @param countForArray
	 * @return an array with all the elements in the BST(ascending order)
	 */
	private void toArray(BinaryNode<E> current, Object[] array) {
		// in-order traversal as we talked in class.
		if(current != null) {
			toArray(current.left, array);
			array[countForArray++] = current.element;
			toArray(current.right,array);
		}	
	}
	
	/**
	 * This method is just for testing only. 
	 * @return the element of root.
	 */
	public E getRoot() {
		return root.element;
	}
	
	
	/**
	 * Represents a generically-typed binary tree node. Each binary node contains
	 * data, a left child, and a right child.
	 *
	 */
	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		public BinaryNode(E element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}	
		
		/**
		 * Generates a string containing all of the edges in the tree rooted at
		 * "this" node, in DOT format.
	         * Assumes this node has member variables called “data”, “leftChild”, and “rightChild”.
		 * 
		 * @return DOT format string to enter at http://www.webgraphviz.com
		 */
		public String generateDot() {
			String ret = "  node" + element + " [label = \"<f0> |<f1> " + element + "|<f2> \"]\n";
			if(left != null)
				ret += "  node" + element + ":f0 -> node" + left.element + ":f1\n" + left.generateDot();
			if(right != null)
				ret += "  node" + element + ":f2 -> node" + right.element + ":f1\n" + right.generateDot();
			return ret;
		}

	}
}
	