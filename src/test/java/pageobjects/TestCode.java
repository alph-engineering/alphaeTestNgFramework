package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.GenericMethods;
import utils.ReadData;

public class TestCode {
    WebDriver driver = null;
    CheckoutShippingPage checkoutShippingPage;
    @BeforeClass
    public void setUp(){
        driver = BrowserFactory.launchGivenBrowser("firefox");
        driver.get("https://magento.softwaretestingboard.com/checkout/#shipping");

    }
    @Test
    public void testMethod(){
        checkoutShippingPage = new CheckoutShippingPage(driver);
        GenericMethods.pauseExecutionFor(10);
        checkoutShippingPage.inputStateProvince.click();
        Select stateDropdown = new Select(checkoutShippingPage.inputStateProvince);
        stateDropdown.selectByValue(ReadData.propertyShip.getProperty("state"));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("- Application Closed Successfully");
    }

}

//    @Test
//    public void selectProduct(){
//        WebElement select = driver.findElement(By.xpath("//img[@alt='Ariel Roll Sleeve Sweatshirt']"));
//        genericMethods.pauseExecutionFor(3);
//        select.click();
//    }
