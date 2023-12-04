package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by dasitha on 2023-12-04
 *
 * @author dasitha
 */
public class GetTitle {
    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(GetTitle.class);
    private String title;

    @Given("I opened the login page")
    public void i_opened_the_login_page() throws Exception {
        logger.info("I opened login page");
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://bots.kore.ai/botbuilder/login");
        Thread.sleep(5000);
    }

    @When("Get web page title")
    public void get_web_page_title() throws Exception {
        logger.info("get title");
        title = webDriverProvider.getTitleCommand().setCustomRetry(10, 2000).getTitle();
    }

    @Then("Assert the page title")
    public void assert_the_page_title() {
        // Then: Assert the page title
        logger.info("Assert the page title. {}" , title);
        assertEquals("Kore.ai Bot Builder", title);
        webDriverProvider.close();
    }
}
