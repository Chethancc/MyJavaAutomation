package common;

import fileReaders.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetUp {
WebDriver driver;
    public WebDriver setWebDriver(){
        PropertiesReader propertiesReader = new PropertiesReader();
        System.out.println(System.getProperty("browser"));
        if(System.getProperty("browser").equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/chethanc/Documents/ChethanProject/MyJavaAutomation/src/test/drivers/chromedriver");
            driver = new ChromeDriver();
        }else if(System.getProperty("browser").equalsIgnoreCase("FireFox")){
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


}
