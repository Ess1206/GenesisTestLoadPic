package core;

import core.lesteners.DriverEventListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BrowserFactory extends MethodsFactory {


    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(driver).register(new DriverEventListener());
        driver.manage().window().maximize();
    }



    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
