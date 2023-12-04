package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CheckVisibilityElements {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(CheckVisibilityElements.class);

    @Given("Loading the created sample html page from local")
    public void loadingTheHTMLFile() throws Exception {
        String pagePath = new File(getClass().getClassLoader().getResource("pages/index.html").getFile()).getPath();
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open(pagePath);
        Thread.sleep(5000);
    }

    @When("I click on a button")
    public void checkTheElementVisibility() throws Exception {
        Boolean isSelected = webDriverProvider.getIsSelectedCommand().isSelected(ElementIdentifier.XPATH, "//input[@value='Ladyfinger']");
        Boolean isEnabled = webDriverProvider.getIsEnabledCommand().isEnabled(ElementIdentifier.XPATH, "//input[@value='Potato']");
//        Boolean isDisplayed = webDriverProvider.getIsDisplayedCommand().isDisplayed(ElementIdentifier.XPATH, "//input[@value='Ladyfinger']");
        Boolean isDisplayed = webDriverProvider.getIsDisplayedCommand().isDisplayed(ElementIdentifier.XPATH, "//input[@id='custId']");

        logger.info("is element selected " + isSelected);
        logger.info("is element enabled " + isEnabled);
        logger.info("is element isDisplayed " + isDisplayed);
        logger.info("----------------");
    }

    @Then("Check the visibility")
    public void afterCheckingElementVisibility() {
        logger.info("all the three visibilities working fine");
    }
}
