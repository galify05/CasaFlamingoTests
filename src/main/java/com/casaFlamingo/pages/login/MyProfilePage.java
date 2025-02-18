package com.casaFlamingo.pages.login;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import org.openqa.selenium.NoSuchElementException;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class MyProfilePage extends BasePage {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "h2")
    List<WebElement> h2Fields;

    public MyProfilePage getMyEmail(String email) {

      return this;
    }
}
