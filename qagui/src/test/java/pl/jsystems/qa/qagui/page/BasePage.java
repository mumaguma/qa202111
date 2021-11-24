package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
