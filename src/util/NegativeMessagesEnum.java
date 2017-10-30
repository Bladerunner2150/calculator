/**
 * 
 */
package util;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Generate error messages
 *
 */
public enum NegativeMessagesEnum {
	bericht1("Helaas dit is niet correct"),
	bericht2("Niet juist, Spijtig"),
	bericht3("Sorry dit is fout "), 
	bericht4("Jammer, mispoes");
	// enumeratie om berichten bij een foute oplossing te tonen

	public String tekst;

	/**
	 * @return the tekst
	 */
	public String getTekst() {
		return tekst;
	}

	/**
	 * @param tekst the tekst to set
	 */
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	/**
	 * @param tekst
	 */
	private NegativeMessagesEnum(String tekst) {
		this.tekst = tekst;
	} 
	
}
