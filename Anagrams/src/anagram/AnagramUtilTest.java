import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import org.junit.Test;

/**
 * This is the test for AnagramUtil class, including the timing codes
 * for areAnagrams method and getLargestAnagramsGroup method.
 * 
 * @author Junjun He && Parimal Raghavan
 * @version 02/08/2018
 *
 */
public class AnagramUtilTest {

//////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Tests for sorting method.
	 */
	
	@Test
	public void sorting_A_Null_String() {
		assertEquals(null,AnagramUtil.sort(null));
	}
	
	@Test
	public void sorting_Two_Same_Word_Cases_Should_Not_Change() {
		//when sort, the case of each letter should not change.
		assertEquals("eHllo",AnagramUtil.sort("Hello"));
		assertEquals("Cemoprtu",AnagramUtil.sort("Computer"));
		assertEquals("aDeElRt",AnagramUtil.sort("RelatED"));
		
	}
	
	@Test 
	public void sorting_Two_Different_Cases_Position_Should_Not_Change() {
		//two same word, but different cases, position should not change as well.
		assertEquals("Bbo",AnagramUtil.sort("Bob"));
		assertEquals("AeEilnPPp",AnagramUtil.sort("PineAPplE"));
		assertEquals("efinOrstuUvy",AnagramUtil.sort("uOfUnversity"));
	}
	



//////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Test for insertion sort
	 */

	@Test
	public void insertionSort_Test2() {
	Integer[]sortByInsertion =  new Integer[] {12,41,42,68,35,2,7,1,3,8,39,87,91,25,75,67};
	Integer[]sortByArrays =  new Integer[] {12,41,42,68,35,2,7,1,3,8,39,87,91,25,75,67};
	
	AnagramUtil.insertionSort(sortByInsertion, new intComparator());
	Arrays.sort(sortByArrays);
	assertArrayEquals(sortByInsertion,sortByArrays);
	}
	
	
	@Test
	public void insertionSort_One_Hundred_Elements() {
		Integer[]sortByInsertion = new Integer[100];
		Integer[]sortByArrays = new Integer[100];
		int count = 0;
		for(int index = 99; index>= 0; index--) {
			sortByInsertion[count] = index;
			sortByArrays[index] = index;
			count++;
		}
		AnagramUtil.insertionSort(sortByInsertion, new intComparator());
	
		assertArrayEquals(sortByInsertion,sortByArrays);
	}
	
	
	@Test (expected = NullPointerException.class)
	public void insertionSort_Array_Is_Null() {
		AnagramUtil.insertionSort(null, new intComparator());
	}
	
	@Test (expected = NullPointerException.class)
	public void insertionSort_Comparator_Is_null() {
		Integer[] array =  new Integer[] {5,4,3,2,1};
		AnagramUtil.insertionSort(array, null);
	}
	
	
	@Test
	public void InsertionSort_With_Two_ELements() {
		Integer[] arr = new Integer[] {4,-5};
		Integer[] arr2 = new Integer[] {4,-5};
		Arrays.sort(arr2);
		AnagramUtil.insertionSort(arr, new intComparator());
		assertArrayEquals(arr2,arr);
	}
	
	@Test
	public void InsertionSort_With_One_ELements() {
		Integer[] arr = new Integer[] {4};
		Integer[] arr2 = new Integer[] {4};
		AnagramUtil.insertionSort(arr, new intComparator());
		assertArrayEquals(arr2,arr);
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Test for Anagrams method
	 */
	
	@Test
	public void Two_Null_Objects() {
		assertEquals(true, AnagramUtil.areAnagrams(null, null));
	}
	
	@Test
	public void One_Null_Object_And_Otherone_Is_Not_null() {
		assertEquals(false, AnagramUtil.areAnagrams("UU", null));
	}
	
	@Test
	public void Different_Cases_With_Same_Letters() {
		assertEquals(true, AnagramUtil.areAnagrams("ChAse", "Sheca"));
	}
	
	@Test
	public void Upper_Case_Compare_To_Lower_Case() {
		assertEquals(true, AnagramUtil.areAnagrams("COMPUTER", "computer"));
	}
	
	@Test
	public void Different_Order_And_Different_Case() {
		assertEquals(true, AnagramUtil.areAnagrams("AnagramUtil", "utilANAGRAM"));
	}
	
	@Test
	public void Two_Different_Words_Return_False() {
		assertFalse(AnagramUtil.areAnagrams("Computers", "Computer"));
	}

//////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * test for getLargestAnagramGroup(String[] array)
	 */
	
	@Test
	public void Array_Equals_Null() {
		String[]arr = null;
		assertEquals(0,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
	@Test
	public void Array_Size_Equals_One() {
		assertEquals(0,AnagramUtil.getLargestAnagramGroup(new String[1]).length);
	}
	
	@Test
	public void No_Largest_Group_Found() {
		
		String[]arr = new String [] {"ssdas","sascs","zakss",
				"sdss","sgas","aaks","cas","ggs",
				"sada"};
		
		assertEquals(0,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
	
	@Test
	public void get_Largest_Group() {
		String[]arr = new String [] {"Ate","aTe","kate","Lon","Ete","Att",
				"Long","nOlg","ETA","eat"};
		assertEquals(4,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
	@Test
	public void Largest_Anagrams_In_End_Of_Array() {
		String[]arr = new String [] {"sta","Ha","uo","Aa","dElta","com","OMg","ocm"
				,"Ocm","MOc"};
		
		assertEquals(4,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
	@Test
	public void Largest_Anagrams_In_Begin_Of_Array() {
		String[] arr = new String[] {"ats","TSA","STa","GTA","ata","eTA",
				"TAs","GTP","GtR","RSt"};
		assertEquals(4,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
	
	@Test
	public void Largest_Anagrams_In_Middle_Of_Array() {
		String[] arr = new String[] {"sat","Ata","sad","Data","dog",
				"OGd","gOd","lou","LQd","dpA"};
		
		assertEquals(3,AnagramUtil.getLargestAnagramGroup(arr).length);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * test for getLargestAnagramGroup(Scanner scan)
	 */
	
	@Test 
	public void Scan_A_FILE_Not_Exist() {
		Scanner scan = null;
		assertEquals(0,AnagramUtil.getLargestAnagramGroup(scan).length);
	}
	
	
	@Test
	public void Scan_An_Empty_File() {
		Scanner scan = null;
		try {
			scan = new Scanner (new File("EmptyFile.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(0,AnagramUtil.getLargestAnagramGroup(scan).length);
	}
	
	
	@Test
	public void Scan_A_Normal_File() {
		Scanner scan = null;
		try {
			scan = new Scanner (new File("sample_word_list.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(7,AnagramUtil.getLargestAnagramGroup(scan).length);
	}
	
	@Test
	public void Scan_A_Normal_File2() {
		Scanner scan = null;
		try {
			scan = new Scanner (new File("testFile.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String[] arr = AnagramUtil.getLargestAnagramGroup(scan);
		assertEquals(2,arr.length);
		assertTrue(AnagramUtil.areAnagrams("GAnwoni", arr[0]));
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	private  class intComparator implements Comparator<Integer> {
		
		public int compare(Integer leftHandSide, Integer rightHandSide) {
			return leftHandSide.compareTo(rightHandSide);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////

}

