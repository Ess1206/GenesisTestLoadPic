package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CustomConditions {

    public static ExpectedCondition pageLoader() {
        return new ExpectedCondition<Boolean>() {


            @Override
            public Boolean apply(WebDriver driver) {
                return JsExecuter.executeScript("return document.readyState").equals("complete");
            }
        };

    }

}
