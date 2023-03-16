package tests.practiceNevzatHoca;

import org.testng.annotations.Test;
import pages.QualityPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DataProvider {
    QualityPage qualityPage=new QualityPage();


    @org.testng.annotations.DataProvider
    public static Object[][] gonderilecekMail(){
        Object[][] gonderilecekMailvePassword={
                {"nevzat","1234"},
                {"nevzat@hotmail.com","123456"},
                {"ahmet@hotmail.com","nevzat151515151515"},
                {"celik@hotmail.com","nevzat151515151515"},
                {"anevzatcelik@gmail.com","Nevzat152032"}};
        return gonderilecekMailvePassword;
    }

    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail,String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("qdUrl"));
        qualityPage.providerMethod(mail,password);

    }

    @Test
    public void dersEklemeTesti(){
        Driver.getDriver().get(ConfigurationReader.getProperty("qdUrl"));
        qualityPage.loginMethod();
    }

}
