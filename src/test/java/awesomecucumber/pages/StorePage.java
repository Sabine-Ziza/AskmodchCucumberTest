package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Store']") private WebElement storeLink;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void storePageLink(){
        wait.until(ExpectedConditions.elementToBeClickable(storeLink)).click();
        driver.findElement(By.cssSelector("a.add_to_cart_button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View cart"))).click();
    }
}
