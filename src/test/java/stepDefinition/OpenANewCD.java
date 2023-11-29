package stepDefinition;

import com.rpsperera.automation.automate_api.driver.APIDriverProvider;
import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenANewCD {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    APIDriverProvider apiDriverProvider = APIDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(OpenANewCD.class);
    private boolean isCDFormSubmitted;
    private String intentName;

    @Given("I logged into Kore & talking with WealthAdvisoryBot")
    public void i_logged_into_kore_talking_with_WealthAdvisoryBot() throws Exception {
        logger.info("I logged into Kore & talking with WealthAdvisoryBot");
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://bots.kore.ai/botbuilder/login");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "//input[@name='emailPhone']", "ranuradis@gmail.com");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@class='continueBtn']");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "//input[@id='password']", "1Qaz2wsx@");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@class='btn btn-primary']");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//span[text()='NAME: ']/../../h1/span[text()='WealthAdvisoryBot']");
        Thread.sleep(5000);
    }

    @When("I select Open a new CD")
    public void i_select_open_a_new_CD() throws Exception {
        logger.info("I select Open a new CD");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@tooltip='Talk To Bot']");
        Thread.sleep(5000);
        /*webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@title='Reconnect']");*/
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//button[@title='Debug Log']");
        Thread.sleep(2000);
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//tab-heading[contains(text(),'Session context & variables')]");

        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "(//li[contains(text(),'Open a new CD')])[last()]");
        Thread.sleep(2000);
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//span[text()='Custom Variables']");
        Thread.sleep(2000);
        intentName = webDriverProvider.getTextCommand().setCustomRetry(10, 2000).getText(ElementIdentifier.XPATH, "//div[text()='intentName']/../div[2]/span");
        logger.info("Intent Name is - '"+intentName+"'");

        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "(//li[contains(text(),'Please fill the CD form')])[last()]/../li[2]");

        //Select the iFrame for CD form
        webDriverProvider.getSelectFrameCommand().selectFrame(ElementIdentifier.XPATH, "(//iframe[@id='inlineIframeModal'])[last()]");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//input[@placeholder='First Name'])[last()]");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "(//input[@placeholder='First Name'])[last()]", "Bob");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//input[@placeholder='Last Name'])[last()]");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "(//input[@placeholder='Last Name'])[last()]", "Martin");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//input[contains(@placeholder,'Enter SSN number')])[last()]");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "(//input[contains(@placeholder,'Enter SSN number')])[last()]", "123456789");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//input[@placeholder='Provide your Email Address'])[last()]");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "(//input[@placeholder='Provide your Email Address'])[last()]", "bob.martin@gmail.com");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//input[contains(@placeholder,'Enter amount to')])[last()]");
        webDriverProvider.getTypeCommand().setCustomRetry(10, 2000).type(ElementIdentifier.XPATH, "(//input[contains(@placeholder,'Enter amount to')])[last()]", "25");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//button/span[text()='select duration'])[last()]");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "(//button/span[text()='select duration'])[last()]");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//a[text()='1 Year'])[last()]");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "(//a[text()='1 Year'])[last()]");
        webDriverProvider.getMouseMoveCommand().moveMouseToElement(ElementIdentifier.XPATH,"(//button[text()='Submit'])[last()]");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "(//button[text()='Submit'])[last()]");
    }

    @Then("Please fill the CD form reply should be given")
    public void please_fill_the_CD_form_reply_should_be_given() throws Exception {
        //Get out of the iFrame
        WebDriverProvider webDriverProvider2 = WebDriverProvider.getInstance();
        //webDriverProvider2.
        //webDriverProvider.getSelectFrameCommand().selectFrameById(0);
        isCDFormSubmitted = webDriverProvider.getCheckElementPresentCommand().setCustomRetry(10,2000).checkElementPresent(ElementIdentifier.XPATH, "(//span[text()='CD Form is successfully submitted.'])[last()]");
        logger.info("Successful message is - '"+isCDFormSubmitted+"'");
        logger.info("CD Form is successfully submitted.");
        webDriverProvider.close();
        /*webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//span[text()='RA']");
        webDriverProvider.getClickCommand().setCustomRetry(10, 2000).click(ElementIdentifier.XPATH, "//li[contains(text(),'Logout')]");
        webDriverProvider.close();*/
    }
}