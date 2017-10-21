/**
 * 
 */
package junit_Testing;

import org.junit.Test;

import util.Generator;

/**
 * @author Thomas Vanden Bossche & Bart Taelemans
 *
 */
public class Generator_TEST {

	/**
	 * Test method for {@link util.Generator#PositieveBoodschap()}.
	 */

	// test functies om de boodschappen te testen

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