package com.casaFlamingo.tests;

import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{



    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getRegisterPage();
    }

}
