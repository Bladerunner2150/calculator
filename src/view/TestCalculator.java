/**
 * 
 */
package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Calculator;
import model.InProperties;
import model.OutStats;
import util.Generator;
import util.Score;

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
		String userinput = " ";

		int numberCalculations = 0;
		ArrayList<Character> bewerkingen = new ArrayList<>();

		Calculator calculator = new Calculator();
		InProperties properties = new InProperties();
		OutStats stats = new OutStats();
		Generator generator = new Generator();
		Score score = new Score();

		userinput = JOptionPane.showInputDialog("Geef het aantal bewerkingen in: max 4 [*, /, +, -]");
		numberCalculations = Integer.parseInt(userinput);

		// al deze code ga ik nog proberen zoveel mogelijk in een klasse te steken en
		// uit de test te halen

		List<String> rangtelwoorden = Arrays.asList("eerste", "tweede", "derde", "vierde");
		for (int i = 0; i < numberCalculations; i++)
		{
			userinput = JOptionPane.showInputDialog("Geef " + rangtelwoorden.get(i) + " bewerking in: ");
			input = userinput.charAt(0);
			if (bewerkingen.isEmpty() == true)
			{
				bewerkingen.add(input);
			} 
			else
			{

				// If- statement om te controleren of ze niet twee keer dezelfde bewerking
				// ingeven
				if (bewerkingen.contains(input) == true)
				{

					JOptionPane.showMessageDialog(null, "Geef andere bewerking in ");
					// eentje aftrekken bij "i" omdat de for-loop anders stopt
					i--;
				} else
				{
					bewerkingen.add(input);
				}
			}
		}
		properties.setCalculations(bewerkingen);

		userinput = JOptionPane.showInputDialog("Tot welk getal wil je rekenen?");
		properties.setRangeOfNumbers(Integer.parseInt(userinput));

		userinput = JOptionPane.showInputDialog("Wil je alleen met positieve getallen rekenen? (j/n)");
		input = Character.toLowerCase(userinput.charAt(0));
		if (input == 'j')
		{
			properties.setPositiveNumbers(true);
		} else
		{
			properties.setPositiveNumbers(false);
		}

		userinput = JOptionPane.showInputDialog("Wil je alleen met gehele getallen rekenen? (j/n)");
		input = Character.toLowerCase(userinput.charAt(0));
		if (input == 'j')
		{
			properties.setNaturalNumbers(true);
		} else
		{
			properties.setNaturalNumbers(false);
		}

		if (!properties.isNaturalNumbers())
		{
			userinput = JOptionPane.showInputDialog("Hoeveel cijfers na de komma?");
			properties.setCijfersNaKomma(Integer.parseInt(userinput));
		}

		if (bewerkingen.contains('*')) // test om te kijken of vermenigvuldigingen in lijst bewerkingen zitten
		{
			userinput = JOptionPane.showInputDialog("Wil je ook een tafel berekenen? (j/n)");
			input = Character.toLowerCase(userinput.charAt(0));
			if (input == 'j')
			{
				do
				{
					userinput = JOptionPane
							.showInputDialog("Welke tafel wil je berekenen? Geef een cijfer van 1 tot 9");
					properties.setMultiplyTable(Integer.parseInt(userinput));
				} while (properties.getMultiplyTable() < 1 || properties.getMultiplyTable() > 9);
			}
		}

		userinput = JOptionPane.showInputDialog("Hoeveel oefeningen wil je maken?");
		properties.setNumberOfExercises(Integer.parseInt(userinput));

		// deze code maakt oefeningen aan, maar moet nog verplaatst worden naar
		// Generator class en opgekuist worden (in Score moeten getal1 en getal2 nog weg
		// misschien?)

		long startTime = System.currentTimeMillis();
		Date currentDate = new Date();
		stats.setDateOfTest(currentDate);
		for (int i = 0; i < properties.getNumberOfExercises(); i++)
		{
			int index = random.nextInt(properties.getCalculations().size());
			char calculation = properties.getCalculations().get(index);
			score.setBewerking(calculation);
			double randomgetal1 = generator.RandomGetal(properties.getRangeOfNumbers(), properties.isPositiveNumbers(),
					properties.isNaturalNumbers(), properties.getMultiplyTable(), properties.getNumberOfExercises());
			score.setGetal1(randomgetal1); // is dit wel nodig? Zie comment hierboven
			double randomgetal2 = generator.RandomGetal(properties.getRangeOfNumbers(), properties.isPositiveNumbers(),
					properties.isNaturalNumbers(), properties.getMultiplyTable(), properties.getNumberOfExercises());
			score.setGetal2(randomgetal2); // is dit wel nodig? Zie comment hierboven
			double result = calculator.result(randomgetal1, randomgetal2, calculation);
			score.setOplossing(result);
			userinput = JOptionPane.showInputDialog("Oefening " + (i+1) + "/" + properties.getNumberOfExercises()
					+ ": Hoeveel is " + randomgetal1 + calculation + randomgetal2 + " ?");
			double answer = Double.parseDouble(userinput);
			score.setUserGetal(answer);

			// onderstaande regels kunnen misschien vereenvoudigd worden, misschien met
			// factory of zo, of getters en setters?
			score.AddScore(score);
			JOptionPane.showMessageDialog(null, score.compareScore(score));
		}
		long elapsedTimeInSeconds = (System.currentTimeMillis() - startTime) / 1000;
		stats.setDuration(elapsedTimeInSeconds); // dit eventueel nog omzetten naar minuten en seconden
		stats.setSelections(properties.toString());
		stats.setFinalResult(score.getAantalJuisteAntwoorden() + "/" + score.getScoreList().size());
		JOptionPane.showMessageDialog(null, score.toString());
		JOptionPane.showMessageDialog(null, stats.toString());

		// Alles hieronder is testcode, nog te vervangen door juiste code of te
		// verwijderen

		// JOptionPane.showMessageDialog(null, properties.toString());
		//
		// int index = random.nextInt(bewerkingen.size());
		// /*
		// * if (index == 0) { ++index; }
		// */
		// double testgetal = random.nextDouble();
		//
		// JOptionPane.showMessageDialog(null, calculator.result(3, 2,
		// bewerkingen.get(index)));
		// JOptionPane.showMessageDialog(null, Generator.NegatieveBoodschap());
		// JOptionPane.showMessageDialog(null, testgetal);

	}
}
