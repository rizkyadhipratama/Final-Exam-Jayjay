package com.febrio.page;

import com.febrio.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static com.febrio.Hooks.driver;

public class LoginPage {

    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // Locators
    By usernameInputText = By.cssSelector("input#loginusername");
    By userInputPassword = By.cssSelector("input#loginpassword");
    By loginButton = By.cssSelector(".btn.btn-primary");
    By loginMenu = By.cssSelector("#login2");
    By logoutMenu = By.cssSelector("#logout2");
    By loginModal = By.cssSelector("#logInModalLabel");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //    ("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
        String webPageTitle = driver.getTitle();
        Assert.assertEquals("STORE", webPageTitle);
        driver.findElement(loginMenu).click();
    }

    //    ("user input username text box with {string}")
    public void userInputUsernameTextBoxWith(String username) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(usernameInputText).sendKeys(username);

    }

    //    ("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(userInputPassword).sendKeys(password);
    }

    //    ("user click submit")
    public void userClickSubmit() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(loginButton).click();
    }

    //    ("user will redirect to homepage")
    public void userWillRedirectToHomepage() {
        // User will redirect to homepage if login success
        By classTitle = By.cssSelector("#nameofuser");
        wait.until(ExpectedConditions.visibilityOfElementLocated(classTitle));

        String actualTitle = driver.findElement(classTitle).getText();
        Assert.assertEquals(
                "Welcome special_user2", actualTitle);


    }

    //    ("user logout")
    public void userLogout() {
        // After login success, then user logout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutMenu));
        logout.click();
    }

    public void userWillStayOnLoginPage(){
        // Wait for element to be visible first, then get text
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
        String loginMenuModal = driver.findElement(loginModal).getText();

        Assert.assertEquals("Log in", loginMenuModal);
    }
}
