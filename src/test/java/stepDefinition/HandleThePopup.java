package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandleThePopup {
    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(HandleThePopup.class);
    String alertMessage;
    @Given("open the web page")
    public void open_the_web_page() throws Exception {
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://javascript.info/alert-prompt-confirm");
    }
    @When("get the Popup")
    public void get_the_popup() throws Exception {
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//a[@class='toolbar__button toolbar__button_run']");

        Alert alert = webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).selectPop();
        alertMessage= webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).getTextPopup();

    }
    @Then("handling the popup")
    public void handling_the_popup() throws Exception {
        logger.info( alertMessage);
        webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).acceptPopup();
    }
}
