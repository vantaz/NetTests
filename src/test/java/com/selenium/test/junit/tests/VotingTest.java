package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.HomePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vanitaz on 17.05.17.
 */
public class VotingTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void TS001TC003_VotingWithouthLogin() {
        HomePage homePage = new HomePage();

        int oldValue = homePage.getVoteValue();
        homePage.clickVotePlus();

        assertTrue("Wrong alert window!", homePage.checkAlert());

        int newValue = homePage.getVoteValue();
        assertEquals(oldValue,newValue);
    }

    @After
    public void afterTest() {
//        WebDriverFactory.finishBrowser();
    }


}
