package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailureDemo {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(FailureDemo.class);

    @Given("I logged into Kore & talking with invalid BOT")
    public void i_logged_into_kore_talking_with_invalid_Bot() throws Exception {
        logger.info("This step is failing");
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://bots.kore.ai/botbuilder/login");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "//input[@name='emailPhone']", "ranuradis@gmail.com");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@class='continueBtn']");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "//input[@id='password']", "1Qaz2wsx@");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@class='btn btn-primary']");
        //webDriverProvider.getISTakeScreenShotCommand().takesScreenshot("Error");
        webDriverProvider.getClickCommand().setCustomRetry(2, 2000).click(ElementIdentifier.XPATH, "//span[text()='NAME: ']/../../h1/span[text()='invalidBot']");
    }

    @When("I cannot proceed")
    public void i_cannot_proceed() throws Exception {
        logger.info("When - Failure");
    }

    @Then("Test case should be failed")
    public void test_case_should_be_failed() {
        logger.info("Then - Failure");
    }
}
