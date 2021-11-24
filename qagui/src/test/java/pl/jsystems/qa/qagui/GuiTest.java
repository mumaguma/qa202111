package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jsystems.qa.qagui.page.LoginPage;
import pl.jsystems.qa.qagui.page.WordpressMainPage;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuiTest extends GuiConfig {

    @Test
    public void lgInTest() {
        driver.get("https://wordpress.com/");

        WordpressMainPage wordpressMainPage = new WordpressMainPage(driver);

        wordpressMainPage.logIn.click();

        final WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));

        usernameOrEmail.click();
        usernameOrEmail.clear();
        usernameOrEmail.sendKeys("automation112021");
        driver.findElement(By.className("login__form-action")).click();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.findElement(By.id("password")).click();

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test112021");
        driver.findElement(By.className("login__form-action")).click();

        final WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

        assertTrue(avatar.isDisplayed());

        avatar.click();

        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("automation112021");

        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();

    }

    @Test
    public void lgIn() {
        driver.get("https://wordpress.com/");

        WordpressMainPage wordpressMainPage = new WordpressMainPage(driver);

        wordpressMainPage.logIn.click();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUser("automation112021");

        final WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));

        usernameOrEmail.click();
        usernameOrEmail.clear();
        usernameOrEmail.sendKeys("automation112021");
        driver.findElement(By.className("login__form-action")).click();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

//        try {
//            sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.findElement(By.id("password")).click();

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test112021");
        driver.findElement(By.className("login__form-action")).click();

        final WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

        assertTrue(avatar.isDisplayed());

        avatar.click();

        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("automation112021");

        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();

    }

}
