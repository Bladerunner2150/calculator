/**
 * 
 */
package model;

/**
 * @author Bart
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Methods for calculating
 *
 */
public class Calculator
{
	private static final char ADD = '+';
	private static final char SUBTRACT = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDE = '/';
	private static final char POWER = '^';
	
	private double add(final double first, final double second)
	{
		return first + second;
	}
	
	private double subtract(final double first, final double second)
	{
		return first - second;
	}
	
	private double multiply(final double first, final double second)
	{
		return first * second;
	}
	
	private double divide(final double first, final double second)
	{
		if (second != 0)
		{
			return first / second;
		}
		return 0;
	}

	public double result(final double first, final double second, final char operator)
	{
		double finalResult = 0;
		if (operator == ADD)
		{
			finalResult = add(first, second);
		}
		if (operator == SUBTRACT)
		{
			finalResult = subtract(first, second);
		}
		if (operator == MULTIPLY)
		{
			finalResult = multiply(first, second);
		}
		if (operator == DIVIDE)
		{
			finalResult = divide(first, second);
		}
		if (operator == POWER)
		{
			finalResult = Math.pow(first, second);
		}
		return finalResult;
	}
	
}
