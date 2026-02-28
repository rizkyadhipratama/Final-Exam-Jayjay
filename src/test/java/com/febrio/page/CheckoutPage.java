package com.febrio.page;

import com.febrio.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

public void UserSelectSpecificProduct(){
        driver.get("https://www.demoblaze.com/index.html");
        By samsungGalaxyS6 = By.xpath("//a[contains(text(), 'Samsung galaxy s6')]");
        wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxyS6)).click();
    }

public void UserClickAddtoCart(){
        By addToCart = By.cssSelector(".btn.btn-success.btn-lg");
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public void UserInCartPage(){
        driver.get("https://www.demoblaze.com/cart.html");
    }

    public void UserClickPlaceOrder(){
        By placeOrderButton = By.cssSelector(".btn.btn-success");
        driver.findElement(placeOrderButton).click();
    }

    public void userFillOrderForm(String name, String country, String city, String creditCard, String month, String year){
//        By modal = By.cssSelector(".modal-content");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        By nameField = By.cssSelector("#name");
        By countryField = By.cssSelector("#country");
        By cityField = By.cssSelector("#city");
        By cardField = By.cssSelector("#card");
        By monthField = By.cssSelector("#month");
        By yearField = By.cssSelector("#year");

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(creditCard);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);

    }

    public void userClickPurchase(){
        By purchaseButton = By.cssSelector(".btn.btn-primary");
        driver.findElement(purchaseButton).click();
    }

}
