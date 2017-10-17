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
	Random random = new Random();
	
	public static String PositieveBoodschap (int keuze) {
		PositiveMessagesEnum message = PositiveMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}
	public static String NegatieveBoodschap (int keuze) {
		NegativeMessagesEnum message = NegativeMessagesEnum.values()[keuze];
		String result = message.getTekst();
		return result;
	}
}
