package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='userEmail']")
    WebElement userEmailField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    public LoginPage enterUserData(String userEmail, String password) {
        pause(500);
        type(userEmailField, userEmail);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//button[.='Login' and @type='submit']")
    WebElement submitLoginButton;

    public LoginPage clickOnSubmitLoginButton() {
        click(submitLoginButton);
        return this;
    }

    @FindBy(css = "._error_1ut8p_35")
    WebElement error;


    public LoginPage verifyLoginNegativeTest() {
        Assert.assertTrue(error.getText().contains("User not authenticated"));
        return this;
    }


    public LoginPage verifyLoginWithoutEmail() {
        Assert.assertTrue(error.getText().contains("Username is required!"));
        return this;
    }


    public LoginPage verifyLoginWithoutPasswordTest() {
        Assert.assertTrue(error.getText().contains("Password is required!"));
        return this;
    }
}
