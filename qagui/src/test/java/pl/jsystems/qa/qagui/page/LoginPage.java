package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement userLogInput = driver.findElement(By.id("usernameOrEmail"));

    public WebElement userContinueButton =  driver.findElement(By.className("login__form-action"));

    public WebElement passLogInput = driver.findElement(By.id("password"));

    public WebElement passConfirmButton = driver.findElement(By.className("login__form-action"));

    public void enterUser(String userName) {
        this.userLogInput.click();
        this.userLogInput.clear();
        this.userLogInput.sendKeys(userName);
    }

}
