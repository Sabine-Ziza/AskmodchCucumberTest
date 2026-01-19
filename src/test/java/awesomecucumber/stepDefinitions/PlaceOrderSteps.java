package awesomecucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import awesomecucumber.domain.BillingPage;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static awesomecucumber.stepDefinitions.Hooks.driver;

public class PlaceOrderSteps {
    WebDriverWait wait;

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        Hooks.homepage.clickStoreLink();
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(15));

    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {


    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        StorePage storePage = new StorePage(Hooks.driver);
        storePage.storePageLink();
    }


    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        CartPage cartPage = new CartPage(Hooks.driver);
        cartPage.cartCheckout();


    }
    @When("the user fills billing details")
    public void the_user_fills_billing_details(BillingPage billingDetails) {
        CheckoutPage checkoutPage = new CheckoutPage(Hooks.driver);
        checkoutPage.setBillingDetails(billingDetails);
    }




    @When("I place an order")
    public void i_place_an_order() {
        By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();

    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        WebElement actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.woocommerce-order p")));
        String expectedMessage = "Thank you. Your order has been received.";
        assertEquals("wrong message",expectedMessage, actualMessage.getText());
    }


}