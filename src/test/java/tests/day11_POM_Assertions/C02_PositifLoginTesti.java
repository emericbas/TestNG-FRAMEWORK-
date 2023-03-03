package tests.day11_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ConfigurationReader.getProperty;

public class C02_PositifLoginTesti {
    @Test(groups="smoke")
    public void PozitifLoginTesti(){

        //qd anasayfaya gidin

        //login linkine tiklayin

        // gecerli kullanici adi ve password ile giris yapin

        // basarili bir sekilde giris yapildigini test edin

        // qd anasayfaya gidin
        Driver.getDriver().get(getProperty("qdUrl"));

        // login linkine tiklayin
        QdPage qdPage= new QdPage();
        qdPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(getProperty("qdGecerliPassword"));
        qdPage.cookies.click();
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();

        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();
    }
    }

