/**
 * 
 */
package model;

import java.util.Date;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Generate exercise statistics
 *
 */
public class OutStats
{
	private Date dateOfTest;
	private int duration;
	private String selections;
	private int finalResult;
	private String separator = System.lineSeparator();

	/**
	 * @return the dateOfTest
	 */
	public Date getDateOfTest()
	{
		return dateOfTest;
	}

	/**
	 * @param dateOfTest
	 *            the dateOfTest to set
	 */
	public void setDateOfTest(Date dateOfTest)
	{
		this.dateOfTest = dateOfTest;
	}

	/**
	 * @return the duration
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	/**
	 * @return the selections
	 */
	public String getSelections()
	{
		return selections;
	}

	/**
	 * @param selections
	 *            the selections to set
	 */
	public void setSelections(String selections)
	{
		this.selections = selections;
	}

	/**
	 * @return the finalResult
	 */
	public int getFinalResult()
	{
		return finalResult;
	}

	/**
	 * @param finalResult
	 *            the finalResult to set
	 */
	public void setFinalResult(int finalResult)
	{
		this.finalResult = finalResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Stats:" + separator + separator + "Date and time of test: " + getDateOfTest() + separator
				+ "Duration of test: " + getDuration() + separator + "Selected properties: " + getSelections()
				+ separator + "Final result: " + getFinalResult();
	}

}
