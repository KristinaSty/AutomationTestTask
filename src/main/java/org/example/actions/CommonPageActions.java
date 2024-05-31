package org.example.actions;
import org.example.pages.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPageActions {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final CommonPage commonPage;
    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    public CommonPageActions(WebDriver driver){
        this.driver = driver;
        this.commonPage = new CommonPage(driver);
        this.waitUtils = new WaitUtils(driver);
    }

     public void login(){
        WebElement userNameInput = commonPage.enterUserName();
        userNameInput.sendKeys(USERNAME);
        WebElement passwordInput = commonPage.enterPassword();
        passwordInput.sendKeys(PASSWORD);
        WebElement loginBtn = commonPage.clickLoginBtn();
        loginBtn.click();
     }

    public void logout() {
        commonPage.getMenuBtn().click();
        WebElement barMenu = commonPage.getBarMenu();
        waitUtils.waitForVisibility(barMenu);
        commonPage.getLogoutBtn().click();
        WebElement swagTitle = commonPage.getSwagLabsTitle();
        waitUtils.waitForVisibility(swagTitle);
    }

    public void handleChangePasswordAlert(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
        } catch(NoAlertPresentException e) {
            System.out.println("No alert present");

        }
    }
}
