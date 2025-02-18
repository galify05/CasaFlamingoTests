package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.BookingPage;
import com.casaFlamingo.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new BasePage(driver).acceptCookie();
        new HomePage(driver)
                .getWelcomeToCasaFlamingoPage()
                .getLoginPage()
                .enterUserData(app.emailReg, app.password).clickOnSubmitLoginButton();
    }

    @Test
    public void addTocart() {
        new BookingPage(driver).selectRoom("qa room")
                .booking("123","01.03.2026","01.04.2026" )
                .verify();
    }

    @AfterMethod
    public void poscondition(){
        new BookingPage(driver).getCart().clearCart();
    }
}
