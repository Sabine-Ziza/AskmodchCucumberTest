package stepDefinitions;

import base.BaseTests;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;


import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;

public class CartSteps {


    private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));


    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {

        Hooks.homepage.clickStoreLink();
    }

    @When("the user clicks Add to cart button")
    public void the_user_clicks_add_to_cart_button() {

        Hooks.driver.findElement(By.cssSelector("a.add_to_cart_button")).click();
    }

    @When("the user clicks View cart link")
    public void the_user_clicks_view_cart_link() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View cart"))).click();
    }

    @Then("product added should be listed in the cart page")
    public void product_should_be_listed_in_cart_page() {
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("has-text-align-center"))).getText();
        assertEquals(actualMessage, "Cart", "The user is not on the cart page.");
    }
}