package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCartTitle(){
        WebElement cartTitle = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String titleText = cartTitle.getText();
        if(titleText.equals("Your Cart")){
            return cartTitle;
        }
        return null;
    }

    public List<WebElement> getListItems(){
        List<WebElement> listItems = driver.findElements(By.className("cart_item"));
        return listItems;
    }

    public WebElement removeProductsFromCart(String product){
        List<WebElement> products = getListItems();
        for (WebElement elem : products){
            WebElement productElem = elem.findElement(By.className("inventory_item_name"));
            String productName = productElem.getText();
            if (productName.equals(product)){
                WebElement pricebar = elem.findElement(By.className("item_pricebar"));
                String buttonId = "remove-" + product.toLowerCase().replace(" ", "-");
                return pricebar.findElement(By.id(buttonId));
            }
        }
        return null;
    }

    public WebElement getCartBtn(){
        WebElement cartBtn = driver.findElement(By.id("shopping_cart_container"));
        return cartBtn;
    }

    public WebElement getContinueShoppingBtn(){
        WebElement continueShoppingBtn = driver.findElement(By.id("continue-shopping"));
        return continueShoppingBtn;
    }
}
