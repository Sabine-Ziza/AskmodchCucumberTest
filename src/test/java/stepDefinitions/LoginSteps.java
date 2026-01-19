package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver = Hooks.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the Askmodch homepage")
    public void the_user_is_on_the_askmodch_homepage() {
        Hooks.homepage.clickAccountLink();

    }

    @When("the user enters {string} and {string} in the login form")
    public void the_user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[value='Log in']"))).click();
    }

    @Then("the user should see the {string}")
    public void theUserShouldSeeExpectedResult(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("dashboard")) {
            String dashboardText = wait.until(driver ->
                    driver.findElement(By.cssSelector("div.woocommerce-MyAccount-content > p"))).getText();
            assertTrue(dashboardText.contains("Hello"), "Dashboard message not displayed!");
        } else {
            String errorText = wait.until(driver ->
                    driver.findElement(By.cssSelector("ul.woocommerce-error li"))).getText();
            assertTrue(errorText.contains("incorrect") || errorText.contains("not registered"),
                    "Error message not displayed correctly!");
        }
    }



}
