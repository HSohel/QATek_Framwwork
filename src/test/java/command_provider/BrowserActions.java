package command_provider;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    WebDriver driver;

    public BrowserActions(WebDriver driver){
        this.driver=driver;
    }


    public BrowserActions OPenBrowser(String url){
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public BrowserActions validateTitle(String expectedTitle){
          String actualTitle=driver.getTitle();
          Assert.assertEquals(expectedTitle,actualTitle);
        return this;
    }


    public BrowserActions CloseBrowser(){
        driver.quit();
        return this;
    }
}
