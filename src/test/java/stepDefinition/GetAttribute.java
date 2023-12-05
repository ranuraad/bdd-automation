package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.commands.WebGetAttribute;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAttribute {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(GetAttribute.class);

    @Given("I opened the login page")
    public void i_logged_into_kore_and_navigated_to_conversational_skills() throws Exception {
        logger.info("I opened login page");
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://bots.kore.ai/botbuilder/login");
        Thread.sleep(5000);
    }

    @When("get attribute")
    public void i_click_on_dialog_tasks() throws Exception {
        logger.info("get attribute of input email");
//        WebElement inputEmail = webDriverProvider.getWebDriver().findElement(By.name("emailPhone"));
        String attribute = webDriverProvider.getAttributeCommand().setCustomRetry(10, 2000).getAttribute(ElementIdentifier.NAME, "emailPhone", "placeholder");

        logger.info("attribute : " +attribute);
    }

    @Then("Assert the page attribute")
    public void all_the_dialog_tasks_should_be_listed() {
        logger.info("get attirbute method works fine");
    }
}
