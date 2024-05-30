package org.example.steps;
import org.example.actions.CartPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.actions.WaitUtils;
import org.example.pages.CartPage;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CartPageSteps {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final CartPageActions cartPageActions;
    private final CartPage cartPage;

    public CartPageSteps(){
        this.driver = SetUps.driver;
        this.cartPageActions = new CartPageActions(driver);
        this.cartPage = new CartPage(driver);
        this.waitUtils = new WaitUtils(driver);
    }


    @And("user navigates to Cart page")
    public void navigateToCartPage(){
        cartPage.getCartBtn().click();
        WebElement cartTitle = cartPage.getCartTitle();
        waitUtils.waitForVisibility(cartTitle);
    }


    @And("user remove the products from the cart")
    public void remove_products_from_card(DataTable dataTable){
        cartPage.getCartBtn().click();
        WebElement cartTitle = cartPage.getCartTitle();
        waitUtils.waitForVisibility(cartTitle);
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String product = row.get("product");
            cartPageActions.removeProductFromCart(product);
        }
        cartPage.getContinueShoppingBtn().click();
    }

    @Then("the products are displayed correctly")
    public void verify_products_displayed_correctly(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String product = row.get("product");
            String description = row.get("description");
            String price = row.get("price");
            cartPageActions.verifyProducts(product, description, price);
        }
    }
}
