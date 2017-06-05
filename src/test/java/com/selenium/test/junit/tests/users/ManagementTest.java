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

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by vanitaz.
 */
public class ManagementTest {

    private TestsConfig config = TestsConfig.getConfig();

    private String username = config.getUsername();
    private String password = config.getPassword();

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }




    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }


}
