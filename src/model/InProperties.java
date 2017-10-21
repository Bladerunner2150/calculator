/**
 * 
 */
package model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Properties of calculator exercises
 *
 */
public class InProperties
{
	private int rangeOfNumbers;
	private boolean positiveNumbers;
	private boolean naturalNumbers;
	private List<Character> calculations /*= Arrays.asList('+', '-', '/', '*', '^')*/;
	private int multiplyTable;
	private int numberOfExercises;

	/**
	 * @return the rangeOfNumbers
	 */
	public int getRangeOfNumbers()
	{
		return rangeOfNumbers;
	}

	/**
	 * @param rangeOfNumbers
	 *            the rangeOfNumbers to set
	 */
	public void setRangeOfNumbers(int rangeOfNumbers)
	{
		this.rangeOfNumbers = rangeOfNumbers;
	}

	/**
	 * @return the positiveNumbers
	 */
	public boolean isPositiveNumbers()
	{
		return positiveNumbers;
	}

	/**
	 * @param positiveNumbers
	 *            the positiveNumbers to set
	 */
	public void setPositiveNumbers(boolean positiveNumbers)
	{
		this.positiveNumbers = positiveNumbers;
	}

	/**
	 * @return the naturalNumbers
	 */
	public boolean isNaturalNumbers()
	{
		return naturalNumbers;
	}

	/**
	 * @param naturalNumbers
	 *            the naturalNumbers to set
	 */
	public void setNaturalNumbers(boolean naturalNumbers)
	{
		this.naturalNumbers = naturalNumbers;
	}

	/**
	 * @return the calculations
	 */
	public List<Character> getCalculations()
	{
		return calculations;
	}

	/**
	 * @param calculations
	 *            the calculations to set
	 */
	public void setCalculations(List<Character> calculations)
	{
		this.calculations = calculations;
	}

	/**
	 * @return the multiplyTable
	 */
	public int getMultiplyTable()
	{
		return multiplyTable;
	}

	/**
	 * @param multiplyTable
	 *            the multiplyTable to set
	 */
	public void setMultiplyTable(int multiplyTable)
	{
		this.multiplyTable = multiplyTable;
	}

	/**
	 * @return the numberOfExercises
	 */
	public int getNumberOfExercises()
	{
		return numberOfExercises;
	}

	/**
	 * @param numberOfExercises
	 *            the numberOfExercises to set
	 */
	public void setNumberOfExercises(int numberOfExercises)
	{
		this.numberOfExercises = numberOfExercises;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Range: " + getRangeOfNumbers() + "| Positive numbers only:" + isPositiveNumbers()
				+ "| Natural numbers only:" + isNaturalNumbers() + "| Calculations: " + getCalculations() + "| Multiply table: "
				+ getMultiplyTable() + "| Number of exercises: " + getNumberOfExercises();
	}
	
	

}
