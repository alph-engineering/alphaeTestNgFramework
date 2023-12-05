package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage {
    //Personal Information
    @FindBy(linkText = "https://magento.softwaretestingboard.com/customer/account/create/")
    WebElement linkCreateAccount;
    @FindBy(name = "firstname")
    WebElement inputFirstName;
    @FindBy(name = "lastname")
    WebElement inputLastName;

    // SignIn Information
    @FindBy(name = "email")
    WebElement inputEmailAddress;
    @FindBy(name = "password")
    WebElement inputPassword;
    @FindBy(name = "password_confirmation")
    WebElement inputPasswordConfirmation;
    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    WebElement buttonCreateAccount;
}
