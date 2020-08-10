import java.util.ArrayList;
import org.junit.Test;


/**
 * This class will get the data of collions and running time.
 * @author hejunjun
 * @version 03-29-2018
 */
public class TimeAssignment09 {
	ArrayList<String> words;
	
	/**
	 * Get the number of collisions by accessing to an element's index.
	 */
	//@Test  // when use, comment test out.
	public void getCollisions() {
		QuadProbeHashTable table = new QuadProbeHashTable(0, new GoodHashFunctor());
		ChainingHashTable table2 = new ChainingHashTable (0, new GoodHashFunctor());
		
		for (int totalElements = 0; totalElements <= 1000000; totalElements += 100000) {
			int end = 0;
			int total = 0;
			
			// add elements into the table.
			for (int currentElements = 0; currentElements < totalElements; currentElements++) {
				table2.add(currentElements+"");
			}

			// test access, and get data.
			for (int currentElements = 0; currentElements < totalElements; currentElements++) {
				int start = table2.getCollisions();
				table2.contains(currentElements+"");
				end = table2.getCollisions();
				total += end - start;

			}
			System.out.println(totalElements + "\t" + total);
		}
	}

	
	//@Test  //comment out test when use
	public void timing() {
		QuadProbeHashTable table = new QuadProbeHashTable(0, new GoodHashFunctor());
		ChainingHashTable table2 = new ChainingHashTable(0, new GoodHashFunctor());

		for (int exp = 10; exp <= 25; exp++) { // This is used as the exponent to calculate the size of the set.
			int size = (int) Math.pow(2, exp);

			long totalTime = 0;

			// Do the experiment multiple times, and average out the results
			for (int iter = 0; iter < 5; iter++) {
				for (int i = 0; i < size; i++) {
					table2.add(i + "");
				}

				// treeSet.addAll(arr);

				for (int i = 0; i < size; i++) {
					long start = System.nanoTime();
					// treeSet.contains(arr.get(i));
					table2.contains(i + "");
					long stop = System.nanoTime();
					totalTime += stop - start;
				}

			}
			double averageTime = totalTime / size;
			System.out.println(size + "\t" + averageTime); // print to console

		}
	}
}
