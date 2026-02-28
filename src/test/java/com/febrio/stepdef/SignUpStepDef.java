package com.febrio.stepdef;

import com.febrio.page.SignUpPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.febrio.Hooks.driver;

public class SignUpStepDef {
    SignUpPage signUpPage;

    @Given("User in Home Index page")
    public void userInHomeIndexPage() {
        signUpPage = new SignUpPage(driver);

        try{
            signUpPage.userIsOnHomePage();
            System.out.println("user in index page");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("User click sign up")
    public void userClickSignUp() {
        try{
            signUpPage.userClickSignUp();
            System.out.println("user click sign up");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("User fill username with {string}")
    public void userFillUsernameWith(String username) {
        try{
            signUpPage.userInputUsername(username);
            System.out.println("user input username "+ username);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("User fill password with {string}")
    public void userFillPasswordWith(String password) {
        try{
            signUpPage.userInputPassword(password);
            System.out.println("user input password "+ password);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("User click submit")
    public void userClickSubmit() {
        try{
            signUpPage.userClickSubmit();
            System.out.println("user click submit");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
