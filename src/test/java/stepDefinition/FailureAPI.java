package stepDefinition;

import com.rpsperera.automation.automate_api.driver.APIDriverProvider;
import com.rpsperera.automation.automate_common.commands.WriteToReport;
import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class FailureAPI {

    APIDriverProvider apiDriverProvider = APIDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(FailureAPI.class);
    private ResponseDTO apiPost;

    @Given("I have access to API failure")
    public void i_have_access_to_API_failure() throws Exception {
        logger.info("I have access to API failure");
    }

    @When("I send invalid API request")
    public void i_send_invalid_API_request() throws Exception {
        logger.info("I send invalid API request");

        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");

        //apiDriverProvider.getCommand().
        apiPost = APIDriverProvider.getInstance().postCommand().setUrl("http://localhost:9090/cd-application").setBody("{\n" +
                "    \"first_name\": \"Bob\",\n" +
                "    \"last_name\": \"Martin\",\n" +
                "    \"ssn\": \"123-456789\",\n" +
                "    \"email\": \"bob.martin@gmail.com\",\n" +
                "    \"amount_to_deposit\": 100.00,\n" +
                "    \"apy\":4.25,\n" +
                "    \"period\": 1\n" +
                "}").setHeader(headersMap).post();

    }

    @Then("I should receive the failure response")
    public void i_should_receive_the_failure_response() throws Exception {
        WriteToReport.writeToReport(apiPost.toString());
        WriteToReport.writeToReport("Response status code - " + apiPost.getStatusCode().toString());
        WriteToReport.writeToReport("Error message - " + apiPost.getDataAsJsonPath().get("ssn").toString());
        Assert.assertTrue(apiPost.getStatusCode().toString().equals(200));

    }
}
