import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTiming {
	BinarySearchTree<Integer> tree;
	TreeSet<Integer> treeSet;
	@Before
	public void setUp() {
		 tree = new BinarySearchTree<Integer>();
		 treeSet = new TreeSet<Integer>();
	}

	// comment the @Test out when use.
	 @Test
	public void timing1() {
		

		for (int exp = 1000; exp <= 5000; exp = exp + 100) { // This is used as the exponent to calculate the size of the
															// set.
			long totalTime = 0;

			// Do the experiment multiple times, and average out the results
			for (int iter = 0; iter < 30; iter++) {

				ArrayList<Integer> arr = new ArrayList<Integer>();
				// arr = BinarySearchTreeTest.generateAscending(exp);
				arr = BinarySearchTreeTest.generateShuffled(exp);

				// tree.addAll(arr);
//				treeSet.addAll(arr);
				for (int i = 1; i < exp; i++) {
					long start = System.nanoTime();
					treeSet.add(arr.get(i));
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
			}
			double averageTime = totalTime / exp;
			System.out.println(exp + "\t" + averageTime); // print to console
		}
	}

	// comment the @Test out when use.
//	@Test
	public void timing2() {
		

		for (int exp = 10; exp <= 25; exp++) { // This is used as the exponent to calculate the size of the set.
			int size = (int) Math.pow(2, exp);

			long totalTime = 0;

			// Do the experiment multiple times, and average out the results
			for (int iter = 0; iter < 30; iter++) {

				ArrayList<Integer> arr = BinarySearchTreeTest.generateShuffled(size);
				// treeSet.addAll(arr);
				tree.addAll(arr);
				for (int i = 0; i < size; i++) {
					long start = System.nanoTime();
					// treeSet.contains(arr.get(i));
					 tree.contains(arr.get(i));
					long stop = System.nanoTime();
					totalTime += stop - start;
				}

			}
			double averageTime = totalTime / size;
			System.out.println(size + "\t" + averageTime); // print to console

		}
	}
}