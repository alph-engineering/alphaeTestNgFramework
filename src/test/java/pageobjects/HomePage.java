package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "https://magento.softwaretestingboard.com/")
    WebElement linkHomePage;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement inputSearch;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement linkSignIn;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement linkCreateAccount;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement buttonCheckoutCart;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement linkSale;
    @FindBy(xpath = "//span[normalize-space()='Shop New Yoga']")
    WebElement linkShopNewYoga;
    @FindBy(xpath = "//span[normalize-space()='Shop Pants']")
    WebElement linkShopPants;
    @FindBy(xpath = "//span[normalize-space()='Shop Erin Recommends']")
    WebElement linkErinRecommends;
    @FindBy(xpath = "//span[normalize-space()='Shop Performance']")
    WebElement linkShopPerformance;
    @FindBy(xpath = "//span[normalize-space()='Shop Eco-Friendly']")
    WebElement linkShopEcoFriendly;
    @FindBy(xpath = "//footer[@class='page-footer']")
    WebElement footerElements;
    @FindBy(xpath = "//span[contains(normalize-space(), 'Copyright')]")
    WebElement textCopyright;
    public void goToHomePage(){
        driver.get("https://magento.softwaretestingboard.com/");
    }
    public boolean verifySearchBarIsAvailable(){
        return inputSearch.isDisplayed();
    }
    public void enterTextInSearchBar(String text){
        inputSearch.sendKeys(text);
    }
    public boolean verifyFooterIsAvailable(){
        return footerElements.isDisplayed();
    }
    public boolean verifyEcoFriendlyProductsAvailable(){
        return linkShopEcoFriendly.isDisplayed();
    }
    public void clickEcoFriendlyProductsButton(){
        linkShopEcoFriendly.click();
    }
    public String getCurrentUrl(){
        String homeURL = driver.getCurrentUrl();
        return homeURL;
    }


}
