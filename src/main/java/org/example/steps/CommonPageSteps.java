package org.example.steps;
import org.example.actions.CommonPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class CommonPageSteps {
    private final WebDriver driver;
    private final CommonPageActions commonPageActions;

    public CommonPageSteps(){
        this.driver = SetUps.driver;
        this.commonPageActions = new CommonPageActions(driver);
    }

    @Given("user is logged in")
    public void user_logged_in() {
        commonPageActions.login();
        commonPageActions.handleChangePasswordAlert();
    }

    @And("user logged out")
    public void logging_out() {
        commonPageActions.logout();
    }
}
