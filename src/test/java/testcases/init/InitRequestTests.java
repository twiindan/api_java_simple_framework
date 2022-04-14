package testcases.init;

import models.InitResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import spec.builders.SpecBuilder;

import java.io.IOException;

import static io.restassured.RestAssured.given;



public class InitRequestTests extends BaseTest {

    SpecBuilder testSpecBuilder;

    @Test
    public void validateInitRequest() throws IOException {

        InitResponse response = given().spec(testSpecBuilder.getRequestSpecWithLogs()).
                when().get().
                then().spec(testSpecBuilder.getResponseSpec(200)).extract().response().as(InitResponse.class);
        Assert.assertEquals("forum", response.getProduct());
        Assert.assertEquals("0.2.0", response.getVersion());
    }
}
