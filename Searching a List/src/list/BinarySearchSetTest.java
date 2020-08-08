import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;


/**
 * This is a test class for BinarySearchSet.
 * 
 * @author He, Junjun
 * @version 02/01/2018
 */

public class BinarySearchSetTest {


	BinarySearchSet<Integer> list = new BinarySearchSet<Integer>();
	public class IntegerComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
		
	}
	
	@Test
	public void timing_For_Add() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();

		for(int exp = 10; exp <= 21; exp++) { // This is used as the exponent to calculate the size of the set.
			int size = (int) Math.pow(2, exp); 
			
			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			
			for (int iter = 0; iter < 21; iter++) {
				// SET UP!
			
				for(int i = 0; i < size; i++) {
					long start = System.nanoTime();
					set.add(i);
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
			
			
//				long start = System.nanoTime();
//				set.add(size +1);
//				long stop = System.nanoTime();
//				totalTime += stop - start;
//				set.remove(size+1);

			}
			double averageTime = totalTime / (double)21;
			System.out.println(size + "\t" + averageTime); // print to console
		
	
		}

	
	}
	
	public void  timing_For_Contain() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		Random random = new Random();
		

		for(int exp = 10; exp <= 21; exp++) { // This is used as the exponent to calculate the size of the set.
			int size = (int) Math.pow(2, exp); 
			
			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			
			for (int iter = 0; iter < 25; iter++) {
				// SET UP!
			
				for(int i = 0; i < size; i++) {
					set.add(i);
				}
				int findElement = random.nextInt(size); // This gets me a random int between 0 and size;
				
				// TIME IT!
				long start = System.nanoTime();
				set.contains(findElement);
				long stop = System.nanoTime();
				totalTime += stop - start;

			}
			double averageTime = totalTime / (double)25;
			System.out.println(size + "\t" + averageTime); // print to console
		
		
	}
		
		
	}
	
	
	


////////	////////	////////	////////	////////	////////	////////	////////	////////	////////	////////	
	
	/*
	 *  Get Comparator method test
	 */
	
	@Test
	public void getComparator_With_Not_Null_Result() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( new IntegerComparator());
		
		assertTrue(set.getComparator()!=null);
		
	}
	
	@Test
	public void getComparator_With_Null_Result() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		assertTrue(set.getComparator()==null);
		
	}
	
////////////////	////////	////////	////////	////////	////////	////////	////////	////////	////////			
	
	/*
	 *  get first and last Test
	 */
	
	@Test(expected = NoSuchElementException.class)
	public void get_First_With_Size_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		
		set.first();
	
		//check size if its 0 size or not.
		assertEquals( 0,set.size()); 
		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void get_Last_With_Size_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		
		set.last();
		
		//check size if its 0 size or not.
		assertEquals(0,set.size());
		
	}
	
	
	@Test
	public void get_First_And_Last_With_OneHundred_Elements() {
		BinarySearchSet<Object> set = new BinarySearchSet<Object>();
		for(int i = 100; i > 0 ; i--) {
			set.add(i);
		}
		
		assertEquals(1,set.first()); //get the first element
		assertEquals(100,set.last());  // get the last element
		assertEquals(100, set.size());  // check size
		
	}

/////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 *  add method test
	 */
	
	@Test (expected = NullPointerException.class)
	public void add_Add_One_Null_Element() {
		
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		set.add(null);
	}
	
	@Test
	public void add_All_Are_Duplicated_Element() {
		
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i = 10; i > 0 ; i--) {
			set.add(i);
		}
		
		assertEquals(false, set.add(1));
		assertEquals(false, set.add(2));
		assertEquals(false, set.add(3));
		assertEquals(false, set.add(4));
		
	}
	
	@Test
	public void add_One_Thousand_Non_Duplicated_Elements() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i = 1_000; i > 0 ; i--) {
			set.add(i);
		}
		
		assertEquals(1_000, set.size());
		assertEquals((Integer)1, set.first());
		assertEquals((Integer)1_000, set.last());
	}	

////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * addAll method test
	 */

	
	@Test(expected = NullPointerException.class)
	public void addAll_Add_One_Null_Element() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 5 ; i > 0 ; i--) {
			arr.add(i);
			if(i % 4 ==0) {
				arr.add(null);
			}
		}
		
		set.addAll(arr);
		
	}
	
	@Test
	public void addAll_All_Are_Duplicated_Element() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i = 5; i > 0; i-- ) {
			set.add(i);
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i =5 ; i>0;i--) {
			arr.add(i);
		}
		
		assertEquals(false,set.addAll(arr));
	}
	
	@Test
	public void addAll_Add_One_Duplicated_Element() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i = 5; i > 0; i-- ) {
			set.add(i);
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i =10 ; i>4;i--) {
			arr.add(i);
		}
		
		assertEquals(false,set.addAll(arr));
	}
	
	@Test
	public void addAll_Add_One_Thousand_Non_Duplicated_Element() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 1000; i <1030; i++) {
			set.add(i);
		}
		
		for(int i = 0 ; i < 1_000 ; i++) {
			arr.add(i);
		}
		
		assertEquals(true,set.addAll(arr));
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	* clear method test
	*/
	
	@Test
	public void clear_Size_One_Hundred_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i=0; i< 100; i++) {
			set.add(i);
		}
		
		assertEquals(100,set.size()); // check size after elements added
		
		set.clear();
		assertEquals(0,set.size()); //check size after clear.
		assertEquals(true, set.isEmpty()); //check is empty
	}
	
	@Test
	public void clear_Size_Zero_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
	
		assertEquals(0,set.size()); // check size after elements added
		
		set.clear();
		assertEquals(0,set.size()); //check size after clear.
		assertEquals(true, set.isEmpty()); // check is empty
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
 	* contain method test
	*/
	
	@Test (expected = NullPointerException.class)
	public void contain_One_Null_Element() {
		
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		set.contains(null);
	}
	
	
	@Test
	public void contain_When_Size_Is_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		assertEquals(false, set.contains("2"));
	}
	
	
	@Test
	public void contain_Check_Elements_That_Already_Exist() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i = 0; i< 10; i++) {
			set.add(i);
		}
		
		for(int i = 9; i<=	 0; i++) {
			assertEquals(true, set.contains(i));
		}
	}
	
	@Test
	public void contain_Elements_Not_In_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		assertEquals(false, set.contains(5));
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
   /*
 	* containAll method test
	*/	

	@Test(expected = NullPointerException.class)
	public void containAll_One_Null_Element() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			set.add(i);
			arr.add(i);
			if(i%5 ==0) {
				arr.add(null);
			}	
		}
		set.containsAll(arr);	
	}
	
	@Test
	public void containAll_When_Size_Is_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<5; i++) {
			arr.add(i);
		}
		
		assertEquals(false, set.containsAll(arr));
	}
	
	@Test
	public void containAll_Check_Elements_That_Already_Exist() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i< 10; i++) {
			set.add(i);
			arr.add(i);
		}
		
			assertEquals(true, set.containsAll(arr));
	}
	
	@Test
	public void containAll_Elements_Not_In_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		arr.add(0);
		arr.add(1);
		arr.add(2);
		
		assertEquals(false, set.containsAll(arr));
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * isEmpty method test
	 */		
	public void isEmpty_size_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		assertEquals(true, set.isEmpty());
	}
	
	public void isEmpty_size_three() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		set.add(1);
		set.add(2);
		set.add(3);
		
		assertEquals(false, set.isEmpty());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
 	* remove method test
	*/	

	@Test (expected = NullPointerException.class)
	public void remove_On_Null_Element() {
		
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		set.add(1);
		set.add(2);
		set.add(3);
		
		set.remove(1);
		set.remove(null);
	}
	
	@Test
	public void remove_When_Size_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		assertEquals(false, 	set.remove(1));
		
		
	}
	
	@Test
	public void remove_Remove_Element_Not_In_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i =2; i< 5; i++) {
			set.add(i);
		}
		//remove an element not in the set
		assertEquals(true, set.remove(2));
		//it shouldn't exist after it's removed by the code above.
		assertEquals(false, set.remove(2));
		assertEquals(2, set.size());
	}
	
	
	@Test 
	public void remove_Remove_Elements_From_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		for(int i =1; i<= 20; i++) {
			set.add(i);
		}
		
		set.remove(1);
		set.remove(2);
		set.remove(3);
		set.remove(4);
		set.remove(5);
		
		assertEquals((Integer)6 , set.first());  // check first element after removed
		assertEquals(20-5, set.size());  // check size after removed
		assertEquals((Integer)20 , set.last());  //check last element after removed
		
		
		set.remove(19);
		set.remove(20);
		
		assertEquals((Integer)6 , set.first());  // check first element after removed
		assertEquals(20-5-2, set.size());  // check size after removed
		assertEquals((Integer)18 , set.last());  //check last element after removed
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * removeAll method test
	 */	
	
	@Test (expected = NullPointerException.class)
	public void removeAll_On_Null_Element() {
		
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		set.add(1);
		set.add(2);
		set.add(3);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(null);
	
		set.removeAll(arr);
	}
	
	@Test
	public void removeAll_When_Size_Zero() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		
		assertEquals(false, 	set.removeAll(arr));
		
	}
	
	
	@Test
	public void removeAll_Remove_Element_Not_In_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i =15; i< 20; i++) {
			set.add(i);
		}
		
		arr.add(15);
		arr.add(19);
		arr.add(21);
		
		//remove an element not in the set
		assertEquals(false, set.removeAll(arr));
		//15 and 19 are removed, 21 not exists, wont be removed
		assertEquals(3, set.size());
	}
	
	
	@Test 
	public void removeAll_Remove_Elements_From_Set() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i =1; i<= 20; i++) {
			set.add(i);
			if(i%2 ==0) {
				arr.add(i);
			}
		}
		
		assertEquals(true, set.removeAll(arr));
		
		assertEquals((Integer)1 , set.first());  // check first element after removed
		assertEquals(20/2, set.size());  // check size after removed
		assertEquals((Integer)19 , set.last());  //check last element after removed
			
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
 	* toArray method test
	*/	
	
	
	
	@Test
	public void ToArray_With_Hand_Made_Elements() {
		Object[] arr = new Object[] {"1","2","3","4","5","6"};
		String s ="";
		BinarySearchSet<String> set = new BinarySearchSet<String>();
		for(int i = 1; i<= 6 ; i++) {
			set.add(s+i);
		}
		
		assertArrayEquals(arr, set.toArray());
	}
	
	@Test
	public void ToArray_With_One_Thousand_Element() {
		Integer[]arr =  new Integer[1000];
		for(int i = 0; i<1000 ; i++) {
			arr[i] = i;
		}
	
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		
		for(int i = 0; i< 1000 ; i++) {
			set.add(i);
		}

		assertArrayEquals(arr, set.toArray());
	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		/*
 		* final test
		*/	

	@Test
	public void Test_Add_Contain_Remove_Together() {
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>( );
		
		for(int i = 10_000; i> 0; i--) {
			set.add(i);   // adding elements into set
		}
		
		assertEquals(10_000, set.size());
	
		for(int i = 1; i<= 10_000; i++) {
			assertEquals(true,set.contains(i));   // checking contain.
		}
		
		for(int i= 1 ; i<= 100 ; i ++) {
			set.remove(i);      //removing elements from the set
		}
		
		assertEquals(10_000-100, set.size()); // check size after removed
		assertEquals((Integer)101, set.first());  //check first element after removed
		assertEquals((Integer)10_000, set.last()); // check last element;
		
		
		//remove rest of elements in the list
		for(int i = 101; i <= 10_000 ; i++) {
			set.remove(i);
		}
		assertEquals(0, set.size()); 
		
	}
	
}
