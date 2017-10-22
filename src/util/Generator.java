/**
 * 
 */
package util;

import java.util.Random;

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

	// functie om een random geheel getal te geven wanneer iemand geen bereik
	// instelt
	// dan zet ik het op maximum tot 100
	private int randomGeheelGetal() {
		int a = randomGeheelGetal(101);
		return a;
	}

	private double randomReŽlGetal(int bereik) {
		double a = rand.nextDouble();
		a += randomGeheelGetal(bereik);
		return a;
	}

	private double randomReŽlGetal() {
		double a = rand.nextDouble();
		a += randomGeheelGetal(101);
		return a;
	}

	// negatief getal genereren met een opgesteld bereik
	private int randomNegatiefGeheelGetal(int bereik) {
		int a = randomGeheelGetal(bereik) * (-1);

		return a;
	}
	// method overloading voor negatief getal zonder bereik

	private int randomNegatiefGeheelGetal() {
		int a = randomGeheelGetal(101) * (-1);
		return a;
	}

	// negatief reŽl getal genereren met opgesteld bereik
	private double randomNegatiefReŽlGetal(int bereik) {
		double a = randomReŽlGetal(bereik) * (-1);
		return a;
	}

	// negatief reŽl getal genereren zonder bereik
	private double randomNegatiefReŽlGetal() {
		double a = randomReŽlGetal(101) * (-1);
		return a;
	}

	// grote case om random getallen te genereren op basis van de Properties
	public double RandomGetal(int range, boolean positiveNumbers, boolean naturalnumbers, int tafel,
			int numberOfExercices) {

		int keuze = 0;
		double a = 0;

		if (positiveNumbers == true && naturalnumbers == true) {
			a = randomGeheelGetal(range);
		}

		if (positiveNumbers == false && naturalnumbers == true) {

			keuze = rand.nextInt(2);
			switch (keuze) {
			case 0:
				a = randomGeheelGetal(range);

				break;
			case 1:
				a = randomNegatiefGeheelGetal(range);
				break;
			}
		}

		if (positiveNumbers == true && naturalnumbers == false) {
			keuze = rand.nextInt(2);

			switch (keuze) {
			case 0:
				a = randomGeheelGetal(range);

				break;
			case 1:
				a = randomReŽlGetal(range);
				break;

			}
		}
		if (positiveNumbers == false && naturalnumbers == false) {
			keuze = rand.nextInt(4);
			switch (keuze) {
			case 0:
				a = randomGeheelGetal(range);
				break;
			case 1:
				a = randomNegatiefGeheelGetal(range);
				break;

			case 2:
				a = randomReŽlGetal(range);
				break;

			case 3:

				a = randomNegatiefReŽlGetal(range);
				break;

			}
		}

		return a;
	}

	// grote case om random getallen te genereren op basis van de Properties zonder
	// ranges
	public double RandomGetal(boolean positiveNumbers, boolean naturalnumbers, int tafel, int numberOfExercices) {

		int keuze = 0;
		double a = 0;

		if (positiveNumbers == true && naturalnumbers == true) {
			a = randomGeheelGetal();
		}

		if (positiveNumbers == false && naturalnumbers == true) {

			keuze = rand.nextInt(2);
			switch (keuze) {
			case 0:
				a = randomGeheelGetal();

				break;
			case 1:
				a = randomNegatiefGeheelGetal();
				break;
			}
		}

		if (positiveNumbers == true && naturalnumbers == false) {
			keuze = rand.nextInt(2);

			switch (keuze) {
			case 0:
				a = randomGeheelGetal();

				break;
			case 1:
				a = randomReŽlGetal();
				break;

			}
		}
		if (positiveNumbers == false && naturalnumbers == false) {
			keuze = rand.nextInt(4);
			switch (keuze) {
			case 0:
				a = randomGeheelGetal();
				break;
			case 1:
				a = randomNegatiefGeheelGetal();
				break;

			case 2:
				a = randomReŽlGetal();
				break;

			case 3:

				a = randomNegatiefReŽlGetal();
				break;

			}
		}

		return a;
	}
}
