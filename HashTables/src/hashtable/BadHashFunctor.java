/**
 * This is bad hash functor for hash table class.
 * 
 * @author hejunjun
 * @version 03/29/2018
 */
public class BadHashFunctor implements HashFunctor
{

	@Override
	public int hash(String item) 
	{
		/*
		 * This functor will be so bad if the datas' length are the same,
		 * or close to each other. 
		 * For example, hash 6 characters name into hash table,
		 * then this will be so slow to run the program.
		 */
		return item.length();
	}

}
