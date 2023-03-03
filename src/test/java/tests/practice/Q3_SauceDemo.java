package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Q3_SauceDemo {

    //   Navigate to https://www.saucedemo.com/
//  * Enter the username as standard_user
//* Enter the password as secret_sauce
//* Click on login button
//*    Test1 : Choose price low to high
//*    Test2 : Verify item prices are sorted from low to high with soft Assert

@Test
    public void test01(){
    Driver.getDriver().get(ConfigurationReader.getProperty("saucedemo"));
    Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
    Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
    Driver.getDriver().findElement(By.id("login-button")).click();
    WebElement dropdown=Driver.getDriver().findElement(By.className("product_sort_container"));
    Select select=new Select(dropdown);
select.selectByVisibleText("Price (low to high)");
String expectedResult="Price (low to high)";
//*    Test1 : Choose price low to high
    dropdown=Driver.getDriver().findElement(By.className("product_sort_container"));
    select=new Select(dropdown);// test failed oldu eklemeyince
String actualResult=select.getFirstSelectedOption().getText();

    SoftAssert softAssert=new SoftAssert();
    softAssert.assertNotEquals(actualResult,expectedResult);


}

//*    Test2 : Verify item prices are sorted from low to high with soft Assert
@Test(dependsOnMethods="test01")
    public void test02(){

List<WebElement>pricesOnTheScreen=Driver.getDriver().findElements(By.className("inventory_item_price"));
    ArrayList<String>fiyatlar=new ArrayList<>();
    for (WebElement each:pricesOnTheScreen
         ) {
       fiyatlar.add(each.getText());//[$7.99, $9.99, $15.99, $15.99, $29.99, $49.99]
    }
   // ArrayList<String> sortList=;
}

{


}

        }


