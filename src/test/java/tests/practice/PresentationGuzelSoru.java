package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.Set;

public class PresentationGuzelSoru {
    /*  1."http://webdriveruniversity.com/" adresine gidin
        2."Login Portal" a kadar asagi inin
        3."Login Portal" a tiklayin
        4.Diger window'a gecin
        5."username" ve "password" kutularina deger yazdirin
        6."login" butonuna basin
        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        8.Ok diyerek Popup'i kapatin
        9.Ilk sayfaya geri donun
        10.Ilk sayfaya donuldugunu test edin*/


        @Test
        public void test(){
            //1."http://webdriveruniversity.com/" adresine gidin
            Driver.getDriver().get("http://webdriveruniversity.com/");
            String window1=Driver.getDriver().getWindowHandle();
            String windowTitle1=Driver.getDriver().getTitle();
            System.out.println(window1);
            //2."Login Portal" a kadar asagi inin
            WebElement portal=Driver.getDriver().findElement(By.xpath("//h1[.='LOGIN PORTAL']"));
            Actions actions=new Actions(Driver.getDriver());
            actions.scrollToElement(portal).perform();
            //        3."Login Portal" a tiklayin
            portal.click();
            //        4.Diger window'a gecin
            String window2="";
            Set<String> windowHandles = Driver.getDriver().getWindowHandles();
            for (String each : windowHandles) {
                if(!each.equals(window1)){
                    window2=each;
                }
            }
            Driver.getDriver().switchTo().window(window2);
            //        5."username" ve "password" kutularina deger yazdirin
            Driver.getDriver().findElement(By.id("text")).sendKeys("hello");
            Driver.getDriver().findElement(By.id("password")).sendKeys("1234");
            //        6."login" butonuna basin
            Driver.getDriver().findElement(By.id("login-button")).click();
            //        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
            String actualtext = Driver.getDriver().switchTo().alert().getText();
            String expectedtext="validation failed";
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(actualtext,expectedtext);
            //        8.Ok diyerek Popup'i kapatin
            Driver.getDriver().switchTo().alert().accept();
            //        9.Ilk sayfaya geri donun
            Driver.getDriver().switchTo().window(window1);
            //        10.Ilk sayfaya donuldugunu test edin*/
            String windowTitle2=Driver.getDriver().getTitle();
            softAssert.assertEquals(windowTitle2,windowTitle1);
            softAssert.assertAll();
            Driver.closeDriver();
        }


    }

