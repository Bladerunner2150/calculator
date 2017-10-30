package junit_Testing;

import java.util.Random;

import org.junit.Test;

import model.InProperties;
import util.Generator;

public class GeneratorTEST2 {
	@SuppressWarnings("unused")
	
	@Test
	public void testRandomGetal() {
		InProperties c = new InProperties();
		Random random = new Random();
		c.setRangeOfNumbers(random.nextInt(100));
		c.setCijfersNaKomma(random.nextInt(10));
		c.setNaturalNumbers(random.nextBoolean());
		c.setPositiveNumbers(random.nextBoolean());
		c.setNumberOfExercises(random.nextInt(100));
		Generator generator = new Generator();
		double t = generator.RandomGetal(c);

	}

	/*
	 * @Test public void testRandomGetalZonderRange() { fail("Not yet implemented");
	 * // TODO }
	 */
	@Test
	public void testPositieveBoodschap() {

		Generator.PositieveBoodschap();

	}

	/**
	 * Test method for {@link util.Generator#NegatieveBoodschap()}.
	 * 
	 * @return
	 */

	@Test

	public void testNegatieveBoodschap() {

		Generator.NegatieveBoodschap();

	}
	
	@Test 
	
	public double f

}
