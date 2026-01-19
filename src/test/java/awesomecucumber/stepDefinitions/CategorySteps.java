package awesomecucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static awesomecucumber.stepDefinitions.Hooks.driver;


public class CategorySteps {

    @Given("the user is on the Askmodich store page")
    public void the_user_is_on_the_askmodich_store_page() {
//        driver = DriverFactory.getDriver();
//        driver.get("https://askomdch.com");
        Hooks.homepage.clickStoreLink();
    }

    @When("the user selects {string} from the category dropdown")
    public void the_user_selects_from_the_category_dropdown(String category) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("dropdown_product_cat")
        ));
        dropdown.click();
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Men’s Jeans')]")
        ));
        product.click();

    }

    @Then("only products belonging to the {string} category should be displayed")
    public void only_products_belonging_to_the_category_should_be_displayed(String category) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h1.woocommerce-products-header__title.page-title")));

        String actualText = text.getText().trim();
        String expectedText = category.trim();

        Assert.assertEquals(actualText, expectedText, "Wrong category displayed");

    }
}
