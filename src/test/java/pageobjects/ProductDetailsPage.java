package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.GenericMethods;

public class ProductDetailsPage {
    WebDriver driver;
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
       PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "https://magento.softwaretestingboard.com/ariel-roll-sleeve-sweatshirt.html")
    WebElement linkProductDetailsPage;
    @FindBy(xpath = "//span[contains(text(), 'Ariel Roll Sleeve Sweatshirt')]")
    WebElement textProductName;
    @FindBy(xpath = "//*[contains(text(), 'WH09')]")
    WebElement textProductSKU;
    @FindBy(xpath = "//div[@class='product attribute description']//div[@class='value']")
    WebElement textProductDescription;
    @FindBy(xpath = "//div[@id='option-label-size-143-item-168']")
    WebElement selectSizeMedium;
    @FindBy(xpath = "//div[@id='option-label-color-93-item-53']")
    WebElement selectColorGreen;
    @FindBy(xpath = "//input[@id='qty']")
    WebElement inputQTY;
    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")
    WebElement linkAddToWishList;
    @FindBy(xpath = "//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")
    WebElement linkAddToCompare;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement buttonShowCartOpen;
    @FindBy(xpath = "//button[@id='btn-minicart-close']")
    WebElement buttonShowCartClose;
    @FindBy(xpath = "//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")
    WebElement messageProductAdded;
    @FindBy(linkText = "//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")
    WebElement linkShoppingCart;
    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement buttonProceedToCheckout;
    @FindBy(xpath = "//span[@class='count']")
    WebElement textItemInCart;
    @FindBy(xpath = "//span[@data-bind='html: cart().subtotal_excl_tax']")
    WebElement textCartSubtotal;
    @FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
    WebElement linkViewEditCart;
    @FindBy(xpath = "//footer[@class='page-footer']")
    WebElement footerAllText;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void addToCartSelection(){
        try {
            Assert.assertTrue(buttonAddToCart.isDisplayed());
        }catch (AssertionError e){
            System.out.println("- [Add to Cart] button is NOT displayed");
        }
    }
    public void sizeSelection(){
        selectSizeMedium.click();
    }
    public void colorSelection() {
        selectColorGreen.click();
    }
    public void inputQTY(){
        inputQTY.clear();
        inputQTY.sendKeys("2");
    }
    public String productInfo() {
        return textProductName.getText()+"  |  SKU#: "+textProductSKU.getText();
    }
    public String productDescription(){
        return textProductDescription.getText();
    }
    public void addProductToCart(){
        buttonAddToCart.click();
        GenericMethods.pauseExecutionFor(2);
    }
    public void viewFooter(){
        footerAllText.isDisplayed();
    }
    public void proceedToCheckout(){
        buttonShowCartOpen.click();
        GenericMethods.pauseExecutionFor(1);
//        System.out.println("- Item QTY: "+textItemInCart.getText());
//        System.out.println("- Subtotal: "+textCartSubtotal.getText());
        buttonProceedToCheckout.click();
    }






}
