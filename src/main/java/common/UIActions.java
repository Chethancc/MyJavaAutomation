package common;

import fileReaders.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by chethanc on 8/3/20.
 */
public class UIActions {

    WebDriver driver;

    public void switchToNewTab(){

    }

    public void switchToPreviousTab(){

    }


    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void contextClick(){
        getActions().contextClick();
    }

    public Actions getActions(){
        Actions actions = new Actions(driver);
        return actions;
    }

    public void scrollToElement(WebElement element){

    }

    public void scrollToPageEnd(){

    }
}
