package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.GenericMethods;
import utils.ReadData;

import java.util.Properties;

import static utils.ReadData.propertyShip;

public class CheckoutShippingPage {
    WebDriver driver;
    ReadData readData;
    public CheckoutShippingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "https://magento.softwaretestingboard.com/checkout/#shipping")
    WebElement linkCheckoutShipping;
    @FindBy(xpath = "//div[@class='block items-in-cart active']")
    WebElement textOrderSummary;
    @FindBy(xpath = "//div[@class='block items-in-cart']")
    WebElement buttonOrderSummary;
    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
    WebElement inputEmailAddress;
    @FindBy(name = "firstname")
    WebElement inputFirstName;
    @FindBy(name = "lastname")
    WebElement inputLastName;
    @FindBy(name = "company")
    WebElement inputCompany;
    @FindBy(name = "street[0]")
    WebElement inputStreetAddress1;
    @FindBy(name = "street[1]")
    WebElement inputStreetAddress2;
    @FindBy(name = "street[2]")
    WebElement inputStreetAddress3;
    @FindBy(name = "city")
    WebElement inputCity;
    @FindBy(name = "region_id")
    WebElement inputStateProvince;
    @FindBy(name = "postcode")
    WebElement inputZipPostalCode;
    @FindBy(name = "country_id")
    WebElement inputCountry;
    @FindBy(name = "telephone")
    WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@name='ko_unique_1']")
    WebElement buttonTableRate;
    @FindBy(xpath = "//input[@name='ko_unique_2']")
    WebElement buttonFlatRate;
    @FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
    WebElement linkViewEditCart;
    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement buttonNext;

    public boolean verifyOrderSummary(){
        return buttonOrderSummary.isDisplayed();
    }
    public void orderSummary(){
        System.out.println(driver.getCurrentUrl());
        if (!(buttonOrderSummary==textOrderSummary)) {
            buttonOrderSummary.click();
        }
        System.out.println(" ");
        System.out.println("- Order Summary:");
        System.out.println(textOrderSummary.getText());
    }
    public void enterShippingDetails(){
        readData = new ReadData();
        //inputEmailAddress.sendKeys(ReadData.getUser); // String (Another layer of code between property)
        //inputEmailAddress.sendKeys(readData.getUser()); // Method (Another layer of code between property)
        inputEmailAddress.sendKeys(propertyShip.getProperty("userName")); // Direct
        GenericMethods.pauseExecutionFor(3);
        inputFirstName.sendKeys(propertyShip.getProperty("firstName"));
        inputLastName.sendKeys(propertyShip.getProperty("lastName"));
        inputCompany.sendKeys(propertyShip.getProperty("company"));
        inputStreetAddress1.sendKeys(propertyShip.getProperty("street[0]"));
        inputStreetAddress2.sendKeys(propertyShip.getProperty("street[1]"));
        inputStreetAddress3.sendKeys(propertyShip.getProperty("street[2]"));
        inputCity.sendKeys(propertyShip.getProperty("city"));
        //inputStateProvince.click();
        Select stateDropdown = new Select(inputStateProvince);
        stateDropdown.selectByVisibleText(propertyShip.getProperty("state"));
        //inputStateProvince.sendKeys(propertyShip.getProperty("state"));
        inputZipPostalCode.sendKeys(propertyShip.getProperty("zip"));
        //inputCountry.sendKeys(propertyShip.getProperty("country"));
        //inputCountry.click();
        Select countryDropdown = new Select(inputCountry);
        countryDropdown.selectByVisibleText(propertyShip.getProperty("country"));
        inputPhoneNumber.sendKeys(propertyShip.getProperty("phoneNumber"));

        // Confirm Shipping method
        buttonFlatRate.click();
        buttonNext.click();
    }

}
