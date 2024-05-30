package org.example.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SetUps {
    public static WebDriver driver;
    public final static int TIMEOUT = 5;
    @Before
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
