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
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://www.browserstack.com/users/sign_up");
    }
    @When("get the Popup")
    public void get_the_popup() throws Exception {
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.ID, "user_full_name", "ishara weerasingha");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.ID, "user_email_login", "mgisharaonline@gmail.com");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.ID, "user_password", "Ishwee123@");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.ID, "accept-cookie-notification-cross-icon");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.ID, "user_submit");
        Thread.sleep(5000);

        Alert alert = webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).selectPop();
        alertMessage= webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).getTextPopup();

    }
    @Then("handling the popup")
    public void handling_the_popup() throws Exception {
        logger.info( alertMessage);
        Thread.sleep(5000);
        webDriverProvider.getSelectPopupCommand().setCustomRetry(10, 2000).acceptPopup();
    }
}
