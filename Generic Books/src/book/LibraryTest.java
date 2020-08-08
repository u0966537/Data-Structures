package assignment02;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * This is jUnit test for Library.
 * 
 * @author Junjun He
 * @version 01/26/2018
 */
public class LibraryTest {
		
	 Library lib = new Library();
	 ArrayList<LibraryBook> booksCheckedOut = new ArrayList<LibraryBook>();

		/*
		 * I took our professor's code because I want to create my own test,
		 * I do not want to save those codes so it will look cleaner.
		 */
	 @Before
		public void setup() {
		 lib.addAll("Mushroom_Publishing.txt");
		
	 }
////////////////////////////////////////////////////////////////////////////////////////////

	
	@Test
	public void lookupIsbnNotIntheList() {
		
		Assert.assertNull(lib.lookup(90000190516L)); 
	}
	
	@Test
	public void lookupNoHolder() {
		
		Assert.assertNull(lib.lookup(9781843190516L));
	}
	
	@Test
	public void lookUpBookInTheList() {
		
		lib.checkout(9781843193319L,"Jun" ,01,01,2013);
		Assert.assertNotNull(lib.lookup(9781843193319L)); 
		
		lib.checkin(9781843193319L); 
	}
	
	
	@Test
	public void loopUpHoldersBook() {
		
		
		lib.checkout(9781843190004L,"Jun" ,01,01,2013);
		lib.checkout(9781843190011L, "Jun" ,01,02,2013);
		booksCheckedOut = lib.lookup("Jun");
		Assert.assertEquals(booksCheckedOut.size(),2);
		
		lib.checkin(9781843190004L);
		lib.checkin(9781843190011L);
	}
	
	
	@Test
	public void checkOutBookIsCheckedOut() {
		
		lib.checkout(9781843190936L, "jun", 01,02,2013);
		Assert.assertFalse(lib.checkout(9781843190936L, "jun", 01,02,2013));
		
		lib.checkin(9781843190936L);
	}
	
	@Test
	public void checkOutIsbnNotInTheList() {
		
		Assert.assertFalse(lib.checkout(100, "jun", 01,02,2013));
	}
	
	
	@Test
	public void checkOutBookWithAllCorrectInformation() {
		
		Assert.assertTrue(lib.checkout(9781843190936L, "jun", 01,02,2013));
		lib.checkin(9781843190936L);
	}
	
	@Test
	public void checkInBookThatAlreadyCheckedIn() {
		
		lib.checkout(9781843190936L, "jun", 01,02,2013);
		lib.checkin(9781843190936L);
		Assert.assertFalse(lib.checkin(9781843190936L));
	}
	
	@Test
	public void checkInBookWithWrongIsbn() {
		
		Assert.assertFalse(lib.checkin(11111L));
	}
	
	@Test
	public void checkInWithAllCorrect() {
		lib.checkout(9781843190936L, "jun", 01,02,2013);
		Assert.assertTrue(lib.checkin(9781843190936L));
	}
	
	@Test
	public void checkInHolderWithZeroBook() {
		Assert.assertEquals(false,lib.checkin("jun"));
	}

	@Test
	public void checkInWithWrongHolderName() {
		lib.checkout(9781843190936L, "jun", 01,02,2013);
		Assert.assertFalse(lib.checkin("j"));
	}
	
	@Test
	public void checkInWithAllCorrectInfor() {
		lib.checkout(9781843190936L, "jun", 01,02,2013);
		lib.checkout(9781843190937L, "jun", 01,02,2013);
		lib.checkout(9781843190938L, "jun", 01,02,2013);
		
		Assert.assertEquals(true, lib.checkin("jun"));
		
	}
}