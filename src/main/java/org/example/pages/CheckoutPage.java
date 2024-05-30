package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCheckoutInformationTitle(){
        WebElement cartTitle = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String titleText = cartTitle.getText();
        if(titleText.equals("Checkout: Your Information")){
            return cartTitle;
        }
        return null;
    }

    public WebElement getCheckoutOverviewTitle(){
        WebElement cartTitle = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String titleText = cartTitle.getText();
        if(titleText.equals("Checkout: Overview")){
            return cartTitle;
        }
        return null;
    }

    public WebElement getCompleteTitle(){
        WebElement cartTitle = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String titleText = cartTitle.getText();
        if(titleText.equals("Checkout: Complete!")){
            return cartTitle;
        }
        return null;
    }
    public WebElement getCheckoutBtn(){
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        return checkoutBtn;
    }
    public WebElement getContinueBtn(){
        WebElement continueBtn = driver.findElement(By.id("continue"));
        return continueBtn;
    }

    public WebElement getCloseErrorBtn(){
        WebElement closeBtn = driver.findElement(By.className("error-button"));
        return closeBtn;
    }

    public WebElement getFinishBtn(){
        WebElement finishBtn = driver.findElement(By.id("finish"));
        return finishBtn;
    }

    public String getErrorText(){
        List<WebElement> errorMessage = driver.findElements(By.cssSelector("h3[data-test='error']"));
        for (WebElement element : errorMessage){
            String errorText = element.getText();
            return errorText;
        }
        return null;
    }

    public List<WebElement> getFormFields() {
        List<WebElement> checkoutInfo = driver.findElements(By.className("checkout_info"));
        for (WebElement element : checkoutInfo) {
            List<WebElement> formFields = element.findElements(By.className("form_group"));
            return formFields;
        }
        return new ArrayList<>();
    }

    public List<String> getSummaryInfo(){
        List<WebElement> summaryInfo = driver.findElements(By.className("summary_info"));
        List<String> infoText = new ArrayList<>();
        for (WebElement info : summaryInfo){
            List<WebElement> infoElem = info.findElements(By.cssSelector("div[class^='summary_']"));
            for (WebElement element : infoElem){
                infoText.add(element.getText());
            }
        }
        return infoText;
    }

    public List<String> getSuccessOrderTitle(){
        WebElement successOrderTitle = driver.findElement(By.className("complete-header"));
        WebElement successOrderMessage = driver.findElement(By.className("complete-text"));
        List<String> successOrderText = new ArrayList<>();
        successOrderText.add(successOrderTitle.getText());
        successOrderText.add(successOrderMessage.getText());
        return  successOrderText;
    }

}
