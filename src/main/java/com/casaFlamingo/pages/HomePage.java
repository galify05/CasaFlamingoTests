package com.casaFlamingo.pages;

import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='#/']")
    WebElement homeLinkPage;
    public void getHomePage(){
        click(homeLinkPage);
    }

    @FindBy(xpath = "//h2[.='Available Rooms']")
    WebElement homePageTitle;
    public HomePage isHomePagePresent(String h1Name) {
        Assert.assertTrue(homePageTitle.getText().contains(h1Name));
        return this;
    }





   @FindBy(css = "[href='#/loginpage']")
WebElement loginLinkPage;
    public void getWelcomeToCasaFlamingoPage() {
        click(loginLinkPage);
    }



    @FindBy(xpath = "//body[1]/div[1]/footer[2]/nav[1]/a[1]")
WebElement myProfilePage;
    public void getMyProfilePage() {
        click(myProfilePage);
    }




}
