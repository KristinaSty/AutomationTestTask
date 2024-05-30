package org.example.steps;
import org.example.actions.ProductPageActions;
import org.example.pages.ProductPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class ProductPageSteps {
    private final WebDriver driver;
    private final ProductPageActions productPageActions;

    private final ProductPage productPage;


    public ProductPageSteps(){
        this.driver = SetUps.driver;
        this.productPage = new ProductPage(driver);
        this.productPageActions = new ProductPageActions(driver);
    }

    @When("the product page is opened") //done
    public void verify_product_page_is_opened() {
        productPageActions.verifyProductPageIsOpened();
    }

    @And("user add products to the card")
    public void add_products_to_the_card(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows){
            String product = row.get("product");
            productPageActions.addProductToCard(product);
        }
    }

    @Then("the cart is displayed correctly on the product page")
    public void verify_card_counter(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String cartCounterStr = row.get("cart counter");
            int cartCounter;
            try {
                cartCounter = Integer.parseInt(cartCounterStr);
            } catch (NullPointerException |
                     IndexOutOfBoundsException |
                     NumberFormatException e){
                cartCounter = 0;
            }
            productPageActions.verifyCardCounter(cartCounter);
        }
    }

}
