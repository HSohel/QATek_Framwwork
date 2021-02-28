package automation_test.mortgage_calculator;
import Testing.TestNgMavenTest;
import command_provider.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.GetData;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;


public class CalculateApr {
    private static final Logger LOGGER= LogManager.getLogger(TestNgMavenTest.class);

    WebDriver driver;


    @BeforeMethod

    public void BrowserInitialization() throws IOException {
        LOGGER.info("<------Test Case CalculateApr Starts");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        String URL=GetData.getPropertyValue("url");
        LOGGER.info("Invoke URL "+URL);
        ActOn.browser(driver).OPenBrowser(URL);
    }



    @Test
    public void calculateRealApr(){

        new Home(driver)
                  .mouseHoverToRates()
                  .navigateToRealApr()
                  .typeHomPrice("200000")
                  .typeDownPayment("20000")
                  .clickDownPaymentInDollarRadioBtn()
                  .typeInterestRate("3%")
                  .typeLength("30")
                  .clickCalculateButton()
                  .validateAPR("3.132%");
    }


    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).CloseBrowser();
        LOGGER.info("<------Test Case CalculateApr Ends");

    }


}
