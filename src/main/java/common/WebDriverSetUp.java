package common;

import fileReaders.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConstantUtils;

public class WebDriverSetUp {
    public WebDriver driver;


static final Logger log = Logger.getLogger(WebDriverSetUp.class);

    public WebDriver setWebDriver(){
        readProperties();
        if(System.getProperty(ConstantUtils.browserKey).equalsIgnoreCase(ConstantUtils.chromeBrowser)){
            log.debug("Setting up chrome Driver and Launching");
            System.setProperty(ConstantUtils.chromeProperties, ConstantUtils.propertyFilePath);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.acceptInsecureCerts();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            driver = new ChromeDriver(capabilities);
        }else if(System.getProperty(ConstantUtils.browserKey).equalsIgnoreCase(ConstantUtils.fireFoxBrowser)){
            log.debug("Setting up FireFox Driver");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public  WebDriver getDriver(){
        if (this.driver == null){
           driver = setWebDriver();
        }
        return driver;
    }

    public void openUrl(){
        driver.get(System.getProperty(ConstantUtils.urlKey));
    }

    public void closeDriver(){
        this.driver.quit();
    }

    public void readProperties()
    {
        PropertiesReader propertiesReader = new PropertiesReader();
    }
}
