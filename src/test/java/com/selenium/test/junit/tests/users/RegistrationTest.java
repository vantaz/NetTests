package com.selenium.test.junit.tests.users;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.HomePage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.pages.RegisterPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import com.sun.jna.platform.win32.Sspi;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by vanitaz.
 */
public class RegistrationTest {

    private TestsConfig config = TestsConfig.getConfig();

    private String username = config.getUsername();
    private String email = config.getEmail();

    private String getRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }


    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void TS002TC001_testRegistration() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();

        String random = getRandomString();

        String username = "test" + random;
        String email = random + "@test.test";
        registerPage.register(username, email, "test", "test");

        assertTrue("Registration failed!", homePage.isUserLogged());

        String s = homePage.getLoggedUserName();
        assertEquals(username, homePage.getLoggedUserName());
    }

    @Test
    public void TS002TC002_testRegisterSameUsername() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();

        String random = getRandomString();
        String email = random + "@test.test";
        registerPage.register(username, email , "test", "test");

        assertFalse("User with same name registered!", homePage.isUserLogged());
    }

    @Test
    public void TS002TC003_testRegisterSameEmail() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();

        String random = getRandomString();
        String username = "test" + random;
        registerPage.register(username, email , "test", "test");

        assertFalse("User with same email registered!", homePage.isUserLogged());
    }


    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }


}
