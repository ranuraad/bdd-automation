package stepDefinition;

import com.rpsperera.automation.automate_api.driver.APIDriverProvider;
import com.rpsperera.automation.automate_common.commands.WriteToReport;
import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class OpenANewCDAPI {

    APIDriverProvider apiDriverProvider = APIDriverProvider.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(OpenANewCDAPI.class);
    private ResponseDTO apiPost;

    @Given("I have access to open a new CD API")
    public void i_have_access_to_open_a_new_CD_API() throws Exception {
        logger.info("I have access to open a new CD API");
    }

    @When("I send the API request")
    public void i_send_the_API_request() throws Exception {
        logger.info("I send the API request");

        HashMap<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");

        //apiDriverProvider.getCommand().
        apiPost = APIDriverProvider.getInstance().postCommand().setUrl("http://localhost:9090/cd-application").setBody("{\n" +
                "    \"first_name\": \"Bob\",\n" +
                "    \"last_name\": \"Martin\",\n" +
                "    \"ssn\": \"123-45-6789\",\n" +
                "    \"email\": \"bob.martin@gmail.com\",\n" +
                "    \"amount_to_deposit\": 100.00,\n" +
                "    \"apy\":4.25,\n" +
                "    \"period\": 1\n" +
                "}").setHeader(headersMap).post();

    }

    @Then("I should receive the response")
    public void i_should_receive_the_response() throws Exception {
        WriteToReport.writeToReport(apiPost.toString());
        WriteToReport.writeToReport("Response status code - " + apiPost.getStatusCode().toString());
        WriteToReport.writeToReport("Successful message - " + apiPost.getDataAsJsonPath().get("message").toString());
        WriteToReport.writeToReport("New account number - " + apiPost.getDataAsJsonPath().get("accountId").toString());
        WriteToReport.writeToReport("APY - " + apiPost.getDataAsJsonPath().get("apy").toString() + "%");
        WriteToReport.writeToReport("Amount at maturity - $" + apiPost.getDataAsJsonPath().get("amountAtMaturity").toString());
    }
}
