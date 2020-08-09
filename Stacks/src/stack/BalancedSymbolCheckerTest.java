package src.stack;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * This is test class for balanced symbol checker class.
 * 
 * @author Junjun He
 * @version 03/02/2018
 */
public class BalancedSymbolCheckerTest {

	@Test
	public void class1() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.",
				BalancedSymbolChecker.checkFile("Class1.java"));
	}

	@Test
	public void class2() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.",
				BalancedSymbolChecker.checkFile("Class2.java"));
	}

	@Test
	public void class3() throws FileNotFoundException {
		assertEquals("No errors found. All symbols match.", BalancedSymbolChecker.checkFile("Class3.java"));
	}

	@Test
	public void class4() throws FileNotFoundException {
		assertEquals("ERROR: File ended before closing comment.", BalancedSymbolChecker.checkFile("Class4.java"));
	}

	@Test
	public void class5() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.",
				BalancedSymbolChecker.checkFile("Class5.java"));
	}

	@Test
	public void class6() throws FileNotFoundException {
		assertEquals("No errors found. All symbols match.", BalancedSymbolChecker.checkFile("Class6.java"));
	}

	@Test
	public void class7() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.",
				BalancedSymbolChecker.checkFile("Class7.java"));
	}

	@Test
	public void class8() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.",
				BalancedSymbolChecker.checkFile("Class8.java"));
	}

	@Test
	public void class9() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.",
				BalancedSymbolChecker.checkFile("Class9.java"));
	}

	@Test
	public void class10() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.",
				BalancedSymbolChecker.checkFile("Class10.java"));
	}

	@Test
	public void class11() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.",
				BalancedSymbolChecker.checkFile("Class11.java"));
	}

	@Test
	public void class12() throws FileNotFoundException {
		assertEquals("No errors found. All symbols match.", BalancedSymbolChecker.checkFile("Class12.java"));
	}

	@Test
	public void class13() throws FileNotFoundException {
		assertEquals("No errors found. All symbols match.", BalancedSymbolChecker.checkFile("Class13.java"));
	}

	@Test
	public void class14() throws FileNotFoundException {
		assertEquals("No errors found. All symbols match.", BalancedSymbolChecker.checkFile("Class14.java"));
	}

}
