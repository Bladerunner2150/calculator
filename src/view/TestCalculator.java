/**
 * 
 */
package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Calculator;
import util.Generator;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Test calculator
 *
 */
public class TestCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		char input;
		int numberCalculations = 0;
		Calculator calculator;
		String userinput = " ";
		ArrayList<Character> bewerkingen = new ArrayList<>();

		userinput = JOptionPane.showInputDialog("Geef het aantal bewerkingen in: max 4 [*, /, +, -]");
		numberCalculations = Integer.parseInt(userinput);
		numberCalculations = Integer.parseInt(userinput);
		
		// al deze code ga ik nog proberen zoveel mogelijk in een klasse te steken en uit de test te halen
		for (int i = 0; i < numberCalculations; i++) {
			userinput = JOptionPane.showInputDialog("Geef berekening in: ");
			input = userinput.charAt(0);
			if (bewerkingen.isEmpty() == true) {
				bewerkingen.add(input);
			} else {

				// If- statement om te controleren of ze niet twee keer dezelfde bewerking ingeven
				if (bewerkingen.contains(input) == true) {

					JOptionPane.showMessageDialog(null, "Geef ander bewerking in ");
					// eentje aftrekken bij "i" omdat de for-loop anders stopt
					i--;
				}
				else {
					bewerkingen.add(input);
				}

			}
		}

		int index = random.nextInt(bewerkingen.size());
		/*if (index == 0) {
			++index;
		}*/
		calculator = new Calculator();
		double testgetal = random.nextDouble(); 

		JOptionPane.showMessageDialog(null, calculator.result(3, 2, bewerkingen.get(index)));
		JOptionPane.showMessageDialog(null, Generator.NegatieveBoodschap());
		JOptionPane.showMessageDialog(null, testgetal);

	}
}
