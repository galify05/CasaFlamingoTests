package com.casaFlamingo.tests;

import com.casaFlamingo.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "cent"));

    public WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = app.startTest();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stopTest();
    }
//    @AfterMethod()
//    public void tearClose(){
//        app.closeTest();
//    }


}
