package stepDefinition;

import com.rpsperera.automation.automate_common.command_base.TakesScreenshot;
import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_web.commands.WebScreenCapture;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Created by Dilshan on 12/5/2023
 *
 * @author Dilshan Boteju
 */
public class TakeScreenShot {
    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(TakeScreenShot.class);

    @Given("I opened the login page")
    public void i_opened_the_login_page() throws Exception {
        logger.info("I opened login page");
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://bots.kore.ai/botbuilder/login");
        Thread.sleep(5000);
    }

    @When("I take screen shot")
    public void i_take_screen_shot() throws Exception {
        logger.info("get screen shot of the page");
        File element = webDriverProvider.getISTakeScreenShotCommand().setCustomRetry(10,2000).takesScreenshot("testImg");
        assertTrue(element.isFile());

        // Take a screenshot on failure
        if (!element.isFile()) {
            takeScreenshot("testImg");
        }
    }

    @Then("Close web driver")
    public void close_web_driver() {
        // Close the WebDriver
        if (webDriverProvider != null) {
            webDriverProvider.close();
            logger.info("web driver closed");
        }

    }

    private void takeScreenshot(String fileName) throws AutomateException {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot screenshotDriver = (TakesScreenshot) webDriverProvider;

        // Get the screenshot as a file
        File screenshotFile = screenshotDriver.takesScreenshot("test");

        // Specify the directory and filename for the screenshot
        String directory = "screenshots";
        String filePath = directory + File.separator + fileName + ".png";

        // Create the directory if it doesn't exist
        Path path = Paths.get(directory);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Move the file to the specified location
        try {
            Files.move(screenshotFile.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
