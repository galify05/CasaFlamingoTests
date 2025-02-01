package com.casaFlamingo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    //    @FindBy(xpath = "//button[.='Accept']")
    @FindBy(xpath = "//button[@class=\"button1\"]")
    WebElement acceptCookieButton;
    public void acceptCookie() {
        click(acceptCookieButton);
    }

    @FindBy(xpath = "//button[.='Reject']")
    WebElement rejectCookieButton;
    public HomePage rejecrtCookie() {
        click(rejectCookieButton);
        return new HomePage(driver);
    }
}
