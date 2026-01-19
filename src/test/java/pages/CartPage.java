package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage{
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public void cartCheckout(){
        driver.findElement(By.className("wc-forward")).click();
    }


}