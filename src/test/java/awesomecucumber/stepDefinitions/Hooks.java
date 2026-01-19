package awesomecucumber.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import awesomecucumber.pages.HomePage;


public class Hooks {

    public static WebDriver driver;
    public static HomePage homepage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com");
        homepage = new HomePage(driver);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
