package step_definitions.API;

import base_def.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.API.ShowDetailUserByNamePage;
import utils.ConfigReader;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ShowDetailUserByNameStep extends TestBase {
    private Response response;
    ConfigReader reader = new ConfigReader();

    @Given("I have the user API endpoint")
    public void iHaveTheUserAPIEndpoint() throws FileNotFoundException {
        baseURI = reader.getSetting(api, "baseURI");
    }

    @When("I send GET request show info according to name {string}")
    public void iSendGETRequestShowInfoAccordingToName(String name) throws FileNotFoundException {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(reader.getSetting(api, "loginEndpoint")+"/user/"+ name);

    }

    @Then("I should receive a {int} status code")
    public void iShouldReceiveAStatusCode(int status) {
        assertEquals(status, response.getStatusCode());
    }

    @And("the response should contain full info")
    public void theResponseShouldContainFullInfo() throws JsonProcessingException {
        ShowDetailUserByNamePage.assertUserInfo(response);
    }
}
