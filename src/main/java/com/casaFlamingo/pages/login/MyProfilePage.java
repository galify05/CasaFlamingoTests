package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyProfilePage extends BasePage {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//body//div//main//main//div//p[1]")
    WebElement emailField;

    public MyProfilePage getMyEmail(String email){
        Assert.assertTrue(emailField.getText().contains(email));
        return this;
    }
}
