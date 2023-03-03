package practice;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Q2_DependsOnMethodlari {

    /*
    - Birbirine bagimli testler olusturun.
    - beforeClass olusturup setUp ayarlarini yapin.
    - Birbirine bagimli testler olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    - driver'i kapatin.
     */

    @Test
    public void wisequarter(){
        Driver.getDriver().get(ConfigurationReader.getProperty("wiseUrl"));
    }
    @Test(dependsOnMethods = "wisequarter")
    public void youtube(){
        Driver.getDriver().get(ConfigurationReader.getProperty("youtubeUrl"));

    }
    @Test(dependsOnMethods = "youtube")
    public void amazon (){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

    }
}
