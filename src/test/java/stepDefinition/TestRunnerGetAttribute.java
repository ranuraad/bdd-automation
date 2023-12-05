package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = {"stepDefinition"}, tags = ("@getAttributeTask"), monochrome = true
)
public class TestRunnerGetAttribute {
}
