package com.selenium.test.junit.tests.users;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.pages.ChangePasswordPage;
import com.selenium.test.pages.HomePage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.pages.ManagementPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by vanitaz.
 */
public class ManagementTest {

    private TestsConfig config = TestsConfig.getConfig();

    private String username = config.getUsername();
    private String password = config.getPassword();


    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void TS003TC001_testChangePassword() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(username, password);
        assertTrue("Login failed!", loginPage.isUserLogged());

        ManagementPage managementPage = homePage.goToManagementPage();

        ChangePasswordPage changePasswordPage = managementPage.goToChangePasswordPage();

        changePasswordPage.changePassword(password, "123456");

        homePage.logout();

        loginPage = homePage.goToLoginPage();
        loginPage.login(username,"123456");

        assertTrue("Password not working!", homePage.isUserLogged());

        managementPage = homePage.goToManagementPage();
        changePasswordPage = managementPage.goToChangePasswordPage();
        changePasswordPage.changePassword("123456", password);

    }


    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }


}
