/**
 * 
 */
package util;

import java.text.DecimalFormat;
import java.util.Random;

import model.InProperties;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Generate exercises
 *
 */
public class Generator {
	private static Random rand = new Random();
	static int keuze = 1;

	// willekeurige berichten geven uit de enumeraties
	public static String PositieveBoodschap() {
		keuze = rand.nextInt(4);
		PositiveMessagesEnum message = PositiveMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}

	public static String NegatieveBoodschap() {
		keuze = rand.nextInt(4);
		NegativeMessagesEnum message = NegativeMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}

	// functie om een willekeurig geheel getal te maken met een vooropgesteld bereik
	private int randomGeheelGetal(int bereik) {

		int a = rand.nextInt(bereik);
		return a;
	}

	private double randomReëlGetal(int bereik) {
		double a = rand.nextDouble();
		a += randomGeheelGetal(bereik);
		return a;
	}

	// negatief getal genereren met een opgesteld bereik
	private int randomNegatiefGeheelGetal(int bereik) {
		int a = randomGeheelGetal(bereik) * (-1);

		return a;
	}
	// method overloading voor negatief getal zonder bereik

	// negatief reël getal genereren met opgesteld bereik
	private double randomNegatiefReëlGetal(int bereik) {
		double a = randomReëlGetal(bereik) * (-1);
		return a;
	}

	// grote case om random getallen te genereren op basis van de Properties
	public double RandomGetal(InProperties c) {

		int keuze = 0;
		double a = 0;
		double g = 0;

		if (c.isPositiveNumbers() == true && c.isNaturalNumbers() == true) {
			g = randomGeheelGetal(c.getRangeOfNumbers());
		}

		if (c.isPositiveNumbers() == false && c.isNaturalNumbers() == true) {

			keuze = rand.nextInt(2);
			switch (keuze) {
			case 0:
				g = randomGeheelGetal(c.getRangeOfNumbers());
				break;
			case 1:
				g = randomNegatiefGeheelGetal(c.getRangeOfNumbers());
				break;
			}
		}

		if (c.isPositiveNumbers() == true && c.isNaturalNumbers() == false) {
			keuze = rand.nextInt(2);

			switch (keuze) {
			case 0:
				a = randomGeheelGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());

				break;
			case 1:
				a = randomReëlGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());
				break;

			}
		}
		if (c.isPositiveNumbers() == false && c.isNaturalNumbers() == false) {
			keuze = rand.nextInt(3);
			switch (keuze) {
			case 0:
				a = randomGeheelGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());
				break;
			case 1:
				a = randomNegatiefGeheelGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());

				break;

			case 2:
				a = randomReëlGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());
				break;

			case 3:

				a = randomNegatiefReëlGetal(c.getRangeOfNumbers());
				g = formatGetal(a, c.getCijfersNaKomma());

				break;

			}
		}

		return g;
	}

	// om getallen na de komma te beperken
	private Double formatGetal(double a, int aantal) {
		String form = "";
		for (int i = 0; i < aantal; ++i) {
			form += "#";
		}
		DecimalFormat format = new DecimalFormat("00." + form);
		String b = format.format(a);
		double h = Double.parseDouble(b);
		return h;
	}

	public double ControleerGetal(double f, char c) {
		double j = 0;
		if (c == '*' || c == '/') {
			if (f > 10 || f < -10) {
				j =rand.nextInt(11);
			}
		}
		return j;
	}

}
