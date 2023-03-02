package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ConfigReader.getProperty;

public class C03_RaporluPositifLoginTesti extends TestBaseRapor {
    @Test
    public void PozitifLoginTesti(){
extentTest=extentReports.createTest("Positif login testi","gecerli bilgilerle giris yapilabilmali");
        //qd anasayfaya gidin

        //login linkine tiklayin

        // gecerli kullanici adi ve password ile giris yapin

        // basarili bir sekilde giris yapildigini test edin

        // qd anasayfaya gidin
        Driver.getDriver().get(getProperty("qdUrl"));
extentTest.info("Qualitydemy anasayfaya gidildi");
        // login linkine tiklayin
        QdPage qdPage= new QdPage();
        qdPage.ilkLoginLinki.click();
extentTest.info("Ilk login linkine tiklandi");
        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(getProperty("qdGecerliPassword"));//Passed oldu,kontrol yaptik
      //  qdPage.passwordKutusu.sendKeys(getProperty("qdGecersizPassword"));Failed yapip kontrol ettik
        qdPage.cookies.click();
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
extentTest.pass("Basarili sekilde test edildi");

    }
    }

