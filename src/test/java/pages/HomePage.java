package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath="//button[@class='button flex items-center font-bold bg-transparent text-black dark:text-white border-2 border-primary -p-0.5 pt-3.5 px-7 pb-3']")
public WebElement LogInButtonHomePage;





}
