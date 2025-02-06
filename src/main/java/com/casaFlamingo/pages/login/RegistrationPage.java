package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneField;
    @FindBy(xpath = "//input[@name='userEmail']")
    WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    public RegistrationPage enterUserData(String firstname, String lastname, String phone, String email, String password) {
type(firstNameField,firstname);
type(lastNameField,lastname);
type(phoneField, phone);
type(emailField, email);
type(passwordField, password);
        return this;
    }
@FindBy(xpath = "//button[.='Register']")
WebElement registrationSubmitButton;
    public void clickOnSubmitRegistrationButton() {
        click(registrationSubmitButton);
    }

    @FindBy(css = "._error_1i360_33")
    WebElement error;
    public RegistrationPage verifyError() {
        Assert.assertTrue(error.getText().contains("already exist"));
    return this;
    }

    public RegistrationPage verifyEmailError() {
        Assert.assertTrue(error.getText().contains("Email is required!"));
        return this;
    }

    public RegistrationPage verifyPasswordError() {
        Assert.assertTrue(error.getText().contains("Password is required!"));
        return this;
    }
    public RegistrationPage verifyShortPasswordError() {
        Assert.assertTrue(error.getText().contains("more than 8 characters!"));
        return this;
    }

    public RegistrationPage verifyNameError() {
        Assert.assertTrue(error.getText().contains("Name is required!"));
        return this;
    }

}
