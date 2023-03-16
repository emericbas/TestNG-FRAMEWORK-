package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Case18;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Case18Auto {
    // 1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//  3. Verify that categories are visible on left side bar
//4. Click on 'Women' category
//5. Click on any category link under 'Women' category, for example: Dress
//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
//  7. On left side bar, click on any sub-category link of 'Men' category
//8. Verify that user is navigated to that category page
    @Test
    public void test01() {

//2. Navigate to url 'http://automationexercise.com'
        Case18 case18=new Case18();
        Driver.getDriver().get(ConfigurationReader.getProperty("autoUrl"));
//   3. Verify that categories are visible on left side bar
        Assert.assertTrue(case18.category.isDisplayed());
//4. Click on 'Women' category
        case18.women.click();
//5. Click on any category link under 'Women' category, for example: Dress
//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
//  7. On left side bar, click on any sub-category link of 'Men' category
//8. Verify that user is navigated to that category page
    }
    }
