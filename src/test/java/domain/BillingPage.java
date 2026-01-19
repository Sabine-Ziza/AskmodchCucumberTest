package domain;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.Map;

    public class BillingPage {

        WebDriver driver;

        public BillingPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }



        public WebDriver getDriver() {
            return driver;
        }

        public void setDriver(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement getFirstName() {
            return firstName;
        }

        public void setFirstName(WebElement firstName) {
            this.firstName = firstName;
        }

        public WebElement getLastName() {
            return lastName;
        }

        public void setLastName(WebElement lastName) {
            this.lastName = lastName;
        }

        public WebElement getAddress() {
            return address;
        }

        public void setAddress(WebElement address) {
            this.address = address;
        }

        public WebElement getTown() {
            return town;
        }

        public void setTown(WebElement town) {
            this.town = town;
        }

        public WebElement getStateId() {
            return stateId;
        }

        public void setStateId(WebElement stateId) {
            this.stateId = stateId;
        }

        public WebElement getZipCode() {
            return zipCode;
        }

        public void setZipCode(WebElement zipCode) {
            this.zipCode = zipCode;
        }

        public WebElement getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(WebElement emailAddress) {
            this.emailAddress = emailAddress;
        }

        public WebElement getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(WebElement phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public BillingPage(String firstname,
                           String lastname, String addressLine1,
                           String city, String state, String zip,
                           String email) {
        }

        public void fillBillingDetails(Map<String, String>  billingDetails) {

            firstName.clear();
            firstName.sendKeys(billingDetails.get("firstname"));

            lastName.clear();
            lastName.sendKeys(billingDetails.get("lastname"));

            address.clear();
            address.sendKeys(billingDetails.get("address_line1"));

            town.clear();
            town.sendKeys(billingDetails.get("city"));

            Select select = new Select(stateId);
            select.selectByVisibleText(billingDetails.get("state"));

            zipCode.clear();
            zipCode.sendKeys(billingDetails.get("zip"));

            emailAddress.clear();
            emailAddress.sendKeys(billingDetails.get("email"));

            phoneNumber.clear();
            phoneNumber.sendKeys(billingDetails.get("phone"));
        }
    }


