package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.MyProfilePage;
import com.casaFlamingo.pages.login.RegistrationPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    static int i = (int)((System.currentTimeMillis()/1000%3600));
    String email = "bibok"+i+"@mail.ua";

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getRegisterPage();
    }

    @Test
    public void RegistrationPositiveTest() {
        new RegistrationPage(driver).enterUserData("Bibok","Pupok","+1234567899",email,"Cobra123!").clickOnSubmitRegistrationButton();
        new LoginPage(driver).enterUserData(email, "Cobra123!").clickOnSubmitLoginButton();
        new HomePage(driver).getMyProfilePage().getMyEmail(email);

    }












}
