package step_definitions.API;
import base_def.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ConfigReader;
import pages.API.LoginAPIPage;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class LoginAPIStep extends TestBase {
    private Response response;
    ConfigReader reader = new ConfigReader();

    @Given("I have the login API endpoint")
    public void i_have_login_api() throws FileNotFoundException {
        baseURI = reader.getSetting(api, "baseURI");
    }

    @When("I send POST request with valid credentials")
    public void i_send_post_request() throws FileNotFoundException, JsonProcessingException {
        response = given()
                .header("Content-Type", "application/json")
                .body(LoginAPIPage.returnRaw())
                .when()
                .post(reader.getSetting(api, "loginEndpoint")+"/login");
    }

    @Then("I should receive a 201 status code")
    public void i_should_receive_200() {
        assertEquals(201, response.getStatusCode());
    }

    @Then("the response should contain a token")
    public void response_should_contain_token() {
        String token = response.jsonPath().getString("token");
        assertNotNull(token);
    }
}
