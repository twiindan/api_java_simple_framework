package usecases;

import models.User;
import spec.builders.SpecBuilder;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {

    static SpecBuilder testSpecBuilder;

    public static User createRandomUser() throws FileNotFoundException {


        User createUserBody = new User();
        createUserBody.randomUser();
        given().spec(testSpecBuilder.getRequestSpecWithLogs()).body(createUserBody).
                when().post("users").
                then().assertThat().statusCode(200).body(equalTo("user created"));
        return createUserBody;
    }
}
