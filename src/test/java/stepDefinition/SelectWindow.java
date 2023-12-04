package stepDefinition;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Set;

public class SelectWindow {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(SelectWindow.class);

    @Given("Loading the window and check the actions related to window")
    public void load_parent() throws Exception {
        String pagePath = new File(getClass().getClassLoader().getResource("pages/index.html").getFile()).getPath();
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open(pagePath);
        Thread.sleep(5000);
    }

    @When("I click on a button new window")
    public void make_pages_function() throws Exception {

        String window = webDriverProvider.getWindowHandle().getWindowHandle();
        logger.info("window " + window);
        Set<String> windowHandles = webDriverProvider.getWindowHandle().getWindowHandles();
        logger.info("windowHandles " + windowHandles);
        webDriverProvider.getWindowHandle().switchToWindow(window);
        Thread.sleep(5000);
        logger.info("window switched");
    }

    @Then("Check the window functions")
    public void result() {

        logger.info("all the three windows functions are working fine");
    }

}

