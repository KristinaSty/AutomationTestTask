package org.example.actions;
import org.example.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPageActions {
    private WebDriver driver;

    private WaitUtils waitUtils;
    private CartPage cartPage;
    public CartPageActions(WebDriver driver){

        this.driver = driver;
        this.cartPage = new CartPage(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    public void removeProductFromCart(String product) {
        WebElement removeBtn = cartPage.removeProductsFromCart(product);
        if (removeBtn != null){
            removeBtn.click();
        }
    }

    public void verifyProducts(String product, String description, String price){
        List<WebElement> products = cartPage.getListItems();
        for (WebElement elem : products) {
            WebElement productElem = elem.findElement(By.className("inventory_item_name"));
            String productName = productElem.getText();
            if (productName.equals(product)) {
                List<WebElement> productItems = productElem.findElements(By.className("inventory_item_desc"));
                for (WebElement desc : productItems) {
                    String elemDesc = desc.getText();
                    Assert.assertEquals(elemDesc, description, "Incorrect description");
                }
                List<WebElement> productPrice = productElem.findElements(By.className("inventory_item_price"));
                for (WebElement prodPrice : productPrice) {
                    String elemPrice = prodPrice.getText();
                    Assert.assertEquals(elemPrice, price, "Incorrect price");
                }
            }
        }
    }
}
