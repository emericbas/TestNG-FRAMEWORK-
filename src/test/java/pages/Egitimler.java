package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Egitimler {
    public Egitimler(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//a[@class='nav-item nav-link'])[5]")
    public WebElement egitimler;
    @FindBy(xpath = "//select[@class='border-0 focus:ring-0 py-2 pl-3 pr-10 bg-primary text-white text-sm rounded-lg']")
    public WebElement sirala;
    @FindBy(xpath = "//*[text()='Doğum Fotoğrafçılığı Eğitimi']")
    public WebElement dogumFotoEgitim;
    @FindBy(xpath = "//span[@class='text-3xl text-green']")
    public WebElement priceelement;
    @FindBy(xpath = "//*[text()='Hemen Başla']")
    public WebElement hemenBaslaButonu;
    @FindBy(xpath = "//*[text()='Ücretsiz Eğitim']")
    public  WebElement ucretsizEgitimTazisi;
    @FindBy(xpath = "//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")
public WebElement profildropDown;
@FindBy(xpath = "(//a[@class='dropdown-item menu-action'])[2]")
    public  WebElement profilElementi;

}
