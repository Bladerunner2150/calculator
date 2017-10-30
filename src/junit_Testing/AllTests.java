package junit_Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Run all tests
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ GeneratorTEST.class, InPropertiesTest.class, ScoreTest.class })
public class AllTests {

}
