package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
