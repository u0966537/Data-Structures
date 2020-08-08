import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;




/**
 * This class tests the complexity of SortUtil class.
 * It also generates data of different threshold points 
 * and pivot points
 * 
 * This code is written by author, and for author only, not for partner.
 * @author Junjun He 
 * @version 02/14/2018
 */
public class SortUtilTiming {
	
	ArrayList<Integer> arr = SortUtil.generateShuffled(10000);
	
	@Test
	public void time_complecity_mergesort() {
		//time for n elements in merge sort.
		long startTime = 0,  stopTime = 0, total =0;
		
		for (int n = 100; n <= 1000000; n += 100000) {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
				//list will always have the same order and length.
				//worst case
				list =SortUtil.generateDescending(n);
				
				// threshold
				SortUtil.thresHold(5);
				
				startTime = System.nanoTime(); //start timing
	
				SortUtil.mergesort(list, new IntegerComparator());
				
				stopTime = System.nanoTime(); // stop timing
				total +=stopTime - startTime; // store result
			
			// when use please comment this out.
//			System.out.println(n + "\t" +  total );
			}
	}
	
	
	
	@Test
	public void timing_pivottype() {
		long startTime = 0,  stopTime = 0, total =0;
		ArrayList<Integer>  list= new ArrayList<Integer>();
		for (int n = 10000; n <= 100000; n += 10000) {
			list = SortUtil.generateShuffled(n);
			
			//list will always have the same order and length.
			//worst case

//			SortUtil.pivotTypeMiddle();	
			SortUtil.pivotTypeMedian();
//			SortUtil.pivotTypeRandom();
			startTime = System.nanoTime(); //start timing
			

			SortUtil.quicksort(list, new IntegerComparator());
			
			stopTime = System.nanoTime(); // stop timing
			total +=stopTime - startTime; // store result
			
			//comment it out when use
//			System.out.println(n + "\t" +  total);
		}
	}
	
	
	@Test
	public void timing_Mergesort_vs_Quicksort() {
		long startTime = 0,  stopTime = 0, total =0;

		for (int n = 10000; n <= 100000; n += 10000) {
			//best case
//			ArrayList<Integer>  list= SortUtil.generateAscending(n);  
			//average case
//			ArrayList<Integer>  list= SortUtil.generateShuffled(n);
			//worst case
			ArrayList<Integer>  list= SortUtil.generateDescending(n);
			
			
			ArrayList<Integer> list2=  new ArrayList<Integer>();
			list2.addAll(list);
			
			
			//list will always have the same order and length.
			//worst case


			SortUtil.pivotTypeRandom();
			SortUtil.thresHold(5);
			startTime = System.nanoTime(); //start timing
			
			SortUtil.mergesort(list2, new IntegerComparator());
			
			stopTime = System.nanoTime(); // stop timing
			total +=stopTime - startTime; // store result
			
			
			System.out.println(n + "\t" +  total);
			
		}
		
	}
	
	
	public class IntegerComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 -o2;
		}
		
	}
	


	
}
