package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenANewCD {
    @Given("I logged into Kore & talking with WealthAdvisoryBot")
    public void i_logged_into_kore_talking_with_WealthAdvisoryBot(){
        System.out.println("Given");
    }
    @When("I select Open a new CD")
    public void i_select_open_a_new_CD() throws Exception {
        System.out.println("When");
        //System.setProperty("webdriver.chrome.driver", "E:\\Projects\\ChromeDrivers\\119.0.6045.105\\chromedriver.exe");

        WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://ww.google.com");
        webDriverProvider.getClickCommand().setCustomRetry(3, 2000).click(ElementIdentifier.XPATH, "//textarea[@id='APjFqb']");
        webDriverProvider.getTypeCommand().setCustomRetry(3, 2000).type(ElementIdentifier.XPATH, "//textarea[@id='APjFqb']", "Test");
        webDriverProvider.getTypeCommand().setCustomRetry(3, 5000).type(ElementIdentifier.XPATH, "invalid']", "Test");
    }
    @Then("Please fill the CD form reply should be given")
    public void please_fill_the_CD_form_reply_should_be_given(){
        System.out.println("Then");
    }
}
