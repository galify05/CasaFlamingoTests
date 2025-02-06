package com.casaFlamingo.pages;

import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.MyProfilePage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.openqa.selenium.By;
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

    public void getHomePage() {
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

    @FindBy(xpath= "//a[contains(text(),'My profile')]")
    WebElement myProfilePage;
    public MyProfilePage getMyProfilePage() {
        pause(5000);
        moveWithJS(0,200);
        click(myProfilePage);
        return new MyProfilePage(driver);
    }


@FindBy(xpath = "//a[contains(text(),'Rooms management')]")
WebElement management;
    public HomePage verifyAdminTest() {
    Assert.assertTrue(management.getText().contains("Rooms management"));
    return this;}


    @FindBy(xpath = "//nav//button[contains(text(),'Log Out')]")
    WebElement logOut;
    public void isLogOutPresent() {
        pause(200);
    Assert.assertTrue(logOut.isDisplayed());
    }
}
