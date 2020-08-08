import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * This class implements merge sort and quick sort. Merge sort uses insertion
 * sort for small enough subarrays.
 * 
 * @author Junjun He && Raphael Kwankam
 * @version 02/14/2018
 */

public class SortUtil {

	private static Random random=null;
	
	private static int insertionSortThreshold = 20;

	private static final int PIVOT_MEDIAN = 0;
	private static final int PIVOT_RANDOM = 1;
	private static final int PIVOT_MIDDLE = 2;
	// choose a pivot type 
	private static int pivotType = PIVOT_MEDIAN;
	
	/**
	 * Driver method for mergesort. Sort the array by using mergesort.
	 * 
	 * @param Arraylist
	 * @param comparator
	 */
	@SuppressWarnings("unchecked")
	public static <T> void mergesort(ArrayList<T> list, Comparator<? super T> comparator) {
		mergesort(list, (T[]) new Object[list.size()], 0, list.size(), comparator);
	}

	/**
	 * Driver method for quicksort. Sort the array by using quicksort.
	 * 
	 * @param Arraylist
	 * @param comparator
	 */
	public static <T> void quicksort(ArrayList<T> list, Comparator<? super T> comparator) {
		quicksort(list, 0, list.size(), comparator);
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * ascending order.
	 * 
	 * @param Array
	 *            Length
	 * @return Arraylist
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int index = 1; index <= size; index++)
			list.add(index);
		return list;

	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * permuted order (i,e., randomly ordered).
	 * 
	 * @param Array
	 *            Length
	 * @return Arraylist
	 */
	public static ArrayList<Integer> generateShuffled(int size) {
		ArrayList<Integer> list = generateAscending(size);
		Collections.shuffle(list);
		return list;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * descending order.
	 * 
	 * @param Array
	 *            Length
	 * @return Arraylist
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int index = size; index > 0; index--)
			list.add(index);
		return list;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Private helper methods
	 */

	/**
	 * Private helper method. recursion method for merge sort.
	 * 
	 * @param Arraylist
	 * @param TempArray
	 * @param startPos
	 * @param endPos
	 * @param comparator
	 */
	private static <T> void mergesort(ArrayList<T> list, T[] mergeArray, int start, int end,
			Comparator<? super T> comparator) {
		if (start < end)
			// use insertion sort when list length is short
			if (end - start <= insertionSortThreshold) {
				insertionSort(list, start, end, comparator);
			} 
			else {
				int mid = (start + end) / 2;
				mergesort(list, mergeArray, start, mid, comparator);
				mergesort(list, mergeArray, mid, end, comparator);
				merge(list, mergeArray, start, mid, end, comparator);
			}
	}

	/**
	 * Private helper method. Merge two subarrays into one array.
	 * 
	 * @param ArrayList
	 * @param tempArray
	 * @param startPos
	 * @param midPos
	 * @param endPos
	 * @param comparator
	 */
	private static <T> void merge(ArrayList<T> list, T[] mergeArray, int start, int mid, int end,
			Comparator<? super T> comparator) {
		int startPos = start;
		int midPos = mid;
		int index = 0;

		// put smaller of element into array.
		while (startPos < mid && midPos < end) {
			if (comparator.compare(list.get(startPos), list.get(midPos)) < 0) {
				mergeArray[index++] = list.get(startPos++);
			} else {
				mergeArray[index++] = list.get(midPos++);
			}

		}

		// copy anything left over from large half to array
		while (startPos < mid)
			mergeArray[index++] = list.get(startPos++);
		while (midPos < end)
			mergeArray[index++] = list.get(midPos++);

		// copy array into list
		for (int idx = 0; idx < index; idx++) {
			list.set(start + idx, mergeArray[idx]);
		}

	}

	/**
	 * Private helper method. Sort the arraylist by using insertionsort
	 * 
	 * @param Arraylist
	 * @param startPos
	 * @param endPos
	 * @param comparator
	 */
	private static <T> void insertionSort(ArrayList<T> list, int start, int end, Comparator<? super T> comparator) {

		for (int firstPointer = start - 1; firstPointer < end; firstPointer++) {
			for (int secondPointer = firstPointer; secondPointer > start; secondPointer--) {
				if (comparator.compare(list.get(secondPointer - 1), list.get(secondPointer)) > 0) {
					swap(list, secondPointer - 1, secondPointer);
				}
			}
		}
	}

	/**
	 * Private helper method. Sort the array by using quick sort method.
	 * 
	 * @param Arraylist
	 * @param startPos
	 * @param endPos
	 * @param comparator
	 */
	private static <T> void quicksort(ArrayList<T> list, int start, int end, Comparator<? super T> comparator) {
		if (start<end-1) {
			int mid = partition(list, start, end, comparator);
			quicksort(list, start, mid, comparator);
			quicksort(list, mid+1, end, comparator);
		}
	}

	/**
	 * Private helper method. Separates list into two subarrays with a pivot
	 * 
	 * @param list
	 * @param start
	 * @param end
	 * @param comparator
	 * @return The index of the pivot
	 */
	private static <T> int partition(ArrayList<T> list, int start, int end, Comparator<? super T> comparator) {
		
		int pivot=0;
		int low = start;
		int high = end-1;
		
		// select a pivot type
		switch (pivotType) {
			case PIVOT_RANDOM: 
				pivot = pivotRandom(start, end);
				break;
				
			case PIVOT_MEDIAN: 
				pivot = pivotMedian(list, comparator, start, (end + start) / 2, end-1);
				break;
				
			case PIVOT_MIDDLE: 
				pivot = pivotMiddle((end + start) / 2);
				break;
		}
	
		swap(list, pivot, end-1);

		T pivotVal = list.get(end-1);

		while (low < high) {
			while ( low < high &&	comparator.compare(pivotVal, list.get(low)) > 0 ) {
				low++;
			}

			while ( low < high &&	comparator.compare(pivotVal, list.get(high)) <= 0) {
				high--;
			}
			swap(list, low, high);
		}
		swap(list, end-1, low);
		return low;
	}

	/**
	 * Private helper method. Returns a random pivot index.
	 * 
	 * @param startPos
	 * @param endPos
	 * @return pivot index
	 */
	private static <T> int pivotRandom(int start, int end) {
		return start + getRandom(end - start);
	}

	/**
	 * Private helper method. Returns a random number between 0 and size-1
	 * @param max
	 * @return
	 */
	private static int getRandom(int size) {
		if (random==null) random = new Random();
		return random.nextInt(size);
	}


	/**
	 * Private helper method. Return median of three.
	 * 
	 * @param startPos
	 * @param midPos
	 * @param endPos
	 * @return pivot index
	 */
	private static <T> int pivotMedian(ArrayList<T> list, Comparator<? super T> comparator, int start, int mid, int end) {
		T a = list.get(start);
		T b = list.get(mid);
		T c = list.get(end);
		if (comparator.compare(a,b)<=0 && comparator.compare(a,c)<=0) return start;
		if (comparator.compare(b, c)<=0) return mid;
		return end;
	}
	/**
	 * Private helper method. Return first index
	 * 
	 * @param middle
	 * @return pivot index
	 */
	private static <T> int pivotMiddle(int middle) {
		return middle;
	}

	/**
	 * Private helper method. Swap two elements.
	 * 
	 * @param Arraylist
	 * @param firstIndex
	 * @param secondIndex
	 */
	private static <T> void swap(ArrayList<T> list, int firstElement, int secondElement) {
		if (firstElement == secondElement) return;
		T temp = list.get(firstElement);
		list.set(firstElement, list.get(secondElement));
		list.set(secondElement, temp);
	}

	 
	/**
	 * For test threshold data
	 * @param threshold size.
	 */
	public static int thresHold(int size) {
		return  insertionSortThreshold = size;
	}
	
	/**
	 * For test pivotType
	 */
	public static void pivotTypeMedian() {
		pivotType = PIVOT_MEDIAN;
	}
	
	/**
	 * For test pivotType
	 */
	public static void pivotTypeRandom() {
		pivotType = PIVOT_RANDOM;
	}
	
	/**
	 * For test pivotType
	 */
	public static void pivotTypeMiddle() {
		pivotType = PIVOT_MIDDLE;
	}
	
}