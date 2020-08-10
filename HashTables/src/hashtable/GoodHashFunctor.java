/**
 * This is good hash functor for hash table class.
 * 
 * @author hejunjun
 * @version 03/29/2018
 */
public class GoodHashFunctor  implements HashFunctor {
	
	/**
	 * The idea is from : Book Name called:"Data Structures and Algorithm Analysis in Java"
	 * Author: Mark Allen Weiss
	 * 
	 * I read his idea and modified a little to performent a better level.
	 */
	@Override
	public int hash(String item) {
		int hash =0 ;
		for(int i =0; i<item.length();i++) {
			hash = 37 * hash+ item.charAt(i)*37;
		}
		return hash;
		
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
	
}
