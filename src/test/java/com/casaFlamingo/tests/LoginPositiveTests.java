package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.MyProfilePage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPositiveTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getLoginPage();
    }

    @Test
    public void loginAsUserPositiveTest() {
        new LoginPage(driver).enterUserData("sssss@biba.ua", "Cobra123!").clickOnSubmitLoginButton();
        new HomePage(driver).getMyProfilePage().getMyEmail("sssss@biba.ua");
    }

    @Test
    public void loginAsAdministratorPositiveTest() {
        new LoginPage(driver).enterUserData("john.doe@hcf-dev.com", "HCF-dev-007!").clickOnSubmitLoginButton();
        new HomePage(driver).verifyAdminTest();
    }
}
