package pl.jsystems.qa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GuiConfiguration {

    protected WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new ChromeDriver();

        setUpMachine();
        setUpDriver();

    }

    private void setUpMachine() {
        if (GuiConfig.MACHINE.equals("local")) {
            setUpLocalConfiguration();
        } else {
            setUpRemoteConfiguration();
        }
    }

    private void setUpRemoteConfiguration() {

    }

    private void setUpLocalConfiguration() {
        driver = setWebDriver();
    }

    private void setUpDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    private WebDriver setWebDriver() {
        switch (GuiConfig.BROWSER) {
            case "chrome":
                setUpChromeEnv();
                return new ChromeDriver();
            case "firefox":
                setUpFirefoxEnv();
                return new FirefoxDriver();
            case "edge":
                setUpEdgeEnv();
                return new EdgeDriver();
        }
        return new FirefoxDriver();
    }


    private void setUpChromeEnv() {
        setUpEnv("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    private void setUpFirefoxEnv() {
        setUpEnv("webdriver.gecko.driver", "drivers/geckodriver.exe");
    }

    private void setUpEdgeEnv() {
        setUpEnv("webdriver.edge.driver", "driver/msedgedriver.exe");
    }

    private void setUpEnv(String envName, String path) {
        try {
            System.setProperty(envName, Paths.get(getClass().getClassLoader()
                    .getResource(path).toURI()).toFile().getAbsolutePath());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
