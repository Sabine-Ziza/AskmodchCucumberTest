package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By accountLink = By.linkText("Account");
    private By addCartButton = By.cssSelector(".btn.btn-success.btn-lg");
    private By cartIcon = By.className("count");
    private By shopNowButton = By.className("wp-block-button__link");
    private By findMoreButton = By.className("wp-block-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public HomePage clickAccountLink(){
        driver.findElement(accountLink).click();
        return this;
    }

    public StorePage clickStoreLink(){
        clickLink("Store");
        return new StorePage(driver);
    }



}
