package tests.practiceNevzatHoca;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Egitimler;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Iienstitu {
    // Kullanici https://www.iienstitu.com/en sayfasina gider
    // Login butonuna tiklar
    // Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
    // headers da bulunan egitimler kismina tiklar
    // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
    // ucretsiz egitimlerden herhangi birini alir
    // kimlik dogrulama islemlerini girer
    // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
    // Kullanici profil kismindan dersi basarili bir sekilde kaydedildigini test eder
HomePage homePage=new HomePage();
LoginPage login=new LoginPage();
Egitimler egitim=new Egitimler();

    @Test
    public void test01(){
        // Kullanici https://www.iienstitu.com/en sayfasina gider
        Driver.getDriver().get(ConfigurationReader.getProperty("udemyUrl"));
        // Login butonuna tiklar
        homePage.LogInButtonHomePage.click();
// Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
        login.emailButonu.sendKeys(ConfigurationReader.getProperty("email"));
        login.loginPasswordBox.sendKeys(ConfigurationReader.getProperty("password"));

        login.logInButton.click();
// Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
String actualResult=Driver.getDriver().findElement(By.xpath("//span[@class='usertext mr-1']")).getText();
String expectedResult="test test";
Assert.assertTrue(actualResult.contains(expectedResult));

// headers da bulunan egitimler kismina tiklar
        egitim.egitimler.click();
        // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
        Select select=new Select(egitim.sirala);

        select.selectByVisibleText("Artan fiyat");
        // ucretsiz egitimlerden herhangi birini alir
egitim.dogumFotoEgitim.click();

        // kimlik dogrulama islemlerini girer
        egitim.hemenBaslaButonu.click();
        
        // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar

String actualTest=egitim.ucretsizEgitimTazisi.getText();
String expectedText="Ücretsiz Eğitim";
Assert.assertTrue(actualTest.contains(expectedText));

        // Kullanici profil kismindan dersi basarili bir sekilde kaydedildigini test eder
        egitim.profildropDown.click();
        egitim.profilElementi.click();



    }
}
