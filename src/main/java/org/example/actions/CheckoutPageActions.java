package org.example.actions;
import org.example.pages.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Stream;

public class CheckoutPageActions {
    private final WebDriver driver;
    private final CheckoutPage checkoutPage;


    public CheckoutPageActions(WebDriver driver) {
        this.driver = driver;
        this.checkoutPage = new CheckoutPage(driver);
    }

    public void verifyErrorMessage() {
        String errorText = checkoutPage.getErrorText();
        Assert.assertEquals(errorText, "Error: First Name is required", "Incorrect error message");
    }

    public void fillCheckoutForm(String firstName, String lastName, String code) {
        List<WebElement> fields = checkoutPage.getFormFields();
        if (!fields.isEmpty()){
            for (WebElement field : fields){
                List<WebElement> forms = field.findElements(By.tagName("input"));
                for (WebElement elem : forms){
                    String formPlaceholder = elem.getAttribute("placeholder");
                    if (formPlaceholder.equals("First Name")){
                        elem.sendKeys(firstName);
                        continue;
                    }
                    if (formPlaceholder.equals("Last Name")) {
                        elem.sendKeys(lastName);
                        continue;
                    }
                    if (formPlaceholder.equals("Zip/Postal Code")){
                        elem.sendKeys(code);
                    }
                }
            }
        }
    }

    public void verifyPaymentInformation(String paymentInfo, String shippingInfo, String itemsTotal, String tax, String totalPrice) {
        List<String> summaryInfo = checkoutPage.getSummaryInfo();
        boolean verified = false;
        if(Stream.of(paymentInfo, shippingInfo, itemsTotal, tax, totalPrice).allMatch(summaryInfo::contains)){
            verified = true;
        }
        Assert.assertTrue(verified, "Incorrect payment information.");
    }

    public void finishOrder() {
        checkoutPage.getFinishBtn().click();
    }

    public void verifySuccessfulOrder(String successTitle, String successMessage){
        List<String> successOrderMessage = checkoutPage.getSuccessOrderTitle();
        boolean verified = false;
        if(Stream.of(successTitle, successMessage).allMatch(successOrderMessage::contains)){
            verified = true;
        }
        Assert.assertTrue(verified, "Incorrect message for successful order.");
    }

}
