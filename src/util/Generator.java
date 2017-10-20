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
	//willekeurige berichten geven uit de enumeraties
	public static String PositieveBoodschap () {
		keuze = rand.nextInt(4);
		PositiveMessagesEnum message = PositiveMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}
	public static String NegatieveBoodschap () {
		keuze = rand.nextInt(4); 
		NegativeMessagesEnum message = NegativeMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}
}
