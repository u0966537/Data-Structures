import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 

/**
 * This class is to find the largest anagram group from an array
 * by using insertion sort method, which will cost O(n^2) Complexity.
 * 
 * @author Junjun He && Parimal Raghavan
 * @version 02/08/2018
 *
 */
public class AnagramUtil {
	

	/**
	 * Sort the letters of a word lexicographically order(a-z) by 
	 * using insertion sort.
	 * 
	 * All upper case letters will transform into lower case.
	 * 
	 * If a null argument is passed, the method should return null. 
	 * 
	 * @param word that needs to be in sorted form.
	 * @return sorted form
	 */
	public static String sort(String word) {
		
		if(word  == null) {
			return null;
		}
		
		Character[] letters = new Character[word.length()];
		
		//putting each letters into an array
		for (int index = 0; index < word.length(); index++) {
			letters[index] = word.charAt(index);
		}
		
		insertionSort(letters,new charComparator());
		
		// putting each letters back to a word as String type.
		StringBuilder sortedWord = new StringBuilder("");
		for(Character chars: letters)
		{
			sortedWord.append(chars);
		}

		return sortedWord.toString();
	}
	
	
	/**
	 * This generic method sorts the input array using an insertion sort 
	 * and the input Comparator object.
	 * 
	 * If a null argument is passed, 
	 * the method should throw a NullPointerException.
	 * 
	 * @param array that needs to be sorted
	 * @param comparator the order that user wants
	 */
	public static <T> void insertionSort(T[] array , Comparator<? super T> comparator) {
		
		if(array ==null|| comparator ==null) {
			throw new NullPointerException();
		}
		
		/*
		 * The first pointer will stop on an index until the 
		 * second Pointer goes through every index.
		 */
		
		for( int firstPointer = 0; firstPointer < array.length ; firstPointer++ ) {
			
			for( int secondPointer = firstPointer; secondPointer > 0 ; secondPointer -- ) {

				if( comparator.compare(array[secondPointer-1],array[secondPointer]) >0){
                    
					 T tempElement = array[secondPointer];
			         array[secondPointer] = array[secondPointer-1];
			         array[secondPointer-1] = tempElement;
                }
		}		
	}
	}	
	
	 /**
	  * This method returns true if two strings are anagrams. 
	  * Otherwise return false.
	  * 
	  * Two null strings are considered anagram as well.
	  * @param leftHandSide
	  * @param rightHandSide
	  * @return
	  */
	public static boolean areAnagrams(String leftHandSide, String rightHandSide) {
	;
		/*
		 * If two of them are null, then return true, else only 
		 * one of them is null return false.
		 */
		if(leftHandSide ==null && rightHandSide == null) {
			return true;  
		}
		else if( leftHandSide == null || rightHandSide == null) {
			return false; 
		}
		
		return sort(leftHandSide.toLowerCase()).equals((sort(rightHandSide.toLowerCase())));
	}
	

	/**
	 * This method will return a list of largest anagram group in 
	 * an unsorted string array. The return list sort them in 
	 * (first in, then first in the new array).
	 * 
	 * Assume There will only ever be one largest group of anagrams 
	 * in a list of words.
	 * 
	 * @param array string array
	 * @return a perfect size array with the anagram words
	 */
	public static String[] getLargestAnagramGroup(String[] array) {
		
		if(array ==null || array.length <2) {
			return new String[0];
		}
		
		String[] sortedArray = Arrays.copyOf(array, array.length);
		
		//sort the array.
		for(int index = 0 ; index < sortedArray.length ; index++) {
			sortedArray[index] = sort(sortedArray[index]);
		}
		insertionSort(sortedArray,new stringComparator());
		
		// this is used for answering questions on analysis assignment.
//		Arrays.sort(sortedArray); 
		
		// pointing on the index to compare with other object
		int pointer = 0;  
		
		// index of a word from largest anagram group.
		// So we can use it to compare later.
		int largestIndex = 0;
		
		// largest anagram group size.
		int largestSize = 0;
		
		int tempSize = 0;
		
	
		/*
		 * This loop will find the quantity of largest group
		 * and index of the word of largest anagram group.
		 */
		for(int index = 1; index < sortedArray.length ; index++) {
			if(areAnagrams(sortedArray[pointer], sortedArray[index])) {
				tempSize++; 
				//without this code, if the largest anagram is at the end of sorted array
				// then it will fail.
				if(largestSize < tempSize) {
					largestSize = tempSize;
					largestIndex = pointer;
				}
			}
			else {
				//if they are not the same, reset, and set tempSize to largestSize if needed
				if(largestSize < tempSize) {
					largestSize = tempSize;
					largestIndex = pointer;
					}
				pointer = index;
				tempSize=0;
				}	
		}
		
		if(largestSize <=0) {
			return new String[0];
		}
		
		
		/*
		 * This loop is to use the word of the largest group to compare every
		 * word in the array, if they are equal, then they are anagram,
		 * then put it into the final array.
		 */
		String[] largest =  new String[largestSize+1];
		int count = 0;	
		for(int index = 0; index < array.length ; index++) {
			if(areAnagrams(sortedArray[largestIndex], array[index])) {
				largest[count] =array[index];
				count++;
		}
	}
		
		return largest;
}

	/**
	 * This method will store every word that comes from a file 
	 * into an array, and it will find the largest anagram group.
	 * 
	 * Assumed that the file contains one word per line
	 * @param scan 
	 * @return a list of anagram words
	 */
	public static String[] getLargestAnagramGroup(Scanner scan) {
		
		ArrayList<String> list = new ArrayList<String>();

		if(scan ==null || !scan.hasNext()) {
			return new String[0];
		}
		
		// Add the words into list if it has next line
		while(scan.hasNextLine()) {
			list.add(scan.nextLine());
		}
									// this code will transform list into array.
		return getLargestAnagramGroup(list.toArray(new String[list.size()]));
		
	}
	

	
	/**
	 * This private helper method will compare two character objects  by using comparator
	 */
	private static class charComparator implements Comparator<Character> {
		@Override
		// Make sure they are at the same case when they are comparing
		public int compare(Character leftHandSide, Character rightHandSide) {
			return Character.compare(Character.toLowerCase(leftHandSide), 
					Character.toLowerCase(rightHandSide));
		}
	}
	
	
	/**
	 * This private helper method will compare two string object by using comparator
	 */
	private static class stringComparator implements Comparator<String> {
		@Override
		// Make sure they are at the same case when they are comparing
		public int compare(String leftHandSide, String rightHandSide) {
			return	leftHandSide.toLowerCase().compareTo(rightHandSide.toLowerCase());		}
	}
	
	
}
