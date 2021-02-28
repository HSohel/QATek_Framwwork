package automation_test.php_travels;

import command_provider.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PHPTravel {

WebDriver driver;

    @BeforeTest
    public void BrowserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).OPenBrowser("https://phptravels.com/demo/");
    }


    @Test
    public void validateHomePageTitle(){
        String expectedTitle="Demo Script Test drive - PHPTRAVELS";
        ActOn.browser(driver).validateTitle(expectedTitle);
    }

    @AfterTest
    public void CloseBrowser(){
        ActOn.browser(driver).CloseBrowser();
    }

}
