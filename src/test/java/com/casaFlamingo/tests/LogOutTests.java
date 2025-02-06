package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getLoginPage();
        new LoginPage(driver).enterUserData("sssss@biba.ua", "Cobra123!").clickOnSubmitLoginButton();
    }

    @Test
    public void logOutTest() {
        new HomePage(driver).clickOnLogOut().verifyStatus();


    }
}
