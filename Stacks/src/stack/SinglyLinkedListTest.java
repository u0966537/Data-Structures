package src.stack;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test singly linked list.
 * 
 * @author Junjun He
 * @version 03/02/2018
 */
public class SinglyLinkedListTest {

	SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
	SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
	Iterator<Integer> iter;

	@Before
	public void setUp() {
		for (int index = 0; index <= 10; index++) {
			list2.add(index, index);
		}
	}

	@Test
	public void AddingSomeRandomNumbers() {
		list.addFirst(2);
		list.add(0, 3);
		list.add(0, 55);
		list.add(1, 12);
		list.add(4, 10);
		list.add(5, 11);
		assertEquals((Integer) 55, list.get(0));
		assertEquals((Integer) 12, list.get(1));
		assertEquals((Integer) 3, list.get(2));
		assertEquals((Integer) 2, list.get(3));
		assertEquals((Integer) 10, list.get(4));
	}

	@Test
	public void AddFirstTenElements() {
		int count = 0;
		for (int index = 10; index <= 0; index--) {
			assertEquals((Integer) index, list2.get(count));
			count++;
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void AddingNegativeIndex() {
		list.add(-1, 10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void AddingOutOfBouneIndex() {
		list.add(10000, 1000);
	}

	@Test
	public void getFirstElement() {
		assertEquals((Integer) 0, list2.getFirst());
	}

	@Test
	public void getIndexElement() {
		assertEquals((Integer) 5, list2.get(5));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getNegativeIndex() {
		list2.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getOutOfBouneIndex() {
		list2.get(100000);
	}

	@Test(expected = NoSuchElementException.class)
	public void getWhenListEmpty() {
		list.getFirst();
	}

	@Test
	public void getFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		String s = "";
		for (int index = 5; index <= 10; index++) {
			list.add(index - 5, s + index);
		}
		assertEquals(list.getFirst(), "5");
	}

	@Test
	public void get_Random_Index() {
		int pos = 0;
		for (int index = 0; index < 42; index++) {
			list.add(index, index);
			if (index % 33 == 0) {
				pos = index;
			}
		}
		assertEquals(list.get(33), (Integer) pos);
	}

	@Test
	public void removeFirst() {
		assertEquals((Integer) 0, list2.remove(0));
	}

	@Test
	public void removeIndexElement() {
		assertEquals((Integer) 5, list2.remove(5));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removingNegativeIndex() {
		list2.remove(-100);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removingOutOfBouneIndex() {
		list2.remove(100000);
	}

	@Test(expected = NoSuchElementException.class)
	public void removingEmptyList() {
		list.removeFirst();
	}

	@Test
	public void removeFirst_Adding_While_Deleting() {
		int count = 10;
		while (count >= 0) {
			list.add(0, 100);
			list.removeFirst();
			assertEquals(list.size(), 0);
			count--;
		}
	}

	@Test
	public void IndexOfExist() {
		assertEquals(5, list2.indexOf(5));
	}

	@Test
	public void IndexOfNotExist() {
		assertEquals(-1, list2.indexOf(123));
	}

	@Test
	public void sizeNotZero() {
		assertEquals(11, list2.size());
	}

	@Test
	public void sizeZero() {
		assertEquals(0, list.size());
	}

	@Test
	public void IsNotEmpty() {
		assertEquals(false, list2.isEmpty());
	}

	@Test
	public void IsEmpty() {
		assertEquals(true, list.isEmpty());
	}

	@Test
	public void clearNotEmptyList() {
		list2.clear();
		assertEquals(0, list2.size());
	}

	@Test
	public void clearEmptyList() {
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void toArrayWithEmptyList() {
		Object[] array = list.toArray();
		assertEquals(0, array.length);
	}

	@Test
	public void toArrayWithNotEmptyList() {
		Object[] array = list2.toArray();
		assertTrue(array.length != 0);
	}

	@Test
	public void testIteratorRemove() {

		iter = list2.iterator();

		iter.next();
		iter.remove();

		assertEquals(4, list2.size());
	}

	@Test
	public void testIteratorHasNext() {
		iter = list2.iterator();
		for (int count = 0; count <= 10; count++) {
			assertTrue(iter.hasNext());
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testIteratorRemoveTwoTimes() {
		iter = list2.iterator();
		iter.next();
		iter.remove();
		iter.remove();
	}

	@Test(expected = NoSuchElementException.class)
	public void testIteratorRemoveWithoutNext() {
		iter = list2.iterator();
		iter.remove();
	}

	@Test
	public void removeAndReturnFirstELement() {
		for (int i = 10; i <= 100; i++) {
			list.add(i - 10, i);
		}
		System.out.println(list.removeFirst() + "\t" + list.getFirst());
	}

	@Test
	public void add_some_numbers() {
		for (int i = 0; i <= 100; i++) {
			list.addFirst(i);
		}
		list.clear();

		Object[] array = list.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
