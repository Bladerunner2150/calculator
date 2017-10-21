/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Keep exercise scores
 *
 */
public class Score
{
	
	ArrayList<Score> ScoreList = new ArrayList<Score>();
	
	/*lijst om oefeningen bij te houden
	ook de userinput van de gebruiker om te vergelijken met 
	de juiste oplossing van de oefening	
	
	*/
	private double getal1; 
	private double getal2;
	private double userGetal;
	private double oplossing;
	private char bewerking;
	/**
	 * @return the scoreList
	 */
	public ArrayList<Score> getScoreList() {
		return ScoreList;
	}
	/**
	 * @param scoreList the scoreList to set
	 */
	public void setScoreList(ArrayList<Score> scoreList) {
		ScoreList = scoreList;
	}
	/**
	 * @return the bewerking
	 */
	public char getBewerking() {
		return bewerking;
	}
	/**
	 * @param bewerking the bewerking to set
	 */
	public void setBewerking(char bewerking) {
		this.bewerking = bewerking;
	}
	/**
	 * @return the getal1
	 */
	public double getGetal1() {
		return getal1;
	}
	/**
	 * @param getal1 the getal1 to set
	 */
	public void setGetal1(double getal1) {
		this.getal1 = getal1;
	}
	/**
	 * @return the getal2
	 */
	public double getGetal2() {
		return getal2;
	}
	/**
	 * @param getal2 the getal2 to set
	 */
	public void setGetal2(double getal2) {
		this.getal2 = getal2;
	}
	/**
	 * @return the userGetal
	 */
	public double getUserGetal() {
		return userGetal;
	}
	/**
	 * @param userGetal the userGetal to set
	 */
	public void setUserGetal(double userGetal) {
		this.userGetal = userGetal;
	}
	/**
	 * @return the oplossing
	 */
	public double getOplossing() {
		return oplossing;
	}
	/**
	 * @param oplossing the oplossing to set
	 */
	public void setOplossing(double oplossing) {
		this.oplossing = oplossing;
	}
	//score object toevoegen aan de lijst 
	
	public void AddScore(Score a) {
		ScoreList.add(a);
	}
	// methode om de userinput te vergelijken met de juiste oplossing
	public String compareScore(Score b) {
		String output =" ";
		if (b.oplossing == b.userGetal) {
			
			output = Generator.PositieveBoodschap();
		}
		if (b.oplossing != b.userGetal) {
			output = Generator.NegatieveBoodschap();
		}
		return output;
	}
	
	public String Eindresultaat() {
		int i = 0;
		int juist = 0;
		for (Score score : ScoreList) {
			++i;
			if (score.oplossing == score.userGetal) {
				++juist;
			}
		}
		String beschrijving = "Je hebt "+juist+"/"+i+"behaald";
		return beschrijving;
	}
	
}
