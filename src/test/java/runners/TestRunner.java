package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
// Test webhook3
@CucumberOptions(
        features = "src/test/resources/features",  // Make sure this points to your feature files directory
        glue = "stepDefinitions",  // Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

