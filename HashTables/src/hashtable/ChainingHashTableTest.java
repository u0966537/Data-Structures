import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ChainingHashTableTest {
	
ChainingHashTable list = new ChainingHashTable(100, new MediocreHashFunctor());
	
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
		int size = list.size();
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
		assertTrue(size != list.size());
	}
	
	@Test
	public void checkSizeAfteraddAllWithSomeValuesInTable() {
		ArrayList<String> array = new ArrayList<String>();
		int size = list.size();
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
		assertTrue(size != list.size());
	}
	
}
