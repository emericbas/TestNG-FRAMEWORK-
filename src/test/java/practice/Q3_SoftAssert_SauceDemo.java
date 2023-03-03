package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3_SoftAssert_SauceDemo {
    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */
//   Navigate to https://www.saucedemo.com/
//           * Enter the username as standard_user
//* Enter the password as secret_sauce
//* Click on login button
//*    Test1 : Choose price low to high
//*    Test2 : Verify item prices are sorted from low to high with soft Assert


    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("sauceDemo"));
        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.id("login-button")).click();
    }

    @Test
    public void sauceLoginTest1() {
        WebElement selectOption = Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(selectOption);
        select.selectByVisibleText("Price (low to high)");
        selectOption = Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        select = new Select(selectOption);
        softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("Price (low to high)"));
    }

    @Test(dependsOnMethods = "sauceLoginTest1")
    public void souceTest2() {
        List<WebElement> fiyatlarElement = Driver.getDriver().findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<Double> siraliFiyat = new ArrayList<>();
        for (WebElement each : fiyatlarElement
        ) {
            String fiyatStr = each.getText().replaceAll("^\\D", "");
            siraliFiyat.add(Double.parseDouble(fiyatStr));
        }
        System.out.println("actualList =" + siraliFiyat);
        ArrayList<Double> sortEdilecekFitatList = new ArrayList<>(siraliFiyat);
        System.out.println("sort edilecek List =" + sortEdilecekFitatList);
        Collections.sort(sortEdilecekFitatList);
        System.out.println("sort ettiktenSonra List =" + sortEdilecekFitatList);
        softAssert.assertEquals(siraliFiyat, sortEdilecekFitatList);
        softAssert.assertAll();

    }
}




