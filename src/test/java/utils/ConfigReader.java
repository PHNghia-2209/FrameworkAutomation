package utils;

import base_def.VariableManager;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    public String getSetting(String env, String info) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(VariableManager.CONFIG_FILE);
        HashMap yamlMap = yaml.load(inputStream);
        HashMap configInfo = (HashMap) yamlMap.get(env);
        return configInfo.get(info).toString();
    }
}
