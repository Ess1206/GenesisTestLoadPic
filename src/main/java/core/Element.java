package core;

import core.constants.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Element extends MethodsFactory {
    public Element(By by , String name){
        this.by = by;
        this.name = name;
    }
    public Element(By by ){
        this.by = by;
    };

    private int waitTime = 15;
    private By by;
    private String name = "";


    public void click(){
        driver().findElement(by).click();
    }

    public void type (String text){
        find().clear();
        find().sendKeys(text);
    }

    public WebElement find(){
        getwebDriverWait(WaitTime.DEFAULT_ELEMENT_WAIT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver().findElement(by);

    }


    public String getAttribute(String atrribute){
        return find().getAttribute(atrribute);
    }
}
