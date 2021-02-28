package practiceTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalculateRates {

    WebDriver driver;
    Select select;

    private final By RateLink=By.xpath("//a[text()='Rates']");
    private final By RealApr=By.xpath("//a[text()='Real APR']");
    private final By HomeValue=By.name("HomeValue");
    private final By DownPayment=By.name("DownPayment");
    private final By DownPaymentInDollar=By.id("DownPaymentSel0");
    private final By InterestRate=By.name("Interest");
    private final By Length=By.name("Length");
    private final By Calculate=By.name("calculate");
    private final By ActualAPR=By.xpath("//tr/td/strong[contains(text(),'Actual APR')]/../following-sibling::td/strong");

    @BeforeMethod

    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }


    public void navigateToRatePage(){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(RateLink)).perform();
        driver.findElement(RealApr).click();
    }

    @Test
    public void calculateRealApr(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigateToRatePage();
        driver.findElement(HomeValue).clear();
        driver.findElement(HomeValue).sendKeys("2000000");

        driver.findElement(DownPayment).clear();
        driver.findElement(DownPayment).sendKeys("20000");

        driver.findElement(DownPaymentInDollar).click();

        driver.findElement(InterestRate).clear();
        driver.findElement(InterestRate).sendKeys("3%");

        driver.findElement(Length).clear();
        driver.findElement(Length).sendKeys("30");

        driver.findElement(Calculate).click();


        //Validate APR
        String expectedAPR="3.084%";
        String actualAPR=driver.findElement(ActualAPR).getText();
        Assert.assertEquals(actualAPR,expectedAPR);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();

    }


}
