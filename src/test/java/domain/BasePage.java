package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public BasePage(WebDriver driver){
        this.driver = this.driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        PageFactory.initElements(this.driver,this);

    }
    public void load(String url){
        driver.get(url);
    }
    protected WebDriver driver;
    protected WebDriverWait wait;
}
