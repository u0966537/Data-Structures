import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Matrix class
 * 
 * @author Miriah Meyer & Junjun He
 * @version January 11, 2018
 */
public class MatrixJUnitTester {

	Matrix twoByTwo, twoByThree,threeByTwo,threeByThree,twoByTwoResult;
	/*Initialize some matrices we can play with for every test!*/
	
	@Before
	public void setup() {
		
		twoByTwo= new Matrix( new int[][] {
			{ 6,8},
			{ 2,3}});
		
		twoByThree = new Matrix(new int[][]
                 {{4, 5},
				 {3, 2},
				 {1, 1}});
		
		threeByTwo = new Matrix(new int[][]{
			     {1, 2, 3},
				 {2, 5, 6}});
		
		
		threeByThree = new Matrix(new int[][]{
			 {1,2,3},
			 {4,5,6},
			 {7,8,9}});
		
		
		
		// this is the known correct result of multiplying threeBytwo by twoByThree
		twoByTwoResult = new Matrix(new int[][]
									{{13, 12},
									 {29, 26}});
		
	
	}
	
	@Test
	public void timesWithBalancedDimensions() {
		Matrix matrixProduct = threeByTwo.times(twoByThree);
		Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
	}
	
	
	@Test 
	public void timesWithTwoCompatibleMatrix() {
		Matrix result = threeByTwo.times(twoByThree);
		Assert.assertArrayEquals(result.data,twoByTwoResult.data);
		
	}

	
	
	/*
	 * 
	 * Test for times method.
	 * 
	 */
	@Test
	public void timesWithCompatibleMatrix() {
		Matrix result = new Matrix (new int[][] {
			{30,36,42},
			{66,81,96},
			{102,126,150}});
		
		Assert.assertEquals(result, threeByThree.times(threeByThree));
	}
	
	@Test
	public void timesWithInCompatibleMatrix() {
		Assert.assertEquals(null,twoByTwo.times(twoByThree));
	}
	
	@Test
	public void twoByThreeTimesOneByTwo() {
		Matrix oneByTwo = new Matrix( new int[][] {
			{1},
			{2}});
		Matrix result = new Matrix(new int[][] {
			{14},
			{7},
			{3}});
		Assert.assertTrue(result.equals(twoByThree.times(oneByTwo)));
	}	
	
	@Test
	public void timesWithSameDimensions() {
		Matrix m1 = new Matrix( new int[][] {
			{2,3},
			{2,3}});
		
		Matrix result = new Matrix( new int[][]{
			{10,15},
			{10,15}});
		Assert.assertEquals(result, m1.times(m1));
	}
	
	
	
	
	
	/*
	 * 
	 * Test for plus method.
	 * 
	 */

	@Test
	public void threeByTwoPlusThreeByTwo() {
		Matrix rightHandMatrix =  new Matrix(new int[][] {
			{2,3,3},
			{3,4,4}});
		Matrix result = new Matrix (new int[][] {
			{3,5,6},
			{5,9,10}});
		
		Assert.assertEquals(result,threeByTwo.plus(rightHandMatrix));
	}
	
	
	@Test
	public void threeByThreePlusThreeByThree() {
		Matrix rightHandMatrix =  new Matrix(new int[][] {
			{2,3,5},
			{3,4,5},
			{5,6,7}});
		Matrix result = new Matrix( new int[][] {
			{3,5,8},
			{7,9,11},
			{12,14,16}});
		Assert.assertEquals(result,threeByThree.plus(rightHandMatrix));
	}
	
	@Test
	public void plusWithInCompatibleMatrix() {
		Matrix rightHandMatrix = new Matrix(new int[][] {
			{2,3,6},
			{4,5,7}	});
		Assert.assertEquals(null,twoByTwo.plus(rightHandMatrix));
	}
	
	@Test
	public void plusWithTwoInCompatibleMatrix2() {
		Matrix rightHandMatrix = new Matrix(new int[][] {
			{2},
			{4}	});
		Assert.assertEquals(null,threeByThree.plus(rightHandMatrix));
	}
	
	
	
	
	/*
	 * 
	 * Test for equal method.
	 * 
	 */
	
	@Test 
	public void twoByTwoEqualToTwoByTwo(){
		Matrix compareTarget = new Matrix( new int[][]  {
			{ 6,8},
			{ 2,3}});
		Assert.assertTrue(compareTarget.equals(twoByTwo));
		
	}
	
	@Test
	public void twoBytwoNotEqualToOtherTwoByTwo() {
		Matrix compareTarget = new Matrix( new int[][]  {
			{ 1,2},
			{ 3,4}});
		Assert.assertFalse(compareTarget.equals(twoByTwo));
	}
	
	@Test
	public void threeByThreeEqualToThreeByThree() {
		Matrix compareTarget = new Matrix ( new int[][] {
			 {1,2,3},
			 {4,5,6},
			 {7,8,9}});
		Assert.assertTrue(compareTarget.equals(threeByThree));
	}
	
	@Test
	public void twoDifferentDimensionsMatrix() {
		Assert.assertFalse(threeByThree.equals(threeByTwo));
	}
	
	
	
	
	/*
	 * 
	 *     Tests for ToString Method
	 *
	 */
	
	
	@Test
	public void twoByTwoToString() {
		String resultString = "6 8" + "\n" + "2 3"+"\n" ;
		Assert.assertEquals(resultString, twoByTwo.toString());
	}

	@Test
	public void threeByThreeToString() {
		
		String resultString = "1 2 3"+ "\n"+"4 5 6"+ "\n" +"7 8 9" +"\n";
		Assert.assertEquals(resultString, threeByThree.toString());
	}

	
	@Test 
	public void oneNumberInMatrixToString() {
		Matrix one = new Matrix( new int[][] {{2}}); 
		String result = "2" + "\n";
		Assert.assertEquals(result, one.toString());
	}

	
}
