package stepDefinitions.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {
    public static WebDriver driver;
    public static WebDriver initializerDriver(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");

        return driver;

    }
    public static WebDriver getDriver(){
        return driver;
    }



}
