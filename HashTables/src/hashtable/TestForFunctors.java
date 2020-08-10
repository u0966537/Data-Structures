import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
/**
 * This class will test a functor by calculating the number of collisions
 * @author hejunjun
 * @version 03-29-2018
 */
public class TestForFunctors {
	
	QuadProbeHashTable list = new QuadProbeHashTable(0, new MediocreHashFunctor());
	ArrayList<String> words; 
	/*
	 * new GoodHashFunctor()
	 * new MediocreHashFunctor()
	 * new BadHashFunctor()
	 */

	
	@Test
	public void checkSize() {
//		words = readWordsFromFile("words.txt");
//		for(String word : words) {
//			list.add(word);
//		}
		

		//15522		14857
		//1667733	6548112
		//16611925	105241464
		for(int i = 0 ; i <=10000; i++) {
			list.add(""+i);
		}
		System.out.println(list.getCollisions());
	}
	
	
	/**
	 * This method will scan the a file that contains lots of string words.
	 * 
	 * @param filename from user.
	 * @return a list of the words
	 */
	private static ArrayList<String> readWordsFromFile(String filename)
	{
		ArrayList<String> list = new ArrayList<String>();
		try 
		{
			Scanner input = new Scanner(new FileReader(filename));

			while(input.hasNext()) {
				list.add(input.next());
			}
			input.close();
		} 
		catch (FileNotFoundException e) 
		{	
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	
	
	
	
	
	
	
}

