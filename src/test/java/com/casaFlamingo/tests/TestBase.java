package com.casaFlamingo.tests;

import com.casaFlamingo.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "cent"));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = app.startTest();
    }

    @AfterMethod(enabled = false)
    public void tearDown(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Test result: PASSED" + result.getMethod().getMethodName());
        } else {
            logger.error("Test result: FAILED" + result.getMethod().getMethodName());
        }
        logger.info("*******************************************************");
        app.stopTest();
    }
}
