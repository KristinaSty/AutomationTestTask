package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getProductTitle(){
        WebElement productTitle = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String titleText = productTitle.getText();
        if(titleText.equals("Products")){
            return productTitle;
        }
        return null;
    }

    public String getProductTitleText(){
        WebElement title = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        String text = title.getText();
        return text;
    }

    public List<WebElement> getInventoryItems(){
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        return inventoryItems;
    }

    public WebElement addProductBtn(String product){
        List<WebElement> items = getInventoryItems();
        for (WebElement item : items){
            WebElement itemElements = item.findElement(By.className("inventory_item_name"));
            String itemName = itemElements.getText();
            if (itemName.equals(product)){
                WebElement pricebar = item.findElement(By.className("pricebar"));
                String buttonId = "add-to-cart-" + product.toLowerCase().replace(" ", "-");
                return pricebar.findElement(By.id(buttonId));
            }
        }
        return null;
    }

    public int getCartCounter(){
        List<WebElement> cart = driver.findElements(By.id("shopping_cart_container"));
        for(WebElement elements : cart){
            try {
                WebElement counter = elements.findElement(By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']"));
                if (counter.isDisplayed()){
                    String counterText = counter.getText();
                    return Integer.parseInt(counterText);
                }
            } catch (NoSuchElementException e) {
                return 0;
            }
        }
        return 0;
    }
}
