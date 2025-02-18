package com.casaFlamingo.tests;

import com.casaFlamingo.pages.BasePage;
import com.casaFlamingo.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChekImagesTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getHomePage();
    }

    @Test
    public void isImage1Present(){
        new HomePage(driver).chekBrokenImages();
    }
}
