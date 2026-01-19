package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import stepDefinitions.factory.DriverFactory;

public class MyHooks {
    private WebDriver driver;

    @Before
    public void before() {
        driver = DriverFactory.initializerDriver();

    }

    @After
    public void after() {
        driver.quit();



    }

}
