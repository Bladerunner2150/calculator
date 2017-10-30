package junit_Testing;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import model.OutStats;
import util.Score;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Test Score
 *
 */


public class OutStatsTest
{
	private static Score score;
	private static OutStats stats;
	private static File file;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		Random random = new Random();
		score = new Score();
		for (int i = 0; i < 100; i++)
		{
			score.setUserGetal(random.nextDouble());
			score.setOplossing(random.nextDouble());
			score.AddScore(score);
		}
		stats = new OutStats();
		file = new File("jUnitTest.ser");
		Date currentDate = new Date();
		stats.setDateOfTest(currentDate);
		stats.setDuration(random.nextLong());
		stats.setSelections("Random string");
		stats.setFinalResult("1/5");
	}

	@Test
	public void testListOut() throws IOException
	{
		OutStats.ListOut(file, score.getScoreList());
	}

	@Test
	public void testLijstInlezen() throws ClassNotFoundException, IOException
	{
		OutStats.LijstInlezen(file);
	}

}
