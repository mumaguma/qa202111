package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordpressMainPage extends BasePage {

    public WordpressMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement logIn = driver.findElement(By.linkText("Log In"));

}
