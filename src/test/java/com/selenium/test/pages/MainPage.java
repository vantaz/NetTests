package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vanitaz on 05.06.17.
 */
public abstract class MainPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/a/span")
    WebElement logo;

    @FindBy(xpath = "//*[@id=\"loginLink\"]")
    WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"registerLink\"]")
    WebElement registerLink;

    @FindBy(xpath = "//*[@id=\"logoutForm\"]/ul/li[2]/a")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"logoutForm\"]/ul/li[1]/a")
    WebElement manageProfileLink;


    public boolean isUserLogged() {
        try {
            return logoutLink.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getLoggedUserName() {
        String username;
        try {
            String text = manageProfileLink.getText();
            username = text.substring(6,text.length()-1);
        } catch (NoSuchElementException e) {
            username = "";
        }
        return username;
    }


    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage();
    }

    public RegisterPage clickRegister() {
        registerLink.click();
        return new RegisterPage();
    }




    public MainPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }
}
