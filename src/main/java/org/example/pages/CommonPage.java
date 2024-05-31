package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {

    private final WebDriver driver;
    public CommonPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement enterUserName(){
        WebElement usernameField = driver.findElement(By.id("user-name"));
        return usernameField;
    }

    public WebElement enterPassword(){
        WebElement passwordField = driver.findElement(By.id("password"));
        return  passwordField;
    }

    public WebElement clickLoginBtn(){
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        return loginBtn;
    }

    public WebElement getMenuBtn(){
        WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
        return  menuBtn;
    }

    public WebElement getBarMenu(){
        WebElement barMenu = driver.findElement(By.className("bm-menu"));
        return barMenu;
    }
    public WebElement getLogoutBtn(){
        WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
        return logoutBtn;
    }

    public WebElement getSwagLabsTitle(){
        WebElement swagLabsTitle = driver.findElement(By.className("login_logo"));
        return swagLabsTitle;
    }
}
