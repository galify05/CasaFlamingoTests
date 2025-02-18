package com.casaFlamingo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }




    @FindBy(css = "._clearButton_1fora_104")
    WebElement clearCartButton;

    public void clearCart() {
    click(clearCartButton);
    }
}
