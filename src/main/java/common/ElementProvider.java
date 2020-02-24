package common;

import org.openqa.selenium.WebElement;

public class ElementProvider extends WebDriverSetUp {

    public void clickElementByID(String id){

    }

    public void clickButtonByXpath(String tagName){

    }



    public String getText(WebElement element){
        return null;
    }

    public void enterData(String data,WebElement element){
        if(element.isDisplayed()){
            element.sendKeys(data);
        }
    }



}
