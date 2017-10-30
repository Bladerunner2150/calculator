package junit_Testing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import model.InProperties;
/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Test InProperties
 *
 */
public class InPropertiesTest
{

	private static InProperties c;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		c = new InProperties();
		Random random = new Random();
		List<Character> calculations = Arrays.asList('+', '-', '/', '*');
		c.setRangeOfNumbers(random.nextInt(100));
		c.setCijfersNaKomma(random.nextInt(10));
		c.setNaturalNumbers(random.nextBoolean());
		c.setPositiveNumbers(random.nextBoolean());
		c.setNumberOfExercises(random.nextInt(100));
		c.setCalculations(calculations);
	}

	@Test
	public void testWritePropertiesFile()
	{
		InProperties.writePropertiesFile(c);
	}

}
