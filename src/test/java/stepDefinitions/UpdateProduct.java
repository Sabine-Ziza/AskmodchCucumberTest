package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class UpdateProduct {
    private String productRowXpath(String productName) {
        return "//td[contains(@class,'product-name')]//a[" +
                "translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" +
                productName.toLowerCase() + "']/ancestor::tr";
    }


    private WebDriverWait wait;

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        Hooks.homepage.clickStoreLink();
        driver.findElement(By.cssSelector("a.add_to_cart_button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View cart"))).click();
    }

    @Given("the cart contains {string}")
    public void theCartContains(String productName) {
        WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']"));
        Assert.assertTrue(product.isDisplayed(), "Product is not in the cart");
    }

    @When("the user clicks the increase arrow for {string} {int} times")
    public void increaseProductQuantity(String productName, int times) {
        WebElement qtyField = driver.findElement(
                By.xpath("//td[contains(@class,'product-name')]//a[normalize-space()='" + productName + "']/ancestor::tr//input[@type='number']")
        );

        for (int i = 0; i < times; i++) {
            qtyField.sendKeys(Keys.ARROW_UP);
        }
    }


    @Then("the quantity of {string} should increase by {int}")
    public void verifyIncreaseQuantity(String productName, int increaseBy) {

        WebElement qtyField = driver.findElement(
                By.xpath(productRowXpath(productName) + "//input[@type='number']")
        );

        int quantity = Integer.parseInt(qtyField.getAttribute("value"));
        Assert.assertEquals(quantity, increaseBy + 1);
    }


    @Then("the {string} button should be visible")
    public void theButtonShouldBeVisible(String buttonName) {

        List<WebElement> buttons = driver.findElements(
                By.xpath("//button[contains(.,'" + buttonName + "')]")
        );

        if (!buttons.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(buttons.get(0)));
        }
    }


//    @When("the user clicks the decrease arrow for {string}")
//    public void the_user_clicks_the_decrease_arrow_for(String productName) {
//
//        WebElement qtyField = driver.findElement(
//                By.xpath(productRowXpath(productName) + "//input[@type='number']")
//        );
//
//        qtyField.sendKeys(Keys.ARROW_DOWN);
//    }


//    @Then("the quantity should not be less than {int}")
//    public void the_quantity_should_not_be_less_than(Integer minQuantity) {
//        WebElement qtyField = driver.findElement(
//                By.xpath("//form[contains(@class,'cart')]//input[@type='number']")
//        );
//
//        int quantity = Integer.parseInt(qtyField.getAttribute("value"));
//        Assert.assertTrue(quantity >= minQuantity, "Quantity is less than minimum allowed");
//    }

    @When("the user clicks the remove button for{string}")
    public void removeProduct(String productName) {

        WebElement removeBtn = driver.findElement(
                By.xpath("//td[contains(@class,'product-name')]//a[" +
                        "translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" +
                        productName.toLowerCase() +
                        "']/ancestor::tr//a[contains(@class,'remove')]")
        );

        removeBtn.click();
    }


    @Then("{string} should be removed from the cart")
    public void productShouldBeRemoved(String productName) {
        boolean isRemoved = driver.findElements(
                By.xpath("//a[text()='" + productName + "']")
        ).isEmpty();

        Assert.assertTrue(isRemoved, "Product is still present in the cart");
    }

    @Then("the cart should be empty")
    public void cartShouldBeEmpty() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement removedMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'woocommerce-message') and contains(.,'removed')]")
                )
        );

        Assert.assertTrue(removedMessage.isDisplayed());
    }

}
