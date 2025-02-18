package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getLoginPage();
    }

    @Test
    public void loginWithInvalidEmail() {
        new LoginPage(driver)
                .enterUserData("sssss1@biba.ua", "Cobra123!")
                .clickOnSubmitLoginButton()
                .verifyLoginNegativeTest();
    }


    @Test
    public void loginWithOutEmail() {
        new LoginPage(driver).enterUserData("", "Cobra123!")
                .clickOnSubmitLoginButton()
        .verifyLoginWithoutEmail();
    }

    @Test
    public void loginWithoutPassword() {
        new LoginPage(driver).enterUserData("sssss1@biba.ua", "").clickOnSubmitLoginButton()
       .verifyLoginWithoutPasswordTest();
    }

    @Test
    public void loginWithInvalidPassword() {
        new LoginPage(driver).enterUserData("sssss1@biba.ua", "Cobra123!!").clickOnSubmitLoginButton()
        .verifyLoginNegativeTest();
    }
}
