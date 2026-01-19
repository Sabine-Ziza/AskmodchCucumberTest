package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;

public class RegisterSteps {
    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        Hooks.homepage.clickAccountLink();


    }

    @When("the user enters {string}, {string}, and {string}")
    public void the_user_enters_and(String username, String email, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);


    }

    @When("clicks the Register button")
    public void clicks_the_register_button() {
        driver.findElement(By.cssSelector("form.woocommerce-form-register button.woocommerce-Button")).click();
    }

    @Then("the user should see a success message {string}")
    public void the_user_should_see_a_success_message(String message) {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.woocommerce-MyAccount-content > p")
                )
        );

        String actualTitle = successMessage.getText().trim();
        assertEquals(actualTitle, message.trim());
    }



    }
