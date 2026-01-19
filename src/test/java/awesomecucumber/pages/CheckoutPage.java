package awesomecucumber.pages;

import awesomecucumber.domain.BillingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstnameFld;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneFld;

    @FindBy(id = "billing_city")
    private WebElement billingCityFld;

    @FindBy(id = "billing_state")
    private WebElement billingStateDropDown;

    @FindBy(id = "select2-billing_state-container")
    private WebElement alternateBillingStateDropDown;

    @FindBy(id = "billing_postcode")
    private WebElement billingZipFld;

    @FindBy(id = "billing_email")
    private WebElement billingEmailFld;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneFld;

    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;

    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage enterBillingPhone(String billingPhone){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPhoneFld));
        e.clear();
        e.sendKeys(billingPhone);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingPage billingDetails) {
        return enterBillingFirstName(billingDetails.getFirstName()).
                enterBillingLastName(billingDetails.getLastName()).
                enterBillingAddressLineOne(billingDetails.getAddress()).
                enterBillingCity(billingDetails.getTown()).        // Correct mapping
                        selectBillingState(billingDetails.getStateId()).   // Correct mapping
                        enterBillingZip(billingDetails.getZipCode()).
                enterBillingEmail(billingDetails.getEmailAddress()).
                enterBillingPhone(billingDetails.getPhoneNumber());
    }

    public CheckoutPage placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }
}
