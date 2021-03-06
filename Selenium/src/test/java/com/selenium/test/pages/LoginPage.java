package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vanitaz.
 */
public class LoginPage extends MainPage {

    @FindBy(id = "Login")
    private WebElement loginInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/form/div[4]/div/input")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/form/div[1]/ul/li")
    private WebElement failedLoginMsg;

    public LoginPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        // do nothing
    }

    @Override
    public boolean isPageOpened() {
        return loginInput.isDisplayed();
    }

    private void insertLogin(String login) {
        loginInput.sendKeys(login);
    }

    private void insertPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void clickLogin() {
        loginButton.click();
    }

    public void login(String login, String password) {
        insertLogin(login);
        insertPassword(password);
        clickLogin();
    }

    public String getErrorMsg() {
        try {
            return failedLoginMsg.getText();
        }
        catch (NoSuchElementException e) {
            return "";
        }
    }


}
