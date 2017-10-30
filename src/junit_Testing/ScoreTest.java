package junit_Testing;

import static org.junit.Assert.*;
/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Test Score
 *
 */

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import util.Score;

public class ScoreTest
{
	private static Score score;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		score = new Score();
		Random random = new Random();
		for (int i = 0; i < 100; i++)
		{
			score.setUserGetal(random.nextDouble());
			score.setOplossing(random.nextDouble());
			score.AddScore(score);
		}
	}

	@Test
	public void testCompareScore()
	{
		for (Score score : score.getScoreList())
		{
			score.compareScore(score);
		}
	}

}
