package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/SearchBar.feature",
		glue = "stepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
