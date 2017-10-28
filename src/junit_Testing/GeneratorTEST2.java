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
		int r = c.getRangeOfNumbers();
		int a = 6;
		a = c.getCijfersNaKomma();
		boolean g = random.nextBoolean();
		g = c.isNaturalNumbers();
		boolean f = random.nextBoolean();
		f = c.isPositiveNumbers();
		int v = 100;
		v = c.getNumberOfExercises();
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

}
