package pl.jsystems.qa.qagui.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(ConfigStep configStep) {
        this.driver = configStep.setUpWebDriver();
    }

    @Given("User starts on main page")
    public void userStartsOnMainPage() {

    }

    @When("user logs to the user panel")
    public void userLogsToTheUserPanel() {

    }

    @Then("User can modify user profile")
    public void userCanModifyUserProfile() {
    }
}
