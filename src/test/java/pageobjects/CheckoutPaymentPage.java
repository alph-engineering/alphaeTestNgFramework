package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericMethods;
import utils.ReadData;

import static utils.ReadData.propertyPay;

public class CheckoutPaymentPage {
    WebDriver driver;
    ReadData readData;
    public CheckoutPaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "https://magento.softwaretestingboard.com/checkout/#payment")
    WebElement linkCheckoutPayment;
    @FindBy(xpath = "//td[@data-bind='attr: {'data-th': title}']")
    WebElement textOrderTotal;
    @FindBy(xpath = "//div[@class='opc-block-summary']")
    WebElement textOrderSummary;
    @FindBy(xpath = "//input[@id='billing-address-same-as-shipping-checkmo']")
    WebElement buttonBillingShippingSame;
    @FindBy(xpath = "//div[@class='ship-to']//div[@class='shipping-information-content']")
    WebElement textOrderShippingDetails;
    @FindBy(xpath = "//div[@class='shipping-information-content']//span[@class='value']")
    WebElement textOrderShippingMethod;
    @FindBy(xpath = "//span[@id='block-discount-heading']")
    WebElement applyDiscountCode;
    @FindBy(xpath = "//input[@id='discount-code']")
    WebElement enterDiscountCode;
    @FindBy(xpath = "//button[@value='Apply Discount']//span//span[contains(text(),'Apply Discount')]")
    WebElement buttonApplyDiscount;
    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    WebElement buttonPaceOrder;

    public void verifyBillingShippingSync(){
        System.out.println("- Current URL: " +driver.getCurrentUrl());
        if (!buttonBillingShippingSame.isSelected()){
            buttonBillingShippingSame.click();
        }
    }
    public void inputCouponCode(){
        readData = new ReadData();
        applyDiscountCode.click();
        //enterDiscountCode.click();
        enterDiscountCode.sendKeys(propertyPay.getProperty("discountCode"));
        buttonApplyDiscount.click();
        GenericMethods.pauseExecutionFor(2);
    }
    public void finalOrderSummary(){
        System.out.println(" ");
        System.out.println(textOrderSummary.getText());
        System.out.println(" ");
        System.out.println("Ship To: "+textOrderShippingDetails.getText());
        System.out.println("Shipping Method: "+textOrderShippingMethod.getText());
        System.out.println(" ");
    }
    public void finalizeOrder(){
        buttonPaceOrder.click();
        GenericMethods.pauseExecutionFor(6);
    }
}
