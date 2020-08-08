package assignment04;


import java.util.Random;
import org.junit.Test;

public class AnagramUtilTiming {

	@Test
	public void Timing_areAnagrams_Method() {
		long startTime = 0,  stopTime = 0, total =0;
		
		for (int n = 100; n <= 1000; n += 100) {
			String firstString = "";
			String secondString = "";
					
			String letters = "abcdefghijklmnopqrstuvwxyz";
					
			Random rng = new Random();
	
			// since i< n , then each time n gets bigger, the size of word will 
			// be bigger as well.
			for (int i = 0; i < n; i++) {
				firstString += letters.charAt(rng.nextInt(letters.length()-1));
				secondString += letters.charAt(rng.nextInt(letters.length()-1));
			}

			for (int i = 0; i < 100; i++) {
				startTime = System.nanoTime(); //start timing
						
				AnagramUtil.areAnagrams(firstString, secondString);
						
				stopTime = System.nanoTime(); // stop timing
				total +=stopTime - startTime; // store result			
			}
			// when use please comment this out.
//			System.out.println(n + "\t" +  total / 1000 );
			}
	}
	
	
	@Test
	public void Timing_getLargestAnagramsGroup_Method() {
		long startTime = 0,  stopTime = 0, total =0;
		
		for (int n = 100; n <= 1000; n += 100) {
			String String = "";
			
			String[] array = new String[n];	
			String letters = "abcdefghijklmnopqrstuvwxyz";
					
			Random rng = new Random();
	
			// Test n elements in an array.
			for (int i = 0; i < n; i++) {
				// since i< n , then each time n gets bigger, the size of word will 
				// be bigger as well.
				for (int j = 0; j < 14; j++) {
					String += letters.charAt(rng.nextInt(25));
				}
				
				array[i] = String;
				//reset for next use, otherwise it will get bigger and bigger
				String = ""; 
			}
					
			for (int i = 0; i < 100; i++) {
				startTime = System.nanoTime(); //start timing
	
				AnagramUtil.getLargestAnagramGroup(array);
				
				stopTime = System.nanoTime(); // stop timing
				total +=stopTime - startTime; // store result
					
			}
			// when use please comment this out.
//			System.out.println(n + "\t" +  total / 1000 );
			}
	}
	
	
	
	
}
