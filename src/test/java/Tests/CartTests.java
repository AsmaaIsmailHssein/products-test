package Tests;

import Pages.CartPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTests extends BaseTests{
    @Test(priority = 1)
    public void addToCartTest()
    {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnProductBtn();

        List<WebElement> hoverOverProduct = driver.findElements(By.className("productinfo"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverProduct.get(0)).perform();
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnContinueShoppingButton();

        actions.moveToElement(hoverOverProduct.get(1)).perform();
        productsPage.clickOnAddToCartButton2();
        CartPage cartPage = productsPage.clickOnViewCartButton();

        Assert.assertTrue(cartPage.checkVisibilityOfProduct1(),"the first product should be visible");
        Assert.assertTrue(cartPage.checkVisibilityOfProduct2(),"the second product should be visible");

        Assert.assertEquals(cartPage.checkPriceOfProduct1(),"Rs. 500");
        Assert.assertEquals(cartPage.checkPriceOfProduct2(),"Rs. 400");

        Assert.assertEquals(cartPage.checkQuantityOfProduct(),"1");
        Assert.assertEquals(cartPage.checkQuantityOfProduct(),"1");

        Assert.assertEquals(cartPage.checkTotalPriceOfProduct1(),"Rs. 500");
        Assert.assertEquals(cartPage.checkTotalPriceOfProduct2(),"Rs. 400");
    }


}
