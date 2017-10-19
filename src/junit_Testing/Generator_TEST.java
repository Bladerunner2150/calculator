/**
 * 
 */
package junit_Testing;

import java.util.Random;

import org.junit.Test;

import util.Generator;

/**
 * @author Thomas
 *
 */
public class Generator_TEST {

	/**
	 * Test method for {@link util.Generator#PositieveBoodschap(int)}.
	 */
	Random rand = new Random();
	int c = rand.nextInt(4);


	
	@Test
	public void testPositieveBoodschap() {

		int a = rand.nextInt(4);
		Generator.PositieveBoodschap(a);
		

	}

	/**
	 * Test method for {@link util.Generator#NegatieveBoodschap(int)}.
	 * @return 
	 */

	@Test

	public void testNegatieveBoodschap() {
		int a = rand.nextInt(4);
		Generator.NegatieveBoodschap(a);
		
	}

}