package org.example.steps;
import org.example.actions.CheckoutPageActions;
import org.example.actions.WaitUtils;
import org.example.pages.CheckoutPage;
import org.example.actions.CartPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CheckoutPageSteps {

    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final CheckoutPageActions checkoutPageActions;
    private final CheckoutPage checkoutPage;
    private final CartPageActions cartPageActions;


    public CheckoutPageSteps(){
        this.driver = SetUps.driver;
        this.checkoutPageActions = new CheckoutPageActions(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.cartPageActions = new CartPageActions(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    @And("user navigates to Checkout page")
    public void clickCheckoutBtn(){
        checkoutPage.getCheckoutBtn().click();
        WebElement checkoutTitle = checkoutPage.getCheckoutInformationTitle();
        waitUtils.waitForVisibility(checkoutTitle);

    }

    @And("user submit the checkout form")
    public void submitCheckoutForm(){
        checkoutPage.getContinueBtn().click();
    }

    @Then("the error message is displayed correctly")
    public void verifyErrorMessageDisplayed(){
        checkoutPageActions.verifyErrorMessage();
    }

    @And("user clears the checkout form")
    public void dismissCheckoutFormError(){
        checkoutPage.getCloseErrorBtn().click();
    }

    @And("user fills in the checkout form")
    public void fillCheckoutForm(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String firstName = row.get("first name");
            String lastName = row.get("last name");
            String code = row.get("code");
            checkoutPageActions.fillCheckoutForm(firstName, lastName, code);
        }
    }

    @And ("user continue to the checkout overview")
    public void continueToCheckoutOverview(){
        checkoutPage.getContinueBtn().click();
        WebElement checkoutOverviewTitle = checkoutPage.getCheckoutOverviewTitle();
        waitUtils.waitForVisibility(checkoutOverviewTitle);
    }

    @Then("the payment information is displayed correctly")
    public void verifyPaymentInformation(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String paymentInfo = row.get("payment info");
            String shippingInfo = row.get("shipping info");
            String itemsTotal = row.get("items total");
            String tax = row.get("tax");
            String totalPrice = row.get("total price");
            checkoutPageActions.verifyPaymentInformation(paymentInfo, shippingInfo, itemsTotal, tax, totalPrice);
        }
    }

    @And("user finish the order")
    public void complete_order(){
        checkoutPageActions.finishOrder();
        WebElement completeTitle = checkoutPage.getCompleteTitle();
        waitUtils.waitForVisibility(completeTitle);
    }


    @Then("the order is successful")
    public void verify_successful_order(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String successTitle = row.get("successful order title");
            String successMessage = row.get("successful order message");
            checkoutPageActions.verifySuccessfulOrder(successTitle, successMessage);
        }
    }




}
