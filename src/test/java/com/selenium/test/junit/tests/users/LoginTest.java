package com.selenium.test.junit.tests.users;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.HomePage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vanitaz.
 */
public class LoginTest {

    private TestsConfig config = TestsConfig.getConfig();

    private String username = config.getUsername();
    private String password = config.getPassword();

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void TS001TC001_testLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(username, password);

        assertTrue("Login failed!", loginPage.isUserLogged());
        String s = homePage.getLoggedUserName();
        assertEquals(username, homePage.getLoggedUserName());
    }

    @Test
    public void TS001TC002_testFailedLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(username, password + "NOPE");
        assertFalse("Login failed!", loginPage.isUserLogged());
        String errorMsg = loginPage.getErrorMsg();
        assertEquals("Nieporawny login lub hasło", errorMsg);
    }

    @Test
    public void TS001TC005_testLogout() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(username, password);
        assertTrue("Login failed!", loginPage.isUserLogged());

        String s = homePage.getLoggedUserName();
        assertEquals(username, homePage.getLoggedUserName());

        homePage.logout();
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse("User still logged!", homePage.isUserLogged());

    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }


}
