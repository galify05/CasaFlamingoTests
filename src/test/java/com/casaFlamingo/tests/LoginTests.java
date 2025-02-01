package com.casaFlamingo.tests;

import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.MyProfilePage;
import com.casaFlamingo.pages.login.LoginPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

//    @BeforeMethod
//    public void precondition() {
//        new HomePage(driver).getWelcomeToCasaFlamingoPage();
//        new WelcomeToCasaFlamingoPage(driver).getLoginPage();
//    }
//
//    @Test
//    public void loginPositiveTest() {
//        new LoginPage(driver).enterUserData("test@biba.ua", "123456Aa!").clickOnSubmitLoginButton();
//    }


    @Test
    public void loginVerifyTest() {
        new HomePage(driver).getMyProfilePage();
                new MyProfilePage(driver)
                                      .verifyLoginTest("выполняем проверку по имени или почте вошедшего юзера");
    }
}
