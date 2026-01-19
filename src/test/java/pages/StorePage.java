package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

public class StorePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public StorePage(WebDriver driver){

        this.driver = driver;
    }
    public void storePageLink(){
        Hooks.driver.findElement(By.cssSelector("a.add_to_cart_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View cart"))).click();
    }
}
