/**
 * 
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

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
	private int cijfersNaKomma;
	private List<Character> calculations;
	private int numberOfExercises;
	private String separator = System.lineSeparator();

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
	 * @return the cijfersNaKomma
	 */
	public int getCijfersNaKomma()
	{
		return cijfersNaKomma;
	}

	/**
	 * @param cijfersNaKomma
	 *            the cijfersNaKomma to set
	 */
	public void setCijfersNaKomma(int cijfersNaKomma)
	{
		this.cijfersNaKomma = cijfersNaKomma;
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
	
	public void writePropertiesFile(InProperties properties)
	{
		Properties props = new Properties();
		props.setProperty("range", String.valueOf(properties.getRangeOfNumbers()));
		props.setProperty("positive", String.valueOf(properties.isPositiveNumbers()));
		props.setProperty("natural", String.valueOf(properties.isNaturalNumbers()));
		props.setProperty("decimals", String.valueOf(properties.getCijfersNaKomma()));
		String calcs = "";
		for (Character character : properties.getCalculations())
		{
			calcs += character;
		}
		props.setProperty("calc", calcs);
		props.setProperty("numberofexercises", String.valueOf(properties.getNumberOfExercises()));
		try
		{
			FileOutputStream output = new FileOutputStream("calculatorDefault.properties");
			props.store(output, "Opgeslagen selecties");
			output.close();

		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Range: " + getRangeOfNumbers() + separator + "Positive numbers only: " + isPositiveNumbers() + separator
				+ "Natural numbers only: " + isNaturalNumbers() + separator + "Numbers after decimal point: "
				+ getCijfersNaKomma() + separator + "Calculations: " + getCalculations() + separator
				+ "Number of exercises: " + getNumberOfExercises();
	}

}
