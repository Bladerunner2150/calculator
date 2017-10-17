/**
 * 
 */
package util;

/**
 * @author Thomas
 *
 */
public enum NegativeMessagesEnum {
	bericht1("Helaas dit is niet correct"),
	bericht2("Niet juist, Spijtig"),
	bericht3("Sorry dit is fout "); 
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
