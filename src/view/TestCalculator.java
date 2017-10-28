/**
 * 
 */
package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
public class TestCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		char input;
		String userinput = " ";
		int tafel = 0;
		boolean tafelOefening = false;

		int numberCalculations = 0;
		ArrayList<Character> bewerkingen = new ArrayList<>();

		Calculator calculator = new Calculator();
		InProperties properties = null;
		Properties props = null;
		OutStats stats = new OutStats();
		Generator generator = new Generator();
		Score score = new Score();

		// loop voor nieuwe oefening: alle variabelen leegmaken

		userinput = JOptionPane.showInputDialog(
				"Wat wil je doen?\n1. Bestaande settings inladen van een file\n2. Nieuwe settings ingeven\n3. Tafels oefenen");
		switch (userinput) {
		case "1":
			props = new Properties();
			properties = new InProperties();
			try {
				FileInputStream inputProps = new FileInputStream("calculatorDefault.properties");
				props.load(inputProps);
				inputProps.close();

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			properties.setRangeOfNumbers(Integer.parseInt(props.getProperty("range")));
			properties.setPositiveNumbers(Boolean.parseBoolean(props.getProperty("positive")));
			properties.setNaturalNumbers(Boolean.parseBoolean(props.getProperty("natural")));
			properties.setCijfersNaKomma(Integer.parseInt(props.getProperty("decimals")));
			int calc = props.getProperty("calc").length();
			for (int i = 0; i < calc; i++) {
				input = props.getProperty("calc").charAt(i);
				bewerkingen.add(input);
			}
			properties.setCalculations(bewerkingen);
			properties.setMultiplyTable(Integer.parseInt(props.getProperty("multiplytable")));
			properties.setNumberOfExercises(Integer.parseInt(props.getProperty("numberofexercises")));
			break;
		case "2":
			properties = new InProperties();
			userinput = JOptionPane.showInputDialog("Geef het aantal bewerkingen in: max 4 [*, /, +, -]");
			numberCalculations = Integer.parseInt(userinput);

			List<String> rangtelwoorden = Arrays.asList("eerste", "tweede", "derde", "vierde");
			for (int i = 0; i < numberCalculations; i++) {
				userinput = JOptionPane.showInputDialog("Geef " + rangtelwoorden.get(i) + " bewerking in: ");
				input = userinput.charAt(0);
				if (bewerkingen.isEmpty() == true) {
					bewerkingen.add(input);
				} else {

					// If- statement om te controleren of ze niet twee keer dezelfde bewerking
					// ingeven
					if (bewerkingen.contains(input) == true) {

						JOptionPane.showMessageDialog(null, "Geef andere bewerking in ");
						// eentje aftrekken bij "i" omdat de for-loop anders stopt
						i--;
					} else {
						bewerkingen.add(input);
					}
				}
			}
			properties.setCalculations(bewerkingen);

			userinput = JOptionPane.showInputDialog("Tot welk getal wil je rekenen?");
			properties.setRangeOfNumbers(Integer.parseInt(userinput));

			userinput = JOptionPane.showInputDialog("Wil je alleen met positieve getallen rekenen? (j/n)");
			input = Character.toLowerCase(userinput.charAt(0));
			if (input == 'j') {
				properties.setPositiveNumbers(true);
			} else {
				properties.setPositiveNumbers(false);
			}

			userinput = JOptionPane.showInputDialog("Wil je alleen met gehele getallen rekenen? (j/n)");
			input = Character.toLowerCase(userinput.charAt(0));
			if (input == 'j') {
				properties.setNaturalNumbers(true);
			} else {
				properties.setNaturalNumbers(false);
			}

			if (!properties.isNaturalNumbers()) {
				userinput = JOptionPane.showInputDialog("Hoeveel cijfers na de komma?");
				properties.setCijfersNaKomma(Integer.parseInt(userinput));
			}

			if (bewerkingen.contains('*')) // test om te kijken of vermenigvuldigingen in lijst bewerkingen zitten
			{
				userinput = JOptionPane.showInputDialog("Wil je ook een tafel berekenen? (j/n)");
				input = Character.toLowerCase(userinput.charAt(0));
				if (input == 'j') {
					do {
						userinput = JOptionPane
								.showInputDialog("Welke tafel wil je berekenen? Geef een cijfer van 1 tot 9");
						properties.setMultiplyTable(Integer.parseInt(userinput));
					} while (properties.getMultiplyTable() < 1 || properties.getMultiplyTable() > 9);
				}
			}

			userinput = JOptionPane.showInputDialog("Hoeveel oefeningen wil je maken?");
			properties.setNumberOfExercises(Integer.parseInt(userinput));
			
			// wegschrijven naar properties file
			props = new Properties();
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
			props.setProperty("multiplytable", String.valueOf(properties.getMultiplyTable()));
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
			
			break;
		case "3":
			tafelOefening = true;
			userinput = JOptionPane.showInputDialog("Welke tafel wil je oefenen?");
			tafel = Integer.parseInt(userinput);
			break;
		default:
			break;
		}

		// deze code maakt oefeningen aan, maar moet nog verplaatst worden naar
		// Generator class en opgekuist worden (in Score moeten getal1 en getal2 nog weg
		// misschien?)

		long startTime = System.currentTimeMillis();
		Date currentDate = new Date();
		stats.setDateOfTest(currentDate);

		if (tafelOefening) {
			for (int i = 1; i <= 10; i++) {
				double oplossing = calculator.result(i, tafel, '*');
				score.setOplossing(oplossing);
				userinput = JOptionPane.showInputDialog("Hoeveel is " + i + "*" + tafel + " ?");
				double answer = Double.parseDouble(userinput);
				score.setUserGetal(answer);
				score.AddScore(score);
				JOptionPane.showMessageDialog(null, score.compareScore(score));
			}
			stats.setSelections("Tafel van " + tafel);
		}

		else {
			for (int i = 0; i < properties.getNumberOfExercises(); i++) {
				int index = random.nextInt(properties.getCalculations().size());
				char calculation = properties.getCalculations().get(index);
				double randomgetal1 = generator.RandomGetal(properties);
				double randomgetal2 = generator.ControleerGetal(generator.RandomGetal(properties), calculation);
				double result = calculator.result(randomgetal1, randomgetal2, calculation);
				score.setOplossing(result);
				userinput = JOptionPane.showInputDialog("Oefening " + (i + 1) + "/" + properties.getNumberOfExercises()
						+ ": Hoeveel is " + randomgetal1 + calculation + randomgetal2 + " ?");
				double answer = Double.parseDouble(userinput);
				score.setUserGetal(answer);

				// onderstaande regels kunnen misschien vereenvoudigd worden, misschien met
				// factory of zo, of getters en setters?
				score.AddScore(score);
				JOptionPane.showMessageDialog(null, score.compareScore(score));
			}
			stats.setSelections(properties.toString());
		}
		long elapsedTimeInSeconds = (System.currentTimeMillis() - startTime) / 1000;
		stats.setDuration(elapsedTimeInSeconds); // dit eventueel nog omzetten naar minuten en seconden
		stats.setFinalResult(score.getAantalJuisteAntwoorden() + "/" + score.getScoreList().size());
		JOptionPane.showMessageDialog(null, score.toString());
		JOptionPane.showMessageDialog(null, stats.toString());
	}
}
