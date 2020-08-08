package assignment02;

import java.util.GregorianCalendar;


/**
 * This class will contains all the datas inside of this class.
 * 
 * @author Junjun He
 * @version 01/26/2018
 */
public class LibraryBook extends Book{
	
	
	private String holder;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title){
		super(isbn, author, title); 
		
		this.dueDate = null;
		this.holder = null;
	}
	/**
	 * @return the holder of the book.
	 */
	public String getHolder() {
		
		return this.holder;
	}
	
	
	/**
	 * @return the due date of the book.
	 */
	public GregorianCalendar getDueDate() {
		
		return this.dueDate;
	}
	
	/**
	 * This method will set the condition of the book into check-in status.
	 * 
	 * When check-in:
	 * Holder and due date should set to null,
	 * checked condition should set to false;
	 */
	public void checkIn() {
		this.holder = null;
		this.dueDate = null;
	}
	
	
	/**
	 * This method will set the condition of the book into check-out status.
	 * 
	 * Holder and due date are needed when checking a book out,
	 * checked status should change to true.
	 * @param holder  
	 * @param dueDate
	 */
	public void checkOut(String holder, GregorianCalendar dueDate) {
		this.holder =  holder;
		this.dueDate = dueDate;
	}
	
}