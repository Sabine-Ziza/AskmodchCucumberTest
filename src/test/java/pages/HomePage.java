package pages;

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

//    public CategoryDropdown clickDropdown(){
//        clickLink("Store");
//        return new CategoryDropdown(driver);
//    }
    public HomePage clickAccountLink(){
        driver.findElement(accountLink).click();
        return this;
    }
//    public MenNavigationPage menLink(){
//        clickLink("Men");
//        return new MenNavigationPage(driver);
//    }
//    public WomenNavigationPage womenLink(){
//        clickLink("Women");
//        return new WomenNavigationPage(driver);
//    }
//    public AccessoriesPage accesoriesLink(){
//        clickLink("Accessories");
//        return new AccessoriesPage(driver);
//    }
//    public AboutPage aboutLink(){
//        clickLink("About");
//        return new AboutPage(driver);
//    }
//    public void hoverCartIcon(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(cartIcon)).perform();
//    }
//    public ShopNowPage clickShopNowbutton(){
//        driver.findElement(shopNowButton).click();
//        return new ShopNowPage(driver);
//    }
    public StorePage clickStoreLink(){
        clickLink("Store");
        return new StorePage(driver);
    }



}
