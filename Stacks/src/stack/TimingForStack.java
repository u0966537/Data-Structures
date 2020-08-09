package src.stack;

import org.junit.Test;

/**
 * This class is used to test the methods of stack by different Structures.
 * 
 * @author Junjun He
 * @version 03/02/2018
 */
public class TimingForStack {

	@Test
	public void timing_For_Add() {

		StackArray<Integer> array = new StackArray<Integer>();
		StackLinkedList<Integer> list = new StackLinkedList<Integer>();

		for (int exp = 10; exp <= 25; exp++) { // This is used as the exponent to calculate the size of the set.
			int size = (int) Math.pow(2, exp);

			long totalTime = 0;

			// Do the experiment multiple times, and average out the results
			for (int iter = 0; iter < 5; iter++) {

				// add elements
				for (int i = 0; i < size; i++) {
					array.push(i);
					// list.push(i);
				}

				for (int i = 0; i < size; i++) {
					long start = System.nanoTime();
					// array.push(i);
					// list.push(i);

					// array.pop();
					// list.pop();

					array.peek();
					// list.peek();
					long stop = System.nanoTime();
					totalTime += stop - start;
				}

			}
			double averageTime = totalTime / size;
			System.out.println(size + "\t" + averageTime); // print to console

		}

	}
}