package testcases.user;

import models.User;
import org.testng.annotations.Test;
import setup.BaseTest;
import spec.builders.SpecBuilder;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTests extends BaseTest {

    SpecBuilder testSpecBuilder;

    @Test
    public void CreateCorrectUserTest() throws FileNotFoundException {

        User newUserBody = new User();
        newUserBody.randomUser();

        given().spec(testSpecBuilder.getRequestSpecWithLogs()).body(newUserBody).
                when().post("/users").
                then().spec(testSpecBuilder.getResponseSpec(200)).body(equalTo("user created"));
    }

    @Test
    public void createUserWithoutPassword() throws FileNotFoundException {
        User newUserBody = new User();
        newUserBody.setRandomUserName();
        newUserBody.setRandomEmail();
        newUserBody.setRandomName();
        newUserBody.setRandomRole();

        given().spec(testSpecBuilder.getRequestSpecWithLogs()).body(newUserBody).
                when().post("/users").
                then().spec(testSpecBuilder.getResponseSpec(400));
    }

    @Test
    public void createUserWithoutUsername() throws FileNotFoundException {
        User newUserBody = new User();
        newUserBody.setRandomPassword();
        newUserBody.setRandomEmail();
        newUserBody.setRandomName();
        newUserBody.setRandomRole();

        given().spec(testSpecBuilder.getRequestSpecWithLogs()).body(newUserBody).
                when().post("/users").
                then().spec(testSpecBuilder.getResponseSpec(400));
    }
    @Test
    public void createUserWithIncorrectRole() throws FileNotFoundException {

        User newUserBody = new User();
        newUserBody.randomUser();
        newUserBody.setRole("Invalid");

        given().spec(testSpecBuilder.getRequestSpecWithLogs()).body(newUserBody).
                when().post("/users").
                then().spec(testSpecBuilder.getResponseSpec(400));
    }

}
