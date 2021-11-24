package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));

    public WebElement logOutButton = driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]"));


    public String getProfileName() {
        visibilityOfElementLocated(By.className("profile-gravatar__user-display-name"), 5);
        return profileName.getText();
    }

    public void clickLogOutButton() {
        click(logOutButton, 3);
    }
}
