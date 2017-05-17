package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.HomePage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by vanitaz on 16.05.17.
 */
public class LoginTest {


    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void T2_testFailedLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login("aaa", "aaa");
        assertTrue("Login failed!", loginPage.isLoginFailed());
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }


}
