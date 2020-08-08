package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This is a binary search class that uses array to store each 
 * elements. Using binary search for inserting, removing, searching
 * through the array.  The complexity of this idea costs O(log(n))
 * 
 * @author He, Junjun
 * @version 02/01/2018
 */

public class BinarySearchSet<E> implements SortedSet<E> {
	
	private E[] array;
	private int size;
	private Comparator<? super E> comparator;
	
	
	@SuppressWarnings("unchecked")
	public BinarySearchSet() {
		
		this.array =  (E[]) new Object [4];
		this.size = 0;
		comparator = null;
		
	}
	
	@SuppressWarnings("unchecked")
	public BinarySearchSet (Comparator<? super E> comparator){
		
		this.array =  (E[]) new Object [4];
		this.size = 0;
		this.comparator = comparator;
	}
	
	
	/**
	 * @return The comparator used to order the elements in this set, or null if
	 *         this set uses the natural ordering of its elements (i.e., uses
	 *         Comparable).
	 */
	public Comparator<? super E> getComparator() {
		
		if(this.comparator == null ) {
			return null;
		}
		
		return this.comparator;
	}

	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public E first() throws NoSuchElementException {
		if(this.isEmpty() ) {
			throw new NoSuchElementException();
		}
		
		return this.array[0];
	}

	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public E last() throws NoSuchElementException {
		if(this.isEmpty() ) {
			throw new NoSuchElementException();
		}
		
		return this.array[size-1];
	}

	/**
	 * Adds the specified element to this set if it is not already present and
	 * not set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	public boolean add(E element) {
		
		if(element == null) {
			throw new NullPointerException();
		}
		
		if( !this.contains(element) ) {
			if(this.size  == array.length-1) {
				 this.array= this.resize(this.array.length*2);
			}
			
			int index = this.binarySearch(element);
			
			//move things back to create space for the new item.
			for( int i = size ;  i >index ;  i --) {
				  array[i] =array[i-1];
			}
		
			array[index] = element;
			this.size++;
			return true;
		}
		
		return false;
	}
	

	/**
	 * Adds all of the elements in the specified collection to this set if they
	 * are not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	public boolean addAll(Collection<? extends E> elements) {
		boolean check = false;
		for(E element : elements) {
			check = this.add(element);
		}
		return check;
	}

	/**
	 * Removes all of the elements from this set. The set will be empty after
	 * this call returns.
	 */
	public void clear() {
		
		// set all the elements into null.
		for( int i  = 0; i < this.size ; i++) {
			array[i] = null;
		}
	
		this.size  = 0;
	}

	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	public boolean contains(Object element) {
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(!this.isEmpty() ) {
			int index = this.binarySearch(element);
			
			/*
			 * Check if it is null or not null first.
			 * If it is null, then it will throw null pointer exception when comparing 
			 * to other element.
			 */
			if(array[index] != null && array[index].equals(element) ) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	public boolean containsAll(Collection<?> elements) {
		for(Object element : elements) {
			if(!this.contains(element)) {
				return false;
			}
		}
		return true; 		
		}

	/**
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() {
		if(size ==0) {
			return true;
		}
		
		return false;
	}


	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	public boolean remove(Object element) {
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(size != 0 && this.contains(element) ) {
			
				int index = this.binarySearch(element);

				// move everything forward to take over the element's index
				for(int i = index; i < size -1 ; i++) {
					array[i] = array[i+1];
				}
				
				size--;
				return true;
		}
	
		return false;
		
	}
	/**3
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	public boolean removeAll(Collection<?> elements) {
		boolean check = false;
		for (Object element: elements) {
			check = remove(element);
		}
		return check;
	}

	/**
	 * @return the number of elements in this set
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	public Object[] toArray() {
		
		return this.resize(size);
	}
	
	
	/**
	 * This is a private helper method that helps to resize the array
	 * @param takes in the new length for the array.
	 */
	
	private E[] resize( int length) {
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object [length];
		
		for(int i=0; i < size;i++) {
			newArray[i] = this.array[i];
		}
		
		return newArray;
		
	}
	
	/**
	 * Private helper method that uses binary search idea
	 * to find the index of the element.
	 * 
	 * If the element does not exist in the set, then it will 
	 * return the index for the element to store.
	 * 
	 * @param element
	 * @return the index of the element.
	 */
	@SuppressWarnings("unchecked")
	private int binarySearch(Object element) {
		int low = 0;
		int middle;
		int high = size-1;
		
		if(this.size ==0) {
			return 0;
		}
		
		/*
		 * If the comparator is null, then use the natural ordering
		 * which is  comparable.
		 * If comparator is not null, then we will use comparator for ordering.
		 */
		if(this.comparator == null) {
			
			while(true) {
				middle = (low + high) /2;
				
				if(((Comparable<E>)  (E)element).compareTo( array[middle]) <0) {
					high = middle -1;
					if(low > high) {
						return middle;  
						} 
					}
				
				else if(((Comparable<E>) (E) element).compareTo( array[middle]) >0) {
					low = middle +1;
					if(low > high) {
						return middle+1;  
						} 
					}
				
				else {
					return middle; }
				
				}
		}
		
		// else use comparator for ordering.
		else {

			while(true) {
				
				middle = (low + high) /2;
				
				if(this.comparator.compare((E) element, array[middle]) <0) {
					high = middle -1;
					if(low > high) {
						return middle;  
						} 
					}
				
				else if(this.comparator.compare((E) element, array[middle])>0) {
					low = middle +1;
					if(low > high) {
						return middle+1;  
						} 
					}
				
				else {
					return middle;  }
			}	
		}
	}
}
