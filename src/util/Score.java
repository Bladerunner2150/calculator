/**
 * 
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Keep exercise scores
 *
 */
public class Score implements Serializable
{

	ArrayList<Score> ScoreList = new ArrayList<Score>();

	/*
	 * lijst om oefeningen bij te houden ook de userinput van de gebruiker om te
	 * vergelijken met de juiste oplossing van de oefening
	 * 
	 */
	private double userGetal;
	private double oplossing;
	private int aantalJuisteAntwoorden; // toegevoegd om dit zo bij te houden via method compareScore ipv met aparte
										// method

	/**
	 * @return the scoreList
	 */
	public ArrayList<Score> getScoreList()
	{
		return ScoreList;
	}

	/**
	 * @param scoreList
	 *            the scoreList to set
	 */
	public void setScoreList(ArrayList<Score> scoreList)
	{
		ScoreList = scoreList;
	}

	/**
	 * @return the userGetal
	 */
	public double getUserGetal()
	{
		return userGetal;
	}

	/**
	 * @param userGetal
	 *            the userGetal to set
	 */
	public void setUserGetal(double userGetal)
	{
		this.userGetal = userGetal;
	}

	/**
	 * @return the oplossing
	 */
	public double getOplossing()
	{
		return oplossing;
	}

	/**
	 * @param oplossing
	 *            the oplossing to set
	 */
	public void setOplossing(double oplossing)
	{
		this.oplossing = oplossing;
	}

	// score object toevoegen aan de lijst

	/**
	 * @return the aantalJuisteAntwoorden
	 */
	public int getAantalJuisteAntwoorden()
	{
		return aantalJuisteAntwoorden;
	}

	/**
	 * @param aantalJuisteAntwoorden
	 *            the aantalJuisteAntwoorden to set
	 */
	public void setAantalJuisteAntwoorden(int aantalJuisteAntwoorden)
	{
		this.aantalJuisteAntwoorden = aantalJuisteAntwoorden;
	}

	public void AddScore(Score a)
	{
		ScoreList.add(a);
	}

	// methode om de userinput te vergelijken met de juiste oplossing
	public String compareScore(Score b)
	{
		String output = " ";
		if (b.oplossing == b.userGetal)
		{
			setAantalJuisteAntwoorden(getAantalJuisteAntwoorden() + 1); // zie opmerking bij properties, minder code zo
			output = Generator.PositieveBoodschap();
		}
		if (b.oplossing != b.userGetal)
		{
			output = Generator.NegatieveBoodschap() + " - Het juiste antwoord was: " + b.getOplossing();
		}
		return output;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Je hebt " + getAantalJuisteAntwoorden() + "/" + ScoreList.size() + " behaald";
	}

}
