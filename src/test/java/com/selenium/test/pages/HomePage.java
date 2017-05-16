package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This page is a page object example.
 */
public class HomePage extends BasePage {

    private static final String PAGE_URL = "http://drivers4agh.ddns.net/drivers";

    @FindBy(id = "loginLink")
    private WebElement loginLink;

    public HomePage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return loginLink.isDisplayed();
    }

    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage();
    }
}
