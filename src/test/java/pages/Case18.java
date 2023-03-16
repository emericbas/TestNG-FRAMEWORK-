package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import utilities.Driver;

public class Case18 {
    public  Case18(){
        PageFactory.initElements(Driver.getDriver(),this);}
        @FindBy(className="left-sidebar")
                public WebElement category;
//@FindBy(xpath ="(//a[@data-toggle='collapse'])[1]")
   // public WebElement women;
//@FindBy(partialLinkText = "Women")
//public WebElement women;
  //  @FindBy(xpath = "(//a[@data-parent='#accordian'])[1]")
    //public WebElement women;
     @FindBy(xpath = "(//h4[@class='panel-title'])[1]")
    public WebElement women;

    }

