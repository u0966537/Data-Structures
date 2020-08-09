package src.stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker && Junjun He
 * @version 02/28/2018
 */
public class BalancedSymbolChecker {

	/**
	 * Generates a message indicating whether the input file has unmatched symbols.
	 * (Use the helper methods below for constructing messages.)
	 * 
	 * @param filename
	 *            - name of the input file to check
	 * @return a message indicating whether the input file has unmatched symbols
	 * @throws FileNotFoundException
	 *             if the file does not exist
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		if (filename == null)
			throw new FileNotFoundException();
		try {
			StackLinkedList<Character> stack = new StackLinkedList<Character>();
			Scanner scan = new Scanner(new File(filename));
			int line = 0;
			boolean run = true;

			while (scan.hasNext()) {
				char[] array = scan.nextLine().toCharArray();
				line++;

				// check from index 0 to the end of a sentence.
				for (int index = 0; index < array.length; index++) {
					// next line if find a comment symbol

					if (array[index] == '/' && (index + 1) < array.length && array[index + 1] == '/')
						break;

					// stop running when find a /* symbol, will Reactivate when find */ symbol
					if (run && array[index] == '/' && (index + 1) < array.length && array[index + 1] == '*') {
						run = false;
						index = index + 2; // since current index = / and index+1 =* then jump to next two indexs
					}
					
					
					if (!run && array[index] == '*' && (index + 1) < array.length && array[index + 1] == '/')
						run = true;
					
					
					//when counters " sign, find until the close sign for it.
					if (run && array[index] == '"') {
						index++;
						while (index < array.length) {
							//check to see if there is \" or not.
							if (array[index] == '"' && array[index - 1] != '\\') {
								index++;
								break;
							}
							index++;
						}
					}
					
					//when counters ' sign, find until the close sign for it.
					if (run && array[index] == '\'') {
						index++;
						//check to see if there is \' or not.
						while (index < array.length) {
							if (array[index] == '\'' && array[index - 1] != '\\') {
								index++;
								break;
							}
							index++;
						}
					}

					if (run) {
						// if {, (, [ then push
						if (array[index] == '{' || array[index] == '(' || array[index] == '[')
							stack.push(array[index]);
						// else if },),] then do other job.
						else if (array[index] == '}' || array[index] == ']' || array[index] == ')') {
							// if nothing in the stack, then the symbol should be removed
							if (stack.size() == 0) {
								scan.close();
								return unmatchedSymbol(line, index + 1, array[index], ' ');
							}
							// else if something in the stack and they matched or they dont match.
							else if (stack.size() > 0)
								if (array[index] == exchangeSymbol(stack.peek()))
									stack.pop();
								else {
									scan.close();
									return unmatchedSymbol(line, index + 1, array[index], exchangeSymbol(stack.peek()));
								}
						}
					}
				}
			}
			if (!run) {
				scan.close();
				return unfinishedComment();
			}
			if (!stack.isEmpty()) {
				char symbol = stack.pop();
				scan.close();
				return unmatchedSymbolAtEOF(exchangeSymbol(symbol));
			} else {
				scan.close();
				return allSymbolsMatch();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}

	}

	/**
	 * Use this error message in the case of an unmatched symbol.
	 * 
	 * @param lineNumber
	 *            - the line number of the input file where the matching symbol was
	 *            expected
	 * @param colNumber
	 *            - the column number of the input file where the matching symbol
	 *            was expected
	 * @param symbolRead
	 *            - the symbol read that did not match
	 * @param symbolExpected
	 *            - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected "
				+ symbolExpected + ", but read " + symbolRead + " instead.";
	}

	/**
	 * Use this error message in the case of an unmatched symbol at the end of the
	 * file.
	 * 
	 * @param symbolExpected
	 *            - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Use this error message in the case of an unfinished comment (i.e., a file
	 * that ends with an open /* comment).
	 * 
	 * @return the error message
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Use this message when no unmatched symbol errors are found in the entire
	 * file.
	 * 
	 * @return the success message
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}

	/**
	 * Private helper method Changes facing right symbol to facing left direction
	 * symbol For example, { will be change to }, ( will change to ).
	 * 
	 * @param symbol
	 * @return facing left direction symbol
	 */
	private static char exchangeSymbol(char symbol) {
		if (symbol == '{')
			return '}';
		else if (symbol == '(')
			return ')';
		return ']';

	}
}