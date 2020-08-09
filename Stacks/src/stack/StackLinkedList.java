package src.stack;
import java.util.NoSuchElementException;
/**
 * This is a stack that made by using singly linked list.
 * 
 * @author Junjun He
 * @version 03/02/2018
 * @param <E>
 */
public class StackLinkedList<E> implements Stack<E> {
	private SinglyLinkedList<E> list;
	
	
	public StackLinkedList() {
		list =new SinglyLinkedList<E>();	
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		list.clear();
	}

	/**
	 * Returns true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}


	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			return list.getFirst();
		}
	}


	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return list.removeFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) {
		list.addFirst(element);		
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return list.size();
	}

}
