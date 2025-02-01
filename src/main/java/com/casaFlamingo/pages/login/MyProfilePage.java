package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyProfilePage extends BasePage {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[.='Test']")
    WebElement userNameField;
    public MyProfilePage verifyLoginTest(String userName) {
        pause(5000);
        Assert.assertTrue(userNameField.getText().contains(userName));
    return this;
    }
}
