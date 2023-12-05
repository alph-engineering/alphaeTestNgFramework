package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage {

    @FindBy(name = "login[username]")
    WebElement inputEmailAddress;
    @FindBy(name = "login[password]")
    WebElement inputPassword;
    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    WebElement buttonSignIn;
    @FindBy(linkText = "https://magento.softwaretestingboard.com/customer/account/forgotpassword/")
    WebElement linkForgotPassword;
    @FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
    WebElement buttonCreateAccount;
}
