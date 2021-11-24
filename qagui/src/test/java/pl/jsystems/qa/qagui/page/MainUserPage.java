package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainUserPage extends BasePage {

    public MainUserPage(WebDriver driver) {
        super(driver);
    }

    public WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

    public void clickAvatar() {
        click(this.avatar, 5);
    }

}
