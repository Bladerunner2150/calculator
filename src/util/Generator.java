/**
 * 
 */
package util;

import java.util.Random;

import jdk.nashorn.internal.ir.BreakableNode;
import junit_Testing.Generator_TEST;

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

	private double randomReëlGetal(int bereik) {
		double a = rand.nextDouble();
		a += randomGeheelGetal(bereik);
		return a;
	}

	private double randomReëlGetal() {
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

	// negatief reël getal genereren met opgesteld bereik
	private double randomNegatiefReëlGetal(int bereik) {
		double a = randomReëlGetal(bereik) * (-1);
		return a;
	}

	// negatief reël getal genereren zonder bereik
	private double randomNegatiefReëlGetal() {
		double a = randomReëlGetal(101) * (-1);
		return a;
	}

	// grote case om random getallen te genereren op basis van de Properties
	/*public double RandomGetal(int range, boolean positiveNumbers, boolean naturalnumbers, int tafel,
			int numberOfExercices) {*/

		/* met een boolean heb je maar 1 waarde, dan kan je geen reële en gehele getallen door elkaar gebruiken want je kiest altijd een van de twee
		 zelfde met positief en negatief
		een boolean is of true of false maar kan niet beide zijn. 
		of wel zijn alle oefeningen dan negatief of allemaal positief*/

		// double a = 0;
		// if (naturalnumbers==true) {
		// if (positiveNumbers == true) {
		// a = randomGeheelGetal(range);
		// }
		// else {
		// a= randomNegatiefGeheelGetal(range);
		// }
		// }
		// if (naturalnumbers == false) {
		// if (positiveNumbers == true) {
		// a = randomReëlGetal(range);
		// }
		// else {
		// a = randomNegatiefReëlGetal(range);
		// }
		// }
		//
		// return a;
	}

	// public double RandomGetal(boolean positiveNumbers, boolean naturalnumbers,
	// int tafel, int numberOfExercices) {
	// double a = 0;
	// if (naturalnumbers == true) {
	// if (positiveNumbers == true) {
	// a = randomGeheelGetal();
	// } else {
	// a = randomNegatiefGeheelGetal();
	// }
	// }
	// if (naturalnumbers == false) {
	// if (positiveNumbers == true) {
	// a = randomReëlGetal();
	// } else {
	// a = randomNegatiefReëlGetal();
	// }
	// }
	//
	// return a;
	// }

