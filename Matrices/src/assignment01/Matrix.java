package assignment01;

/**
 * Implementation of a 2D Mathematical Matrix
 * 	- includes functionality for multiplying and adding matrices
 * 
 * @author Miriah Meyer & Junjun He
 * @version January 11, 2018
 */
public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	/**
	 * Constructor with data for new matrix (automatically determines dimensions)
	 * @param data -- a 2D integer array of data used to initialize the new Matrix object
	 */
	public Matrix(int data[][])
	{
		numRows = data.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0) {
			numColumns = 0;
		} else {
			numColumns = data[0].length; // d[0] is the first 1D array
		}
		this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) { 
			for(int j=0; j < numColumns; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	/**
	 * Determines whether two objects are equivalent Matrices
	 * @param other -- an object to compare to
	 * @return -- true if the Matrices are equivalent and false otherwise (or if the second object isn't a Matrix)
	 */
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object other)
	{
		// what are the conditions when two matrix are equaivalent.
		if(!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix matrix = (Matrix)other; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		
		/*
		 * Loop through the matrixes, at the same position, if both of them 
		 * equal to each other, then set total++.
		 * After the loops, if total matches row * columns(total index in the matrix ),
		 * then that means they are equal to each other.
		 */
		if(this.numRows  == matrix.numRows && this.numColumns == matrix.numColumns) {
			for(int rowPointer = 0; rowPointer < this.numRows ; rowPointer++) {
				for(int columnPointer = 0; columnPointer< this.numColumns; columnPointer++) {
					 if(this.data[rowPointer][columnPointer] != matrix.data[rowPointer][columnPointer]) {
						return false;
					 }
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * Converts the Matrix object into a string representation of its data
	 * @return -- string representation of the matrix
	 */
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{

		String result = "";
		/*
		 * Looping through the matrixes, the "column loop" should end before it comes 
		 * to the last item in the row. Then add the last item into the result 
		 * and start a new line by using "\n".
		 *  
		 */
		for(int rowPointer  = 0; rowPointer < this.numRows ; rowPointer++) {
			for(int columnPointer = 0 ; columnPointer < this.numColumns-1 ; columnPointer++) {
				result += this.data[rowPointer][columnPointer] + " ";
			}
			result+= this.data[rowPointer][this.numColumns-1]+"\n";
		
		}
		
		return result; 
	}
	
	/**
	 * Multiplies two matrix objects resulting in a new product matrix
	 * @param matrix -- the right hand side matrix to be multiplied
	 * @return -- the resulting matrix of the multiplication
	 */
	public Matrix times(Matrix matrix)
	{
	
		/*
		 * If they are compatible, then use two three loops to check and add them 
		 * up and store the result into a destination. 
		 */
		Matrix leftHand = this;
		if(leftHand.numColumns != matrix.numRows) {
			return null;
		}
		
		else {
			Matrix result = new Matrix(new int[leftHand.numRows][matrix.numColumns]);
			for (int rowPointer = 0; rowPointer < this.numRows; rowPointer++)
	            for (int columnPointer = 0; columnPointer < matrix.numColumns; columnPointer++)
	                for (int k = 0; k < leftHand.numColumns; k++)
	                    result.data[rowPointer][columnPointer] += (leftHand.data[rowPointer][k] * matrix.data[k][columnPointer]);
			
			return result;
		}
	}
	
	/**
	 * Adds two matrix objects together
	 * @param matrix -- the right hand side matrix to be added
	 * @return -- the resulting matrix of the addition
	 */
	public Matrix plus(Matrix matrix)
	{
		
		/*
		 * If two of them are having the same number of rows and columns
		 * that means they are compatible.
		 * Then just add them into a new matrix by using two loops.
		 * 
		 */
		Matrix leftHand = this;
		if(leftHand.numRows != matrix.numRows || leftHand.numColumns != matrix.numColumns)
			return null;
		
		else {
			Matrix result = new Matrix(new int[leftHand.numRows][leftHand.numColumns]);
			for(int rowPointer = 0; rowPointer < result.numRows; rowPointer ++ ) 
				for(int columnPointer = 0; columnPointer < result.numColumns; columnPointer++)
					result.data[rowPointer][columnPointer] = leftHand.data[rowPointer][columnPointer] 
							+ matrix.data[rowPointer][columnPointer];
			return result;
		}
	}
}
