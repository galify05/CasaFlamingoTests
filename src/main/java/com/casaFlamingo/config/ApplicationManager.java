package com.casaFlamingo.config;

import com.casaFlamingo.utils.MyListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;
Dimension mySize = new Dimension(1800,1000);


    public static int i = (int) ((System.currentTimeMillis() / 1000 % 3600));
    public String email = "bibok" + i + "@mail.ua";
    public String emailReg = "sssss@biba.ua";
    public  String phone = "1234567899";
    public String password = "Cobra123!";
    public String firstName = "Bibok";
    public String lastName = "Pupok";


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
        driver = new EventFiringDecorator(new MyListener()).decorate(driver);

        driver.get("https://hostel-casa-flamingo-f95tn.ondigitalocean.app/#/");
        driver.manage().window().setSize(mySize);
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
