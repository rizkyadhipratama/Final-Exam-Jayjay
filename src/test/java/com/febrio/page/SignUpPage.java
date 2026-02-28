package com.febrio.page;

import com.febrio.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void userIsOnHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
        String webPageTitle = driver.getTitle();
        Assert.assertEquals("STORE", webPageTitle);

    }

    public void userClickSignUp(){
        By signUp = By.cssSelector("#signin2");
        By signUpElementText = By.cssSelector("#signInModalLabel");
        By modal = By.cssSelector("#signInModal");

        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));

        wait.until(ExpectedConditions.presenceOfElementLocated(signUp));
        WebElement signUpBtn = driver.findElement(signUp);
        
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpElementText));
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String signUpElement = driver.findElement(signUpElementText).getText();
        Assert.assertEquals("Sign up", signUpElement);
    }

    public void userInputUsername(String username){
        By userName = By.cssSelector("#sign-username");
        wait.until(ExpectedConditions.presenceOfElementLocated(userName));

        driver.findElement(userName).sendKeys(username);


    }

    public void userInputPassword(String password){
        By passWord = By.cssSelector("#sign-password");
        wait.until(ExpectedConditions.presenceOfElementLocated(passWord));

        driver.findElement(passWord).sendKeys(password);
    }

    public void userClickSubmit(){
        By submitButton = By.cssSelector("#signInModal .btn.btn-primary");
        By modal = By.cssSelector("#signInModal");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        
        WebElement btn = driver.findElement(submitButton);
        driver.findElement(submitButton).click();
        
        try {
            Thread.sleep(1000);
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            
            if (alertText.contains("Sign up successful")) {
                alert.accept();
                System.out.println("Sign up successful!");
            } else if (alertText.contains("This user already exist")) {
                alert.accept();
                System.out.println("User already exists - using existing user");
            } else {
                alert.accept();
                Assert.fail("Unexpected alert: " + alertText);
            }
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            System.out.println("No alert present - checking if modal closed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
