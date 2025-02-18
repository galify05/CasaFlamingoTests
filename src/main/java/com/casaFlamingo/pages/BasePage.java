package com.casaFlamingo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    public WebDriver driver;
    public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public BasePage(String firstName, String lastName, String phone, String email, String password) {
    }

    public void click(WebElement element) {
        element.click();
    }
    public void clickWithJS(WebElement element, int x, int y) {
        moveWithJS(x, y);
        click(element);
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
    public void moveWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }
    public void typeWithJS(WebElement element, String text, int x, int y) {
        moveWithJS(x, y);
        type(element, text);
    }

    public void hideElement() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    @FindBy(xpath = "//button[@class='button1']")
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

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }



    protected void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(url + " - " + connection.getResponseMessage() + "is a broken link");
            } else {
                System.out.println(url + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + "Error occured");
        }
    }


    public void clickWithRectangle(WebElement element, int x, int y) {
        Rectangle rectangle = element.getRect();

        int offsetX = rectangle.getWidth() / x;
        int offsetY = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offsetX, -offsetY).click().perform();
    }



}
