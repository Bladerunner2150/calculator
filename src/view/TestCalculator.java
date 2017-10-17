/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Calculator;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Test calculator
 *
 */
public class TestCalculator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random random = new Random();
		char input;
		int numberCalculations = 0;
		Calculator calculator;
		String userinput = " ";
		ArrayList<Character> bewerkingen = new ArrayList<>();
		userinput = JOptionPane.showInputDialog("Geef het aantal bewerkingen in: max 4 [*, /, +, -]");
		// direct parsen bij input 
		numberCalculations = Integer.parseInt(userinput);
		for (int i = 0; i < numberCalculations; i++) {
			userinput = JOptionPane.showInputDialog("Geef berekening in: ");
			input = userinput.charAt(0);
			bewerkingen.add(input);
		}
		int index = random.nextInt(bewerkingen.size());
		if (index == 0) {
			++index;
		}
		calculator = new Calculator();
		/* Exception in thread "main" java.lang.IllegalArgumentException: bound must be positive
	at java.util.Random.nextInt(Unknown Source)
	at view.TestCalculator.main(TestCalculator.java:45)*/
		// foutmelding bij runnen calculator.result();
		JOptionPane.showMessageDialog(null, calculator.result(2, 2, bewerkingen.get(random.nextInt(index))));
		
	}

}
