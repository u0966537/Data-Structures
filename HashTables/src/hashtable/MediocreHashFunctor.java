/**
 * This is medium hash functor for hash table class.
 * 
 * @author hejunjun
 * @version 03/29/2018
 */
public class MediocreHashFunctor  implements HashFunctor {
	
	@Override
	public int hash(String item) 
	{
		
			int hash =0 ;
			char[] letters = item.toCharArray();
			for(char letter : letters) {
				hash = hash+  letter;
			}
			return hash;
	}
}
