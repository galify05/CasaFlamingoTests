package com.casaFlamingo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2")
    List<WebElement> rooms;

    @FindBy(css = ".error")
    WebElement confirmError;

    @FindBy(css = "input")
    List<WebElement> dateInput;

    @FindBy(css = "p")
    List<WebElement> beds;

    @FindBy(css = "li")
    List<WebElement> li;

    public BookingPage selectRoom(String nameOfRoom) {
        pause(500);
        for (WebElement room : rooms) {
            if (room.getText().equals(nameOfRoom)) {
                click(room);
                return this;
            }
        }
        throw new NoSuchElementException("Room with name '" + nameOfRoom + "' not found");
    }

    public BookingPage booking(String bedNumber, String myEnterDate, String myEscapeDate) {

        for (WebElement container : li) {
            List<WebElement> paragraphs = container.findElements(By.cssSelector("p"));

            for (WebElement p : paragraphs) {
                if (p.getText().equals(bedNumber)) {

                    List<WebElement> dateInputs = container.findElements(By.cssSelector("input"));

                    if (dateInputs.size() < 2) {
                        throw new NoSuchElementException("Not enough input fields in container for: " + beds);
                    }

                    moveWithJS(0, 300);
                    dateInputs.get(0).sendKeys(Keys.CONTROL, "a");
                    dateInputs.get(0).sendKeys(myEnterDate);

                    dateInputs.get(1).sendKeys(Keys.CONTROL, "a");
                    dateInputs.get(1).sendKeys(myEscapeDate);

                    pause(500);

                    WebElement bookButton = container.findElement(By.cssSelector("button._btn_1muke_42"));
                    clickWithJS(bookButton, 0, 500);

                    return this;
                }
            }
        }
        throw new NoSuchElementException("Bed with name '" + beds + "' not found");
    }


     @FindBy (css = "._success_1muke_76")
     WebElement successfully;
    public BookingPage verify() {
        Assert.assertTrue(successfully.getText().contains("Bed successfully booked!"));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cart;

    public CartPage getCart() {
click(cart);
    return new CartPage(driver);
    }
}

