package common;

import fileReaders.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConstantUtils;

public class WebDriverSetUp {
WebDriver driver;


static final Logger log = Logger.getLogger(WebDriverSetUp.class);
    public WebDriver setWebDriver(){
        readProperties();
        if(System.getProperty(ConstantUtils.browserKey).equalsIgnoreCase(ConstantUtils.chromeBrowser)){
            log.debug("Setting up chrome Driver");
            System.setProperty(ConstantUtils.chromeProperties, ConstantUtils.propertyFilePath);
            driver = new ChromeDriver();
        }else if(System.getProperty(ConstantUtils.browserKey).equalsIgnoreCase(ConstantUtils.fireFoxBrowser)){
            log.debug("Setting up FireFox Driver");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public WebDriver getDriver(){
        if (this.driver == null){
           driver = setWebDriver();
        }
        return driver;
    }

    public void openUrl(){
        driver.get(System.getProperty("baseUrl"));
    }

    public void closeDriver(){
        this.driver.quit();
    }

    public void switchToNewTab(){

    }

    public void switchToPreviousTab(){

    }
    public void readProperties()
    {
        PropertiesReader propertiesReader = new PropertiesReader();
    }




}
