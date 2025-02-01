package com.casaFlamingo.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("cent")) {
            ChromeOptions cent = new ChromeOptions();
            cent.setBinary("E:/Prg/CentBrowser/chrome.exe");
            System.setProperty("webdriver.chrome.driver", "E:/Java/Tools/118/chromedriver.exe");
            driver = new ChromeDriver(cent);
        } else if (browser != null &&
                !browser.equals("chrome") &&
                !browser.equals("firefox") &&
                !browser.equals("edge") &&
                !browser.equals("cent")) {
            throw new IllegalArgumentException("Browser entered is not correct");
        }
        driver.get("http://localhost:5173/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


    public void stopTest() {
        driver.quit();
    }

    public void closeTest() {
        driver.close();
    }
}
