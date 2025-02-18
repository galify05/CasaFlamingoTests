package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.RegistrationPage;
import com.casaFlamingo.pages.login.WelcomeToCasaFlamingoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationNegativeTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver).getWelcomeToCasaFlamingoPage();
        new WelcomeToCasaFlamingoPage(driver).getRegisterPage();
    }

    @Test
    public void RegistrationAlreadyExistingEmailTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, app.phone, "sssss@biba.ua", app.password).clickOnSubmitRegistrationButton()
        .verifyError();
    }

    @Test
    public void RegistrationEmptyEmailTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, app.phone, "", app.password).clickOnSubmitRegistrationButton()
        .verifyEmailError();
    }

//    @Test
//    public void RegistrationInvalidEmailFormatTest() {
//        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, app.phone, "bibokpup@dotrun", app.password).clickOnSubmitRegistrationButton()
//        .verifyEmailError();
//    }
// / BUG /////////////

    @Test
    public void RegistrationEmptyPasswordTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, app.phone, app.email, "").clickOnSubmitRegistrationButton()
                .verifyPasswordError();
    }

    @Test
    public void RegistrationShortPasswordTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, app.phone, app.email, "Co1!").clickOnSubmitRegistrationButton()
        .verifyShortPasswordError();
    }

    @Test
    public void RegistrationWithoutFirstNameTest() {
        new RegistrationPage(driver).enterUserData("", app.lastName, app.phone, app.email, app.password).clickOnSubmitRegistrationButton()
        .verifyNameError();
    }
    @Test
    public void RegistrationLongNameTest() {
        new RegistrationPage(driver).enterUserData("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", app.phone, app.email, app.password).clickOnSubmitRegistrationButton()
        .verifyNameError();
    }
/// 111111111111111111

    @Test
    public void RegistrationWithoutLastNameTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, "", app.phone, app.email, app.password).clickOnSubmitRegistrationButton()
        .verifyNameError();
    }

    @Test
    public void RegistrationWithSpecNameTest() {
        new RegistrationPage(driver).enterUserData("!!!!!!!", "!!!!!!!", app.phone, "bibokpup@cmd.run", app.password).clickOnSubmitRegistrationButton()
        .verifyNameErrorSpec();
    }


        @Test
    public void RegistrationWithInvalidPhoneTest1() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, "+1234567", "bibokpup@cmd.run", app.password).clickOnSubmitRegistrationButton()
        .verifyNumber();
    }

    @Test
    public void RegistrationWithInvalidPhoneTest() {
        new RegistrationPage(driver).enterUserData(app.firstName, app.lastName, "AaBbCcDd", "bibokpup@cmd.run", app.password).clickOnSubmitRegistrationButton()
        .verifyNumber();
    }
}
