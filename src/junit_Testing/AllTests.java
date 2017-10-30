package junit_Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GeneratorTEST.class, InPropertiesTest.class, ScoreTest.class })
public class AllTests {

}
