/**
 * 
 */
package util;

/**
 * @author Thomas
 *
 */
public enum PositiveMessagesEnum {
	
	bericht1("Goed gedaan"),
	bericht2("goed bezig"),
	bericht3("flink zo"),
	bericht4("dat is correct! :)");

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
