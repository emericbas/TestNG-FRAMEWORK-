package tests.aoutomationExercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoTestCase3;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase3 extends TestBaseRapor {
    @Test
    public void test1() throws InterruptedException {
        extentTest = extentReports.createTest("Negatif login testi", "gecersiz bilgilerle giris yapilabilmali");
        AutoTestCase3 autoTestCase = new AutoTestCase3();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("autoUrl"));
        extentTest.info("Sayfa url'si yazildi");

        // 3. Verify that home page is visible successfully
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(autoTestCase.homeVisible.isEnabled());
        extentTest.info("Home page'in visible olup olmadigini verify ettik");

        // 4. Click on 'Signup / Login' button
        autoTestCase.singUp.click();
        extentTest.info("sign up botton click'lendi.");

        // 5. Verify 'Login to your account' is visible
        softAssert.assertTrue(autoTestCase.accountText.isDisplayed());
        extentTest.info("login to your account texinin goruldugu test edildi.");

        // 6. Enter incorrect email address and password
        autoTestCase.email.sendKeys("sevil@gmail");
        autoTestCase.password.sendKeys("123");
        extentTest.info("Yanlis email e password ile giris yapildi");

        // 7. Click 'login' button
        autoTestCase.login.click();
        extentTest.info("login button click'lendi");

        // 8. Verify error 'Your email or password is incorrect!' is visible
        softAssert.assertTrue(autoTestCase.incorrectText.isDisplayed());
        extentTest.info("incorrect password yazisinin ekranda visible oldugu test edildi");
        softAssert.assertAll();
        extentTest.pass("Test basariyla tamamlandi");
        Driver.closeDriver();
    }
}
//https://chrome.google.com/webstore/detail/selectorshub/ndgimibanhlabgdgjcpbbndiehljcpfh?hl=en    locatelinki