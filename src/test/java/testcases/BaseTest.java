package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.BrowserFactory;
import utils.GenericMethods;
import utils.ReadData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static utils.ReadData.propertyConfig;

public class BaseTest {
    WebDriver driver = null;
    HomePage homePage;
    ProductPage productPage;
    ProductDetailsPage productDetailsPage;
    CheckoutShippingPage checkoutShippingPage;
    CheckoutPaymentPage checkoutPaymentPage;
    CheckoutFinalPage checkoutFinalPage;

    @BeforeClass(groups = "all")
    public void setUp(){
        driver = BrowserFactory.launchGivenBrowser("browser");
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutFinalPage = new CheckoutFinalPage(driver);
    }

    @Test(priority = 1, groups = {"all"})
    public void confirmApplicationLaunch(){
        try {
            Assert.assertTrue(homePage.verifyFooterIsAvailable());
            System.out.println("- Application Launched Successfully");
        }catch (AssertionError e){
            System.out.println("- Application Failed");
        }
    }
    @Test(priority = 2, groups = {"all"})
    public void confirmProductsListed(){
        System.out.println(" ");
        System.out.println("- Current URL: "+homePage.getCurrentUrl());
        System.out.println(" ");
        Assert.assertTrue((homePage.verifyEcoFriendlyProductsAvailable()));
        System.out.println("- Shop Eco Friendly Products Available");
    }
    @Test(priority = 3, groups = {"all"})
    public void confirmLinkNavigation(){
        homePage.clickEcoFriendlyProductsButton();
        System.out.println("- Button 'Shop Eco-Friendly' Clicked");
        GenericMethods.pauseExecutionFor(2);
        System.out.println(" ");
        System.out.println("- Current URL: "+productPage.getCurrentUrl());
        System.out.println(" ");
        try {
            Assert.assertNotSame(productPage.getCurrentUrl(), homePage.getCurrentUrl());
            System.out.println("- URL Navigation Successful");
        }catch (AssertionError e){
            System.out.println("- URL Navigation Failed");
        }
    }
    @Test(priority = 4, groups = {"all"})
    public void selectProductWH09() {
        GenericMethods.pauseExecutionFor(2);
        //productPage.selectProduct(); // driver
        productPage.actionSelectProduct(); // Actions
        System.out.println("- Product 'Ariel Roll Sleeve Sweatshirt' Selected");
        GenericMethods.pauseExecutionFor(2);
    }
    @Test(priority = 5, groups = {"all"})
    public void confirmAddToCartSelection(){
        productDetailsPage.addToCartSelection();
        System.out.println("- [Add to Cart] button is displayed");
    }
    @Test(priority = 6, groups = {"all"})
    public void getProductDetails() {
        System.out.println(" ");
        System.out.println("- Current URL: " + productDetailsPage.getCurrentUrl());
        System.out.println(" ");
        System.out.println("- Product: " + productDetailsPage.productInfo());
        System.out.println("- Description: " + productDetailsPage.productDescription());
        System.out.println(" ");
    }
    @Test(priority = 7, groups = {"all"})
    public void confirmSizeSelection(){
        productDetailsPage.sizeSelection();
    }
    @Test(priority = 8, groups = {"all"})
    public void confirmColorSelection(){
        productDetailsPage.colorSelection();
    }
   @Test(priority = 9, groups = {"all"})
    public void editQTY(){
        productDetailsPage.inputQTY(); // Clears entry & Inputs '2'
    }
    @Test (priority = 10, groups = {"all"})
    public void addItemToCart(){
        productDetailsPage.addProductToCart();
        GenericMethods.pauseExecutionFor(4);
    }
    @Test(priority = 11, groups = {"all"})
    public void viewFooter(){
        productDetailsPage.viewFooter();
    }
    @Test(priority = 12, groups = {"all"})
    public void proceedToCheckout(){
        productDetailsPage.proceedToCheckout();
        GenericMethods.pauseExecutionFor(5);
    }
    @Test(priority = 13, groups = {"all"})
    public void confirmShipping(){
        Assert.assertTrue(checkoutShippingPage.verifyOrderSummary());
        checkoutShippingPage.orderSummary();
        checkoutShippingPage.enterShippingDetails();
    }
    @Test(priority = 14, groups = {"all"})
    public void confirmPayment(){
        GenericMethods.pauseExecutionFor(5);
        checkoutPaymentPage.verifyBillingShippingSync();
        checkoutPaymentPage.finalOrderSummary();
        checkoutPaymentPage.inputCouponCode();
        checkoutPaymentPage.finalizeOrder();
    }
    @Test(priority=15, groups = {"all"})
    public void confirmOrderSuccess(){
        checkoutFinalPage.confirmOrderComplete();
    }

   @AfterClass(groups = "all")
    public void tearDown(){
        driver.quit();
        System.out.println("- Application Closed Successfully");
    }

}
// alph.engineering
