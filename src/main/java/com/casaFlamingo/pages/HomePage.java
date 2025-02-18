package com.casaFlamingo.pages;

import com.casaFlamingo.pages.login.MyProfilePage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

    public WelcomeToCasaFlamingoPage getWelcomeToCasaFlamingoPage() {
        click(loginLinkPage);
        return new WelcomeToCasaFlamingoPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'My profile')]")
    WebElement myProfilePage;

    public MyProfilePage getMyProfilePage() {
        pause(500);
        moveWithJS(0, 400);
        click(myProfilePage);
        return new MyProfilePage(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Rooms management')]")
    WebElement management;

    public HomePage verifyAdminTest() {
        Assert.assertTrue(management.getText().contains("Rooms management"));
        return this;
    }


    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    WebElement logOut;


    public HomePage clickOnLogOut() {
        click(logOut);
        return this;
    }

    public HomePage verifyStatus() {
        Assert.assertTrue(isElementDisplayed(loginLinkPage));
        return this;
    }
    @FindBy(css = "img")
    List<WebElement> images;

    public HomePage chekBrokenImages() {
        System.out.println(images.size() + " - " + "images");
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);
            String imageURL = element.getAttribute("src");
            verifyLinks(imageURL);

            if (imageURL != null){
                try {
                    boolean imageDisplayed = (Boolean)
                            js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", element);
                    if (imageDisplayed) {
                        System.out.println("DISPLAYED - OK");
                    } else {
                        System.out.println("DISPLAYED IS BROKEN");
                        System.out.println("===================");
                        throw new AssertionError("DISPLAYED IS BROKEN: " + imageURL);
                    }
                } catch (Exception e) {
                    System.out.println("Error occurred");
                }
            }else {
                throw new AssertionError("" + imageURL);
            }

        }
        return this;
    }

    @FindBy(css = "._card_19hou_18")
    WebElement booking;

    public BookingPage getBookingPage() {
        click(booking);
        return new BookingPage(driver);
    }
}
