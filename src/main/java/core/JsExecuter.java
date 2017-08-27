package core;

import org.openqa.selenium.JavascriptExecutor;

import static core.MethodsFactory.driver;


public class JsExecuter {
    private static JavascriptExecutor executor(){
        return (JavascriptExecutor) driver();
    }
    public static Object executeScript(String script , Object ... arg){
        return executor().executeScript(script,arg);
    }

}
