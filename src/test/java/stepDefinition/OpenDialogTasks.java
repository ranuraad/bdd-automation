package stepDefinition;

import com.rpsperera.automation.automate_web.driver.WebDriverProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenDialogTasks {

    WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(OpenDialogTasks.class);

    @Given("I logged into Kore & navigated to coversational skills")
    public void i_logged_into_kore_and_navigated_to_conversational_skills() throws Exception {
        logger.info("Given - Open Dialog Task");
    }

    @When("I click on Dialog Tasks")
    public void i_click_on_dialog_tasks() throws Exception {
        logger.info("When - Open Dialog Task");
    }

    @Then("All the Dialog Tasks should be listed")
    public void all_the_dialog_tasks_should_be_listed() {
        logger.info("Then - Open Dialog Task");
    }
}
