package tests.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegatifLoginTesti {
    // qd anasayfaya gidin
// 3 test method'u olusturun ve
// asagidaki durumlarda giris yapilamadigini test edin
// 1- gecerli username, gecersiz password
// 2- gecersiz username, gecerli password
// 3- gecersiz username, gecersiz password
    QdPage qdPage= new QdPage();

    @Test
    public void negatifLogin1(){
        QdPage qdPage= new QdPage();//xml'de toplu calistirmalarda problem olunca ekledim
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.cookies.click();
        ReusableMethods.bekle(1);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }


    @Test
    public void negatifLogin2(){
        qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.cookies.click();
        ReusableMethods.bekle(1);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void negatifLogin3(){
        qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        qdPage.ilkLoginLinki.click();
        qdPage.cookies.click();
        ReusableMethods.bekle(1);
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.cookies.click();
        ReusableMethods.bekle(1);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

}