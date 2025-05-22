package pages.API;

import base_def.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import utils.ConfigReader;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShowDetailUserByNamePage extends TestBase {
    public static void assertUserInfo(Response response) throws JsonProcessingException {
        Map<String, String> expected = Map.of(
                "_id", "682e97ecd640f441a2b3115a",
                "username", "sumo",
                "fullName", "Sumo Japan",
                "email", "sumo@gmail.com",
                "phone", "1234562232",
                "token", "2uq7va33ur2"
        );

        String jsonString = response.getBody().asString();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> actual = mapper.readValue(jsonString, Map.class);

        for (String key : expected.keySet()) {
            assertEquals("Mismatch at field: " + key, expected.get(key), actual.get(key));
            System.out.println(expected.get(key) + "===" + actual.get(key));
        }
    }

}
