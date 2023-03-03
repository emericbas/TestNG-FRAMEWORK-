package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucedemoPage {
    public SaucedemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath ="//input[@data-test='username']")
   public WebElement username;

    @FindBy(xpath = "//input[@data-test='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@data-test='login-button']")
    public WebElement login;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement dropdown;
}
