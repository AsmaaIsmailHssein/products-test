package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By product1 = By.xpath("//a[@href=\"/product_details/1\"]");
    private By product2 = By.xpath("//a[@href=\"/product_details/2\"]");

    private By priceOfProduct1 = By.xpath("(//td[@class=\"cart_price\"])[1]");
    private By priceOfProduct2 = By.xpath("(//td[@class=\"cart_price\"])[2]");
    private By quantityOfProduct = By.className("cart_quantity");
    private By totalPriceOfProduct1 = By.xpath("(//p[@class=\"cart_total_price\"])[1]");
    private By totalPriceOfProduct2 = By.xpath("(//p[@class=\"cart_total_price\"])[2]");


    public CartPage(WebDriver driver)
    {
        super(driver);
    }
    public boolean checkVisibilityOfProduct1()
    {
        return isElementDisplay(product1);
    }
    public boolean checkVisibilityOfProduct2()
    {
        return isElementDisplay(product2);
    }
    public String checkPriceOfProduct1()
    {
        return getTextOfElement(priceOfProduct1);
    }
    public String checkPriceOfProduct2()
    {
        return getTextOfElement(priceOfProduct2);
    }
    public String checkQuantityOfProduct()
    {
        return getTextOfElement(quantityOfProduct);
    }
    public String checkTotalPriceOfProduct1()
    {
        return getTextOfElement(totalPriceOfProduct1);
    }
    public String checkTotalPriceOfProduct2()
    {
        return getTextOfElement(totalPriceOfProduct2);
    }
}
