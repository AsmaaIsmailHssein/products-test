package Tests;

import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTests extends BaseTests {

    @Test(priority = 0)
    public void searchedProductTest()
    {
         ProductsPage productsPage = new ProductsPage(driver);
         //verify visibility of homepage by color
         Assert.assertEquals(productsPage.getCssValueOfHomeBtn(),"rgba(255, 165, 0, 1)");
         productsPage.clickOnProductBtn();

        //check navigation to all products page
        Assert.assertEquals(productsPage.checkNavigatedToAllProducts(),"ALL PRODUCTS");

        productsPage.typeInSearchField("top for women");
        productsPage.clickSearchButton();
        Assert.assertTrue(productsPage.checkVisibilityOfText(),"the searched products should be visible");
        Assert.assertTrue(productsPage.checkRelatedSearchProduct1().contains("Top For Women"));
        Assert.assertTrue(productsPage.checkRelatedSearchProduct2().contains("Top For Women"));

    }

}
