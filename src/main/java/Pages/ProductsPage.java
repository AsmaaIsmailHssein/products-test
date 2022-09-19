package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private By homepageBtn = By.xpath("//a[@style=\"color: orange;\"]");
    private By productBtn = By.xpath("//a[@href=\"/products\"]");
    private By allProducts = By.cssSelector("h2.title");
    private By searchField = By.id("search_product");
    private By searchBtn = By.cssSelector("button#submit_search");
    private By searchedProducts = By.className("title");
    private By relatedProduct1 = By.xpath("//p[text()=\"Madame Top For Women\"]");
    private By relatedProduct2 = By.xpath("//p[text()=\"Lace Top For Women\"]");
    private By addToCartBtn = By.xpath("//div[@class=\"overlay-content\"]//a[@class=\"btn btn-default add-to-cart\"]");
    private By addToCartBtn2 = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[4]");
    private By continueShoppingBtn = By.className("btn-block");
    private By viewCartBtn = By.xpath("//p//a[@href=\"/view_cart\"]");
    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }
    public ProductsPage clickOnProductBtn()
    {
        clickElement(productBtn);
        return new ProductsPage(driver);
    }
    public String getCssValueOfHomeBtn()
    {
        return getCssColorValue(homepageBtn);

    }
    public String checkNavigatedToAllProducts()
    {
        return getTextOfElement(allProducts);
    }
    public void typeInSearchField(String productName)
    {
        typeOnInputField(searchField,productName);
    }
    public void clickSearchButton()
    {
        clickElement(searchBtn);
    }
    public boolean checkVisibilityOfText()
    {
        return isElementDisplay(searchedProducts);
    }
    public String checkRelatedSearchProduct1()
    {
        return getTextOfElement(relatedProduct1);
    }
    public String checkRelatedSearchProduct2()
    {
        return getTextOfElement(relatedProduct2);
    }
    public void clickOnAddToCartButton()
    {
        clickElement(addToCartBtn);
    }
    public void clickOnAddToCartButton2()
    {
        clickElement(addToCartBtn2);
    }
    public void clickOnContinueShoppingButton()
    {
        clickElement(continueShoppingBtn);
    }
    public CartPage clickOnViewCartButton()
    {
        clickElement(viewCartBtn);
        return new CartPage(driver);
    }

}
