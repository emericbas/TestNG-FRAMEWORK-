package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath ="//input[@name='username']")
  public  WebElement emailButonu;

    @FindBy(xpath = "//input[@type='password']")
  public WebElement loginPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement logInButton;
}
