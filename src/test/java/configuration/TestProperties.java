package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String [] args) throws IOException {

        Properties testConfiguration = new Properties();
        FileInputStream propertiesFile = new FileInputStream("src/test/resources/config.properties");
        testConfiguration.load(propertiesFile);
        System.out.println(testConfiguration.getProperty("baseURI"));

    }
}
