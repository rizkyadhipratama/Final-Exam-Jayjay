package com.febrio.stepdef;

import com.febrio.page.CheckoutPage;
import com.febrio.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.febrio.Hooks.driver;

public class CheckoutStepDef {
    CheckoutPage checkoutPage;

    @Before
    public void runBefore(){
        checkoutPage = new CheckoutPage(driver);

    }

    @Then("User select specific product")
    public void userSelectSpecificProduct() {
        try {
            checkoutPage.UserSelectSpecificProduct();
            System.out.println("User select specific product");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Given("User in cart page")
    public void userInCartPage() {
        try {
            checkoutPage.UserInCartPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        try {
            driver.get("https://www.demoblaze.com/index.html");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("User click add to cart")
    public void userClickAddToCart() {
        try {
            checkoutPage.UserClickAddtoCart();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("User click place order")
    public void userClickPlaceOrder() {
        try {
            checkoutPage.UserClickPlaceOrder();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("User fill order with name {string} country {string} city {string} credit card {string} month {string} year {string}")
    public void userFillOrderWithNameCountryCityCreditCardMonthYear(String name, String country, String city, String creditCard, String month, String year) {
        try {
            checkoutPage.userFillOrderForm(name, country, city, creditCard, month, year);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @And("User click purchase")
    public void userClickPurchase() {
        try {
            checkoutPage.userClickPurchase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
