package base;

import awesomecucumber.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Initialize driver and wait for each scenario
    protected void initDriver() {
        driver = Hooks.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
