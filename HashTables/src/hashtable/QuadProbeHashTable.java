import java.util.Collection;

/**
 * This class will hash a string into hash table by using the idea of quadratic
 * probing.
 * 
 * @author hejunjun
 * @version 03/29/2018
 */
public class QuadProbeHashTable implements Set<String> {
	private String[] array;
	private int capacity, size, orginalCapacity;
	private HashFunctor functor;
	private int collision;

	/**
	 * Constructor, array's length will always be a prime number.
	 * 
	 * @param capacity
	 *            - array size
	 * @param functor
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor) {
		if (functor == null) {
			throw new NullPointerException();
		}

		if (!isPrime(capacity)) {
			capacity = nextLargestPrime(capacity);
		}

		array = new String[capacity];
		this.capacity = orginalCapacity = capacity;
		size = 0;
		this.functor = functor;
		collision=0;
	}

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	@Override
	public boolean add(String item) {
		if (item == null) {
			throw new NullPointerException();
		}

		if (((double)size / (double)capacity) >= 0.5) {
			resize();
		}

		if (!contains(item)) {
			int index = hash(item, array);
			array[index] = item;
			size++;
			return true;
		}
		return false;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 */
	@Override
	public boolean addAll(Collection<? extends String> items) {
		int size = this.size();
		for (String item : items) {
			this.add(item);
		}
		// size did not change, means did not add anything
		if(size == this.size()) 
			return false;
		// size changed, means the set changed.
		else 
			return true;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		array = new String[orginalCapacity];  // set to orginal, or just removing elements.
		capacity = orginalCapacity;
		size = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item
	 *            - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 */
	@Override
	public boolean contains(String item) {
		if (item == null) {
			throw new NullPointerException();
		}

		int index = hash(item, array);
		if (array[index] == null) {
			return false;
		}

		return true;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends String> items) {
		for (String item : items) {
			// if one of the elements not in the tree, return false
			if (!this.contains(item)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Private helper method. 
	 * This method will determine a number is prime or not.
	 * @param number from user
	 * @return true if it is a prime number,false otherwise.
	 */
	public boolean isPrime(int number) {
		// It's public right now so that we can test it in the test class.
		
		// the smallest number is 2, so if user trying to send a number
		// that's least than 2, just return false;
		if(number < 2 ) return false;
		
		/*
		 * formula of calculating prime in code.
		 * I did not write all of this code. I used ideas from Wikipedia, and modifitied 
		 * it to have a better performent. 
		 */
		for (int count = 2; count <= number / 2; count++)   {
			if (number % count == 0) {
				return false;
		    }
		}
		return true;
	}
	
	/**
	 * Privat helper method.
	 * This method will the next nearest prime number.
	 * @param number from user.
	 * @return nearest prime number if user's number isn't a prime, 
	 * otherwise return the orignalnumber.
	 */
	public int nextLargestPrime (int number) {
		// It's public right now so that we can test it in the test class.
		
		// smallest prime number is 2.
		if(number <=2)
			return 2;
		
		int nextPrimeNumber = number;
		
		// if the number from user isn't a prime, then add 1 to the number
		// and check if it's prime or not, until the it's prime number.
		while(!isPrime(nextPrimeNumber)) {
			nextPrimeNumber++;
		}
		return nextPrimeNumber;
	}
	
	
	/**
	 * Private helper method.
	 * This method will resize the array, and it will hash exist elements 
	 * into a new array.
	 */
	private void resize() {
		//increase size.
		capacity = nextLargestPrime(capacity*2);
		String[] newArray = new String[capacity];
		
		// find not-null element, hash it, and put it into new array.
		for(int index = 0; index < array.length ; index++) {
			if(array[index]!=null) {
				int pos = hash(array[index],newArray);
				newArray[pos] = array[index];
			}
		}
		// set the new array into our array varaible. 
		array = newArray;
	}
	
	/**
	 * Private helper method.
	 * This class will hash a value into a seat of the value.
	 * If the seat is already taken by others, then use the
	 * idea of quadratic probing.
	 * @param item
	 * @param array
	 * @return
	 */
	private int hash(String item,String[] array) {
		int index =  Math.abs((functor.hash(item))% capacity);
		// if the index is null, that means it found it.
		if(array[index]==null) {
			return index;
		}
		// else, the program will run quadratic probling until find the empty seat.
		else {
			int count = 1;
			int position = index;
			while (array[position] != null) {
				collision ++;
				if(array[position].equals(item)){
					return position;
				}
				position = Math.abs((index +(count * count++)) % capacity);
				
			}
			return position;
		}
		
	}
	
	public int getCollisions(){
		return collision;
	}
}
