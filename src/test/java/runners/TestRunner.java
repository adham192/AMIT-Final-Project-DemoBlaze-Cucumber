package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = "src/main/resources/features" , glue = "stepsdef" , plugin = {"pretty" , "html:target/reports/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
