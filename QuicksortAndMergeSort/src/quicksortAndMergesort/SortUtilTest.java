package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

/**
 * This class tests SortUtil class
 * @author Junjun He && Raphael Kwankam
 * @version 02/14/2018
 */
public class SortUtilTest {

	@Test
	public void testOneElement_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		SortUtil.mergesort(arr,new IntegerComparator());
		assertEquals((Integer)1,arr.get(0));
	}

	@Test
	public void testOneElement_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		SortUtil.quicksort(arr,new IntegerComparator());
		assertEquals((Integer)1,arr.get(0));
	}
	
	
	
	
	
	
	
	@Test
	public void testTwoElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(2);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
		
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
		assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testTwoElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(2);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
		
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}


	
	
	
	
	
	@Test
	public void testThreeElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(3);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
		
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testThreeElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(3);
		
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);

		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	

	
	
	@Test
	public void testFiveElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(5);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testFiveElements_QuickSort(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr= SortUtil.generateAscending(5);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	
	
	@Test
	public void testTenElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(10);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testTenElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(10);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	
	
	
	
	@Test
	public void testTwentyElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(20);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testTwentyElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(20);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	

	
	@Test
	public void testOneHundredElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 =SortUtil.generateShuffled(100);
		

		SortUtil.mergesort(arr2, new IntegerComparator());
	
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testOneHundredElements_QuickSort() {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 =SortUtil.generateShuffled(100);
		
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	
	@Test
	public void testOneThousandElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(1000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 =SortUtil.generateShuffled(1000);
	
		SortUtil.mergesort(arr2, new IntegerComparator());
		
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testOneThousandElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(1000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		Collections.shuffle(arr2);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testTenThousandElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(10000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateDescending(10000);

		SortUtil.mergesort(arr2, new IntegerComparator());
	
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));

		}
	}
	
	@Test
	public void testTenThousandElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(10000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(10000);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testTwentyThousandElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(20000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(20000);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testTwentyThousandElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(20000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(20000);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testOneHundredThousandElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(100000);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testOneHundredThousandElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(100000);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	
	@Test
	public void testOneMilliondElements_MergeSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(1000000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(1000000);
	
		SortUtil.mergesort(arr2,new IntegerComparator());
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	@Test
	public void testOneMilliondElements_QuickSort() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(1000000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(1000000);
	
		SortUtil.quicksort(arr2,new IntegerComparator());
		
		for(int i=0 ; i<arr2.size();i ++) {
			assertEquals(arr.get(i),arr2.get(i));
		}
	}
	
	
	@Test
	public void testGeneratesAscending() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			arr2.add(i);
		}
		
		assertEquals(arr, arr2);
	}
	
	@Test
	public void testGeneratesDescending() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateDescending(100);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 100; i >= 1; i--) {
			arr2.add(i);
		}
		
		assertEquals(arr, arr2);
	}
	

	@Test
	public void testGeneratesShuffled() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateShuffled(100);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i = 100; i >= 1; i--) {
			arr2.add(i);
		}
		
		assertNotEquals(arr, arr2);
	}
	
	
	@Test
	public void testttttt() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = SortUtil.generateAscending(100000);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2 = SortUtil.generateShuffled(100000);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3 = SortUtil.generateShuffled(100000);
		
		SortUtil.mergesort(arr2, new IntegerComparator());
		SortUtil.quicksort(arr3, new IntegerComparator());
		
		assertEquals(arr2, arr);
		assertEquals(arr3, arr);
	}
	
////////	////////	////////	////////	////////	///////////////////////////////////////////////
	public class IntegerComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 -o2;
		}
		
	}
	

}
