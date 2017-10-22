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
	private long duration;
	private String selections;
	private String finalResult;
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
	public long getDuration()
	{
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(long duration)
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
	public String getFinalResult()
	{
		return finalResult;
	}

	/**
	 * @param finalResult
	 *            the finalResult to set
	 */
	public void setFinalResult(String finalResult)
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
				+ "Duration of test: " + getDuration() + " seconds" + separator + "Selected properties: " + separator
				+ getSelections() + separator + "Final result: " + getFinalResult();
	}

}
