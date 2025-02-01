package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    public LoginPage enterUserData(String userName, String password) {
        type(userNameField, userName);
        type(passwordField, password);
        return this;
    }


    @FindBy(xpath = "//button[.='Login' and @type='submit']")
    WebElement submitLoginButton;
    public void clickOnSubmitLoginButton() {
        click(submitLoginButton);
    }
}
