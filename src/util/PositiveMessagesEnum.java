/**
 * 
 */
package util;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Generate correct messages
 *
 */
public enum PositiveMessagesEnum {
	
	bericht1("Goed gedaan"),
	bericht2("goed bezig"),
	bericht3("flink zo"),
	bericht4("dat is correct! :)");

	// enumeratie om berichten bij een correcte oplossing te tonen
	private String tekst;

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	/**
	 * @param tekst
	 */
	private PositiveMessagesEnum(String tekst) {
		this.tekst = tekst;
	} 
	
	
}
