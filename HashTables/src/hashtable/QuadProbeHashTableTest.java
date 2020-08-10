import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class QuadProbeHashTableTest {
	
QuadProbeHashTable list = new QuadProbeHashTable(0, new MediocreHashFunctor());
	
	/*
	 * new GoodHashFunctor()
	 * new MediocreHashFunctor()
	 * new BadHashFunctor()
	 */
	@Before
	public void setUp() {
		for(int index =0; index <=1000; index++) {
			list.add(index+"");
		}
	}
	
	@Test
	public void checkSize() {
		assertTrue(list.size()==1001);
	}
	
	@Test
	public void checkSizeAfterClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void clearOnAEmptyList() {
		list.clear();
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void AddItemsAfterClear() {
		list.clear();
		list.add("CSDDS");
		list.add("WBZNaoq");
		list.add("OAJAUDH");
		list.add("OAJAAA");
		list.add("209asda");
		list.add("sa887JA");
		assertTrue(list.size()==6);
	}
	
	@Test
	public void checkItemsIntheList() {
		for(int index =0; index <=1000; index++) {
			assertTrue(list.contains(index+""));
		}
	}
	
	@Test
	public void checkItemsNoExistIntheList() {
		for(int index =0; index <=1000; index++) {
			assertFalse(list.contains((index+1*1010)+""));
		}
	}
	
	@Test
	public void AddandCheckContain() {
		for(int index = 2000;index<=3000;index++ ) {
			assertTrue(list.add(index+""));
			assertTrue(list.contains(index+""));
		}
	}
	
	@Test
	public void TestPrime() throws IOException {
		assertTrue(list.isPrime(17));
		assertTrue(list.isPrime(947));
		assertTrue(list.isPrime(941));
		assertFalse(list.isPrime(940));
		assertFalse(list.isPrime(938));
		assertTrue(list.isPrime(397));
		assertFalse(list.isPrime(398));
		assertFalse(list.isPrime(399));
		
		/*
		 * This will write 0 - 2000 prime number into a file.
		 * So you can compare it with online prime numbers. 
		 */
		try (PrintWriter output = new PrintWriter(new FileWriter("PrimeNumber.txt"))) {
			for(int i = 0; i<=2000; i++) {
				if(list.isPrime(i)) {
					output.write(i+"");
					output.println();
				}
			}
		}
	}
	
	@Test
	public void TestGetNextLargestPrime()  {
		assertTrue(list.nextLargestPrime(24)==29);
		assertTrue(list.nextLargestPrime(967)==967);
		assertTrue(list.nextLargestPrime(952)==953);
		assertTrue(list.nextLargestPrime(0)==2);
		assertTrue(list.nextLargestPrime(1)==2);
		assertTrue(list.nextLargestPrime(54)==59);
		assertTrue(list.nextLargestPrime(63)==67);
	}
	
	
	@Test
	public void addAllAndContainAll() {
		QuadProbeHashTable list = new QuadProbeHashTable(0, new GoodHashFunctor());
		ArrayList<String> array = new ArrayList<String>();
		
		array.add("A");
		array.add("B");
		array.add("C");
		
		assertTrue(list.addAll(array));
		assertTrue(list.containsAll(array));
		assertTrue(list.size() == array.size());
	}
	
	@Test
	public void addAllValuesAlreadyInTable() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4");
		
		assertFalse(list.addAll(array));
	}
	
	@Test
	public void addAllSomeValuesAlreadyInTable() {
		ArrayList<String> array = new ArrayList<String>();
		QuadProbeHashTable list = new QuadProbeHashTable(0, new GoodHashFunctor());
		int size = list.size();
		
		list.add("2");
		list.add("A");
		list.add("B");
		list.add("1");
		list.add("0");
		list.add("9");
		list.add("100");
		
		array.add("1");
		array.add("2");
		array.add("A");
		array.add("B");
		array.add("C");
		array.add("0");
		array.add("9");
		array.add("100");
		
		assertTrue(list.addAll(array));
		assertTrue(list.size()!=size);
	}
	
	@Test
	public void containAllValuesAlreadyInTable() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("1");
		array.add("2");
		array.add("A");
		array.add("B");
		array.add("C");
		array.add("0");
		array.add("9");
		array.add("100");
		
		list.addAll(array);
		assertTrue(list.containsAll(array));
	}
	
	@Test
	public void containAllVSomeValuesAlreadyInTable() {
		ArrayList<String> array = new ArrayList<String>();
		QuadProbeHashTable list = new QuadProbeHashTable(0, new GoodHashFunctor());
		
		array.add("1");
		array.add("2");
		array.add("A");
		array.add("B");
		array.add("C");
		array.add("0");
		array.add("9");
		array.add("100");
		
		list.add("A");
		list.add("C");
		
		assertFalse(list.containsAll(array));
	}
	
	@Test
	public void checkSizeAfteraddAllWithSomeValuesInTable() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("1");
		array.add("2");
		array.add("A");
		array.add("B");
		array.add("C");
		array.add("0");
		array.add("9");
		array.add("100");
		
		list.addAll(array);
		assertTrue(list.size()==1001+3);
	}
}