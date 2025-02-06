package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import com.casaFlamingo.pages.login.MyProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new BasePage(driver).acceptCookie();
                new HomePage(driver).getHomePage();
    }

    @Test
    public void isHomePagePresent(){
        new HomePage(driver)
                .isHomePagePresent("Available Rooms");
    }

//    @Test
//    public void isMyProfilePresent(){
//        new HomePage(driver)
//                .getMyProfilePage();
//        new MyProfilePage(driver).
//    }
}
