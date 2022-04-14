package testcases.user;

import models.User;
import models.UserListResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import spec.builders.SpecBuilder;
import usecases.CreateUser;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class ListUsersTests extends BaseTest {

    SpecBuilder testSpecBuilder;

    @Test
    public void getUsers() throws FileNotFoundException {

        User createdUser = CreateUser.createRandomUser();
        System.out.println(createdUser.getName());
        UserListResponse response =  given().spec(testSpecBuilder.getRequestSpecWithLogs()).
                when().get("/users").
                then().spec(testSpecBuilder.getResponseSpec(200)).
                extract().response().as(UserListResponse.class);

        Assert.assertTrue(response.getUsers().size() >= 0);

        boolean userCreatedInListUsers = false;
        for (User user : response.getUsers()){
            if(user.getUsername().equals(createdUser.getUsername())) {
                userCreatedInListUsers = true;
                break;
            }
        }
        Assert.assertTrue(userCreatedInListUsers);
    }
}
