package src.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly linked list by using list interface and implements iterable class.
 * 
 * @author Junjun He
 * @version 03/02/2018
 * @param
 */
public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

	private int size;
	private Node<E> head;

	/**
	 * Constructor.
	 */
	public SinglyLinkedList() {
		this.size = 0;
		this.head = null;

	}

	/**
	 * Inserts an element at the beginning of the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @param element
	 *            - the element to add
	 */
	@Override
	public void addFirst(E element) {
		head = new Node<E>(head, element);
		size++;
	}

	/**
	 * Inserts an element at a specific position in the list. O(N) for a
	 * singly-linked list.
	 * 
	 * @param index
	 *            - the specified position
	 * @param element
	 *            - the element to add
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index > size())
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0 || size == 0) {
			this.addFirst(element);
		} else {
			Node<E> current = tranverseTo(index - 1);
			current.next = new Node<E>(current.next, element);
			size++;
		}
	}

	/**
	 * Gets the first element in the list. O(1) for a singly-linked list.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if the list is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		return head.element;
	}

	/**
	 * Gets the element at a specific position in the list. O(N) for a singly-linked
	 * list.
	 * 
	 * @param index
	 *            - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index >= size())
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			return getFirst();
		} else {
			Node<E> current = tranverseTo(index);
			return current.element;
		}
	}

	/**
	 * Removes and returns the first element from the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException
	 *             if the list is empty
	 */
	public E removeFirst() throws NoSuchElementException {
		if (head == null || size == 0) {
			throw new NoSuchElementException();
		} else {
			E data = head.element;
			head = head.next;
			size--;
			return data;
		}

	}

	/**
	 * Removes and returns the element at a specific position in the list. O(N) for
	 * a singly-linked list.
	 * 
	 * @param index
	 *            - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException
	 *             if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			return this.removeFirst();
		} else {

			Node<E> current = tranverseTo(index - 1);
			E data = current.next.element;
			current.next = current.next.next;
			size--;

			return data;
		}
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 * 
	 * @param element
	 *            - the element to search for
	 */
	@Override
	public int indexOf(E element) {
		Node<E> temp = head;

		if (element == null) {
			for (int index = 0; index < size; index++) {
				if (temp.element == null) {
					return index;
				}
				temp = temp.next;
			}
		}

		else {
			for (int index = 0; index < size; index++) {
				if (temp.element.equals(element)) {
					return index;
				}
				temp = temp.next;
			}
		}
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all of the elements from this list. O(1) for a singly-linked list.
	 */
	public void clear() {

		head = null;
		size = 0;

	}

	/**
	 * Generates an array containing all of the elements in this list in proper
	 * sequence (from first element to last element). O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	public Object[] toArray() {

		if (size == 0) {
			return new Object[0];
		}

		else {
			Node<E> temp = head;
			Object[] array = new Object[size];

			for (int index = 0; index < array.length; index++) {
				array[index] = temp.element;
				temp = temp.next;
			}
			return array;
		}
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence (from
	 *         first element to last element)
	 */
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * Private helper method that helps to jump to destination.
	 * 
	 * @param index
	 * @return the element from the index.
	 */
	private Node<E> tranverseTo(int index) {
		Node<E> current = head;

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < index; i++) {

			current = current.next;
		}

		return current;

	}

	/**
	 * Private node class for singly linked list.
	 * 
	 * @author hejunjun
	 * @version 03/02/2018
	 */
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(Node<E> next, E element) {
			this.element = element;
			this.next = next;

		}
	}

	/**
	 * Private iterator classfor singly linked list.
	 * 
	 * @author hejunjun
	 * @version 03/02/2018
	 */
	private class SinglyLinkedListIterator implements Iterator<E> {
		Node<E> pointer = head;
		Node<E> current;
		private int index = 0;
		private boolean checker = false;

		@Override
		public boolean hasNext() {
			return index++ < size;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				current = pointer;
				pointer = pointer.next;
				checker = true;
				return current.element;
			}
		}

		@Override
		public void remove() {
			if (current == null || !checker)
				throw new IllegalStateException();
			current = current.next;
			head = current;
			checker = false;
			size--;
		}
	}
}
