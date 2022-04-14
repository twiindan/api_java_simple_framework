package setup;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    @BeforeSuite
    public void setUp() throws FileNotFoundException {

        Properties testConfiguration = new Properties();
        FileInputStream propertiesFile = new FileInputStream("src/test/resources/config.properties");

        try {
            testConfiguration.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestAssured.baseURI= testConfiguration.getProperty("baseURI");
        RestAssured.basePath = testConfiguration.getProperty("basePath");
    }

    @AfterSuite
    public void tearDown(){

    }

}
