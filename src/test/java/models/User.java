package models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String name;
    private String username;
    private String password;
    private String role;
    private String email;
    private List<String> rolesList = new ArrayList<>(List.of("QA", "DEVELOPER", "MANAGER", "BA"));
    Faker faker = new Faker();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRandomName(){
        this.name = faker.name().firstName();
    }
    public void setRandomUserName(){
        this.username = faker.name().username();
    }
    public void setRandomPassword(){
        this.password = faker.internet().password();
    }

    public void setRandomEmail(){
        this.email = faker.internet().emailAddress();
    }

    public void setRandomRole(){
        this.role = rolesList.get(faker.number().numberBetween(0, rolesList.size()));
    }

    public void randomUser(){

        this.name = faker.name().firstName();
        this.username = faker.name().username();
        this.password = faker.internet().password();
        this.email = faker.internet().emailAddress();
        this.role = rolesList.get(faker.number().numberBetween(0, rolesList.size()));

    }

}

