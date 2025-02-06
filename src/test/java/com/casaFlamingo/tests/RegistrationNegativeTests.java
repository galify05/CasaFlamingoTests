package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.RegistrationPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationNegativeTests extends TestBase {

    static int i = (int)((System.currentTimeMillis()/1000%3600));
    String email = "bibok"+i+"@mail.ua";

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getRegisterPage();
    }

    @Test
    public void RegistrationAlreadyExistingEmailTest() {
        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567899", "sssss@biba.ua", "Cobra123!").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyError();
    }

    @Test
    public void RegistrationEmptyEmailTest() {
        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567899", "", "Cobra123!").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyEmailError();
    }

//    @Test
//    public void RegistrationInvalidEmailFormatTest() {
//        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567899", "bibokpup@dotrun", "Cobra123!").clickOnSubmitRegistrationButton();
//        new RegistrationPage(driver).verifyEmailError();
//    }
/// Bug

    @Test
    public void RegistrationEmptyPasswordTest() {
        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567899", email, "").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyPasswordError();
    }

    @Test
    public void RegistrationShortPasswordTest() {
        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567899", email, "Co1!").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyShortPasswordError();
    }

    @Test
    public void RegistrationWithoutFirstNameTest() {
        new RegistrationPage(driver).enterUserData("", "Pupok", "+1234567899", email, "Cobra123!").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyNameError();
    }
//    @Test
//    public void RegistrationLongNameTest() {
//        new RegistrationPage(driver).enterUserData("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "+1234567899", "bibokpu2p@cmd.run", "Cobra123!").clickOnSubmitRegistrationButton();
//        new RegistrationPage(driver).verifyNameError();
//    }
/// bug

    @Test
    public void RegistrationWithoutLastNameTest() {
        new RegistrationPage(driver).enterUserData("Bibok", "", "+1234567899", email, "Cobra123!").clickOnSubmitRegistrationButton();
        new RegistrationPage(driver).verifyNameError();
    }

//    @Test
//    public void RegistrationWithSpecNameTest() {
//        new RegistrationPage(driver).enterUserData("!!!!!!!", "!!!!!!!", "+1234567899", "bibokpup@cmd.run", "Cobra123!").clickOnSubmitRegistrationButton();
//     //   new RegistrationPage(driver).verifyNameError();
//    }
////bug

//        @Test
//    public void RegistrationWithInvalidPhoneTest() {
//        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "+1234567", "bibokpup@cmd.run", "Cobra123!").clickOnSubmitRegistrationButton();
//        new RegistrationPage(driver).verifyShortPasswordError();
//    }
    /// bug
//    @Test
//    public void RegistrationWithInvalidPhoneTest() {
//        new RegistrationPage(driver).enterUserData("Bibok", "Pupok", "AaBbCcDd", "bibokpup@cmd.run", "Cobra123!").clickOnSubmitRegistrationButton();
//        new RegistrationPage(driver).verifyError();
//    }
////bug
}
