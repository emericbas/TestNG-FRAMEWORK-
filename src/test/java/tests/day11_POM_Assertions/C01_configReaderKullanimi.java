package tests.day11_POM_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_configReaderKullanimi {

    @Test
    public void test01(){


        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        // Test datasi olarak verilen kelime icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        // arama sonuclarinin arattigimiz test datasini icerdigini test edelim

        String expectedIcerik = ConfigurationReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();

    }

}
