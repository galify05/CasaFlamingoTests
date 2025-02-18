package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeToCasaFlamingoPage extends BasePage {

    public WelcomeToCasaFlamingoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;
    public LoginPage getLoginPage() {
        click(loginButton);
        return new LoginPage(driver);
    }



    @FindBy(xpath = "//button[.='Register']")
    WebElement registerButton;
    public void getRegisterPage() {
        click(registerButton);
    }
}
