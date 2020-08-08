import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is jUnit test for LibraryGeneric.
 * 
 * @author Junjun He
 * @version 01/26/2018
 */

public class LibraryGenericTest {
	 LibraryGeneric<PhoneNumber> lib = new LibraryGeneric<PhoneNumber>();
	 ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = new ArrayList<LibraryBookGeneric<PhoneNumber>>();
	 PhoneNumber phone = new PhoneNumber("111-111-1111");
	 PhoneNumber	 phone2 = new PhoneNumber("000-000-0000");
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
		
		lib.checkout(9781843193319L,phone ,01,01,2013);
		Assert.assertNotNull(lib.lookup(9781843193319L)); 
		
		lib.checkin(9781843193319L); 
	}
	
	
	@Test
	public void loopUpHoldersBook() {
		
		
		lib.checkout(9781843190004L,phone ,01,01,2013);
		lib.checkout(9781843190011L, phone ,01,02,2013);
		booksCheckedOut = lib.lookup(phone);
		Assert.assertEquals(booksCheckedOut.size(),2);
		
		lib.checkin(9781843190004L);
		lib.checkin(9781843190011L);
	}
	
	
	@Test
	public void checkOutBookIsCheckedOut() {
		
		lib.checkout(9781843190936L, phone, 01,02,2013);
		Assert.assertFalse(lib.checkout(9781843190936L, phone, 01,02,2013));
		
		lib.checkin(9781843190936L);
	}
	
	@Test
	public void checkOutIsbnNotInTheList() {
		
		Assert.assertFalse(lib.checkout(100, phone, 01,02,2013));
	}
	
	
	@Test
	public void checkOutBookWithAllCorrectInformation() {
		
		Assert.assertTrue(lib.checkout(9781843190936L, phone, 01,02,2013));
		lib.checkin(9781843190936L);
	}
	
	@Test
	public void checkInBookThatAlreadyCheckedIn() {
		
		lib.checkout(9781843190936L, phone, 01,02,2013);
		lib.checkin(9781843190936L);
		Assert.assertFalse(lib.checkin(9781843190936L));
	}
	
	@Test
	public void checkInBookWithWrongIsbn() {
		
		Assert.assertFalse(lib.checkin(11111L));
	}
	
	@Test
	public void checkInWithAllCorrect() {
		lib.checkout(9781843190936L, phone, 01,02,2013);
		Assert.assertTrue(lib.checkin(9781843190936L));
	}
	
	@Test
	public void checkInHolderWithZeroBook() {
		Assert.assertEquals(false,lib.checkin(phone));
	}

	@Test
	public void checkInWithWrongHolderName() {
		lib.checkout(9781843190936L, phone, 01,02,2013);
		Assert.assertFalse(lib.checkin(phone2));
	}
	
	@Test
	public void checkInWithAllCorrectInfor() {
		lib.checkout(9781843190936L, phone, 01,02,2013);
		lib.checkout(9781843190937L, phone, 01,02,2013);
		lib.checkout(9781843190938L, phone, 01,02,2013);
		
		Assert.assertEquals(true, lib.checkin(phone));
	}
	
	@Test
	public void TestSortByAuthorWhenSizeZero() {
		LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
		Assert.assertEquals(0, lib2.getOrderedByAuthor().size());
	}
	
	@Test
	public void TestSortByAuthorWithCorrectInfor() {
		LibraryGeneric<PhoneNumber> SortedByAuthor = new LibraryGeneric<PhoneNumber>();
		LibraryGeneric<PhoneNumber> unsorted = new LibraryGeneric<PhoneNumber>();
		SortedByAuthor.add(9781843190004L,"Anthony J D Burns", "Demogorgon Rising");
		SortedByAuthor.add(9781843190349L,"Esme Ellis","Pathway Into Sunrise");
		SortedByAuthor.add(9781843190998L, "Helen K Barker", "Iceni");
		SortedByAuthor.add(9781843190479L,"Moyra Caldecott", "Weapons of the Wolfhound");
		
		unsorted.add(9781843190479L,"Moyra Caldecott", "Weapons of the Wolfhound");
		unsorted.add(9781843190004L,"Anthony J D Burns", "Demogorgon Rising");
		unsorted.add(9781843190998L, "Helen K Barker", "Iceni");
		unsorted.add(9781843190349L,"Esme Ellis","Pathway Into Sunrise");
		
		Assert.assertEquals(SortedByAuthor.getOrderedByAuthor(),unsorted.getOrderedByAuthor());
		
	}
	
	@Test
	public void TestSortByAuthorWhenAuthorNameIsSame() {
		
		LibraryGeneric<PhoneNumber> SortedByAuthor = new LibraryGeneric<PhoneNumber>();
		LibraryGeneric<PhoneNumber> unsorted = new LibraryGeneric<PhoneNumber>();
		
		SortedByAuthor.add(9781843190004L,"Anthony J D Burns", "Into Sunrise");
		SortedByAuthor.add(9781843190349L,"Anthony J D Burns"," Demogorgon Rising");
		SortedByAuthor.add(9781843190998L, "Helen K Barker", "Iceni");
		SortedByAuthor.add(9781843190479L,"Moyra Caldecott", "AirPlane");
		SortedByAuthor.add(9781843190479L,"Moyra Caldecott", "Weapons of the Wolfhound");
		
		unsorted.add(9781843190479L,"Moyra Caldecott", "Weapons of the Wolfhound");
		unsorted.add(9781843190479L,"Moyra Caldecott", "AirPlane");
		unsorted.add(9781843190998L, "Helen K Barker", "Iceni");
		unsorted.add(9781843190349L,"Anthony J D Burns"," Demogorgon Rising");
		unsorted.add(9781843190004L,"Anthony J D Burns", "Into Sunrise");
		
		Assert.assertEquals(SortedByAuthor.getOrderedByAuthor(),unsorted.getOrderedByAuthor());
	}
	
	@Test
	public void TestGetOverDueDateWithZeroSize() {
		LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
		Assert.assertEquals(0, lib2.getOverdueList(02,12, 2013).size());
	}
	
	@Test
	public void TestGetOverDueDateWithCorrectInfor() {
		LibraryGeneric<PhoneNumber> sorted = new LibraryGeneric<PhoneNumber>();
		LibraryGeneric<PhoneNumber> unsorted = new LibraryGeneric<PhoneNumber>();
		
		unsorted.checkout(9781843190004L, phone, 01,01,2013);
		unsorted.checkout(9781843190005L, phone, 01,02,2015);
		unsorted.checkout(9781843190006L, phone, 01,03,2012);
		unsorted.checkout(9781843190007L, phone, 01,03,2011);
		
		sorted.checkout(9781843190007L, phone, 01,03,2011);
		sorted.checkout(9781843190006L, phone, 01,03,2012);
		sorted.checkout(9781843190004L, phone, 01,01,2013);
		sorted.checkout(9781843190005L, phone, 01,02,2015);
		
		Assert.assertEquals(sorted.getOverdueList(01, 01, 2018), unsorted.getOverdueList(01, 01, 2018));
		
	}
	
	@Test
	public void TestGetOverDueDateWithNone() {
		LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
		lib2.checkout(9781843190005L, phone, 11,22,2017);
		lib2.checkout(9781843190005L, phone, 10,21,2017);
		
		Assert.assertEquals(0, lib2.getOverdueList(01, 01, 2016).size());
		
	}
	
}