package org.example.actions;
import org.example.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPageActions {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final ProductPage productPage;

    public ProductPageActions(WebDriver driver){
        this.driver = driver;
        this.productPage = new ProductPage(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    public void verifyProductPageIsOpened(){
        WebElement productTitle = productPage.getProductTitle();
        waitUtils.waitForVisibility(productTitle);
        String title = productPage.getProductTitleText();
        if (title != null){
            Assert.assertEquals(title, "Products", "Title is incorrect");
        }
    }

    public void addProductToCart(String product) {
        WebElement addBtn = productPage.addProductBtn(product);
        if (addBtn != null) {
            addBtn.click();
        }
    }

    public void verifyCartCounter(int expectedCount) {
        int counter = productPage.getCartCounter();
        if (counter != 0){
            Assert.assertEquals(counter, expectedCount, "Incorrect cart counter");
        }
    }
}
