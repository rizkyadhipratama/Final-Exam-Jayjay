package com.febrio.stepdef;

import com.febrio.page.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.febrio.Hooks.driver;


public class LoginStepDef {

    private static final Logger log = LoggerFactory.getLogger(LoginStepDef.class);
    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        try {

            loginPage.userIsOnLoginPage();
            System.out.println("user in login page");
        } catch (Exception e) {
            log.error("e: ", e);
        }
    }

    @When("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        try {

            loginPage.userInputUsernameTextBoxWith(username);
            System.out.println("user input username "+username);
        }catch (Exception e){
            log.error("e: ", e);
        }
    }

    @And("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String password) {
        try {
            loginPage.userInputPasswordPadaTextBoxWith(password);
            System.out.println("user input password "+password);
        }catch (Exception e){
            log.error("e: ", e);
        }
    }

    @Then("user click submit")
    public void userClickSubmit() {
        // Write code here that turns the phrase above into concrete actions
        try {
            loginPage.userClickSubmit();
            System.out.println("user click submit for login");
        }catch (Exception e){
            log.error("e: ", e);
        }
    }

    @Then("user will redirect to homepage")
    public void userWillRedirectToHomepage() {
        // User will redirect to homepage if login success
        try {
            loginPage.userWillRedirectToHomepage();
            System.out.println("user redirected to homepage after login");
        }catch (Exception e){
            log.error("e: ", e);
        }
    }

    @Then("user logout")
    public void userLogout() {
        try {
            loginPage.userLogout();
            System.out.println("user has logout");
        }catch (Exception e){
            log.error("e: ", e);
        }
    }


    @Then("user will stay on login page")
    public void userWillStayOnLoginPage() {
        try {
            loginPage.userWillStayOnLoginPage();
            System.out.println("authentication wrong, user stay on login page");
        }catch (Exception e){
            log.error("e: ", e);
        }
    }
}
