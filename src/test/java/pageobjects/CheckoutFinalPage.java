package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadData;

public class CheckoutFinalPage {
    WebDriver driver;
    public CheckoutFinalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "https://magento.softwaretestingboard.com/checkout/onepage/success/")
    WebElement linkCheckoutFinal;
    @FindBy(xpath = "//div[@class='checkout-success']//p[1]")
    WebElement textOrderNo;
    @FindBy(xpath = "//span[normalize-space()='Continue Shopping']")
    WebElement buttonContinueShopping;
    @FindBy(xpath = "//a[@class='action primary']//span[contains(text(),'Create an Account')]")
    WebElement buttonCreateAccountCachedInfo;
    public void confirmOrderComplete(){
        System.out.println("- Current URL: " +driver.getCurrentUrl());
        System.out.println("- Order Complete! "+textOrderNo.getText());
        System.out.println(" Thank you!");
    }

}

