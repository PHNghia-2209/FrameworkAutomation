package pages.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.ConfigReader;

import java.io.FileNotFoundException;
import java.util.Map;

import static base_def.TestBase.api;

public class LoginAPIPage {
    static ConfigReader reader = new ConfigReader();

    public static String returnRaw() throws JsonProcessingException, FileNotFoundException {
        Map<String, String> body = Map.of(
                "username", reader.getSetting(api, "username"),
                "password", reader.getSetting(api, "password")
        );
        return new ObjectMapper().writeValueAsString(body);
    }
}
