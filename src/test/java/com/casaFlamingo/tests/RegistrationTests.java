package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.RegistrationPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{


    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getRegisterPage();
    }

    @Test
    public void RegistrationPositiveTest() {
        new RegistrationPage(driver).enterUserData("Bibok","Pupok",app.phone,app.email,"Cobra123!")
                .clickOnSubmitRegistrationButton()
                .verifyRegister();
    }
}
