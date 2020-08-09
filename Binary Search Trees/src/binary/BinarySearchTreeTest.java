import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

/**
 * Binary Search Tree Test
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/05/2018
 *
 */
public class BinarySearchTreeTest {
	BinarySearchTree<Integer> tree;

	@Before
	public void setUpBefore ()
	{
		tree = new BinarySearchTree<>();
		
		for(Integer i = 0; i < 1000;i++)
		{
			tree.add(i);
		}
	}
	
	@Test
	public void getLowestValue() {
		assertEquals((Integer)0, tree.first());
		assertEquals(1000, tree.size());
	}
	
	@Test
	public void getHighestValue() {
		assertEquals((Integer)999, tree.last());
		assertEquals(1000, tree.size());
	}
	
	@Test (expected  = NullPointerException.class)
	public void addNullElement() {
		tree.add(null);
	}
	
	@Test
	public void addWhenRootIsNull() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.add(10);
		assertTrue(tree2.contains(10));
		assertTrue(tree2.size()==1);
	}
	
	@Test
	public void addWhenAlreadInTree() {
		assertFalse(tree.add(0));
		assertFalse(tree.add(11));
		assertFalse(tree.add(12));
		assertFalse(tree.add(999));
	}
	
	@Test
	public void addWhenHaveNotInTree() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		assertTrue(tree2.add(1));
		assertTrue(tree2.add(0));
		assertTrue(tree2.add(-1));
		assertFalse(tree2.add(1)); // alread in the tree
	}
	
	@Test
	public void addAll() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		ArrayList<Integer> list =  generateShuffled(100);
		tree2.addAll(list);
		assertTrue(tree2.size()==100);
	}
	
	@Test (expected  = NullPointerException.class)
	public void addAllWithNullElements() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		ArrayList<Integer> list =  generateShuffled(100);
		list.add(null);
		tree2.addAll(list);
	}
	@Test
	public void addAllElementAlreadyInTree() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		for(int count = 1; count<=100;count++) {
			tree2.add(count);
		}
		ArrayList<Integer> list =  generateShuffled(100);
		assertFalse(tree2.addAll(list));
	}
	
	@Test
	public void containCheckExistElement() {
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(100));
		assertTrue(tree.contains(999));
	}
	
	@Test
	public void containCheckNotExistElement() {
		assertFalse(tree.contains(1000));
		assertFalse(tree.contains(1001));
		assertFalse(tree.contains(-1));
	}
	
	@Test (expected  = NullPointerException.class)
	public void containSendingNullElement() {
		tree.contains(null);
	}
	
	@Test
	public void containAll() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		ArrayList<Integer> list =  generateShuffled(100);
		tree2.addAll(list);
		assertTrue(tree2.containsAll(list));
	}
	
	@Test (expected  = NullPointerException.class)
	public void containAllWithNullElements() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.contains(null);	
	}
	
	@Test
	public void containAllElementNotInTree() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		for(int count = 1000; count<=1020;count++) {
			tree2.add(count);
		}
		ArrayList<Integer> list =  generateShuffled(100);
		assertFalse(tree2.containsAll(list));
	}
	
	@Test
	public void containOneElementNotInTree() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		for(int count = 1; count<=100;count++) {
			tree2.add(count);
		}
		ArrayList<Integer> list =  generateShuffled(101);
		assertFalse(tree2.containsAll(list));
	}
	
	
	@Test
	public void testClear() {
		tree.clear();
		assertTrue(tree.size()==0);
	}
	
	public void testToArray() {
		Object[] arr = tree.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
//	comment out when use
//	@Test 
	public void generatDot() throws Exception
	{
		String s= tree.generateDot();
		System.out.println(s);
	}

	@Test
	public void testRemoveNoElements() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		assertFalse(tree2.remove((Integer) 1));
	}
	
	@Test
	public void testRemoveOnlyOneElement() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		tree2.add((Integer) 1);
		assertTrue(tree2.remove(1));
	}
	
	@Test
	public void testRemoveLeftTreeIsEmpty() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add((Integer) 9);
		tree.add((Integer) 10);
		tree.add((Integer) 11);
		tree.remove((Integer) 9);
		assertTrue(tree.getRoot().equals((Integer)10));
	}
	
	@Test
	public void testRemoveRightTreeIsEmpty() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		tree2.add((Integer) 9);
		tree2.add((Integer) 8);
		tree2.add((Integer) 7);
		tree2.remove((Integer) 9);
		assertTrue(tree2.getRoot().equals((Integer)8));
	}
	
	@Test
	public void removeAll() throws Exception {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
		ArrayList<Integer> list =  generateShuffled(1000);
		tree2.addAll(list);
		 assertTrue(tree2.removeAll(list));
	}
	
	@Test (expected  = NullPointerException.class)
	public void removeAllWithNullElements() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.removeAll(null);
		
	}
	@Test
	public void RemoveAllElementAlreadyInTree() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		for(int count = 1; count<=100;count++) {
			tree2.add(count);
		}
		ArrayList<Integer> list =  generateShuffled(100);
		assertTrue(tree2.removeAll(list));
	}
	
	@Test
	public void removeRootWhenRootHasNo_Right_Left() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.add(10);
		for(int i =0;i<=10; i++) {
			tree2.add(i);
		}
		for(int i =11; i <=20; i++) {
			tree2.add(i);
		}
		tree2.remove(10);
		assertTrue(tree2.getRoot()==11);
	}
	
	@Test
	public void removeRootWhenRootHas_Right_Left() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.add(10);
		tree2.add(15);
		tree2.add(14);
		tree2.add(13);
		tree2.add(12);
		tree2.add(9);
		tree2.remove(10);
		Object[]array = tree2.toArray();
		assertTrue(array[0]==(Integer)9);
		assertTrue(array[1]==(Integer)12);
		assertTrue(array[2]==(Integer)13);
	
	}
	
	@Test
	public void removeRootWhenRootHas_Right_Left_AndRIghtLeftHasRight() {
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.add(10);
		tree2.add(20);
		tree2.add(18);
		tree2.add(16);
		tree2.add(17);
		tree2.add(5);
		
		tree2.remove(10);
		Object[]array = tree2.toArray();
		assertTrue(array[0]==(Integer)5);
		assertTrue(array[1]==(Integer)16);
		assertTrue(array[2]==(Integer)17);
		assertTrue(array[3]==(Integer)18);
		assertTrue(array[4]==(Integer)20);
	}
	

	@Test
	public void generaDot() throws Exception {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		ArrayList<Integer> arr = generateShuffled(30);
		tree.addAll(arr);
		
//      Comment out when use the code below
//		System.out.println(tree.generateDot());
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * This code are for testing ! Generate [1 to size] elements
	 * @param size
	 * @return
	 */
	 static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int index = 1; index <= size; index++)
			list.add(index);
		return list;
	}

	/**
	 * This code are for testing ! Generate [1 to size] elements in random position.
	 * @param size
	 * @return
	 */
	static ArrayList<Integer> generateShuffled(int size) {
		ArrayList<Integer> list = generateAscending(size);
		Collections.shuffle(list);
		return list;
	}
	
	/**
	 * This code are for testing ! Generate [size to 1] elements
	 * @param size
	 * @return
	 */
	 static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int index = size; index > 0; index--)
			list.add(index);
		return list;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
