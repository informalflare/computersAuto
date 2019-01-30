package test_runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@Test(groups = "cucumber")
@CucumberOptions(
  plugin={"pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json"},
  dryRun=false,
  features ="src/test/java/com/herokuapp/computer_database/testFeatures",
  glue ="com.herokuapp.computer_database.steps")
public class CheckingSuite extends AbstractTestNGCucumberTests {
}
