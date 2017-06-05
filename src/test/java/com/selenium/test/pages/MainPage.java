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

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul[1]/li[1]/a")
    WebElement homeLink;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul[1]/li[2]/a")
    WebElement topLink;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul[1]/li[3]/a")
    WebElement waitLink;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul[1]/li[4]/a")
    WebElement addLink;


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


    public LoginPage goToLoginPage() {
        loginLink.click();
        return new LoginPage();
    }

    public RegisterPage goToRegisterPage() {
        registerLink.click();
        return new RegisterPage();
    }

    public HomePage goToHomePage() {
        homeLink.click();
        return new HomePage();
    }

//    public TopPage goToTopPage() {
//        topLink.click();
//        return new TopPage();
//    }
//
//    public WaitPage goToWaitPage() {
//        waitLink.click();
//        return new WaitPage();
//    }
//
//    public AddPage goToAddPage() {
//        addLink.click();
//        return new AddPage();
//    }


    public void logout() {
        logoutLink.click();
    }


    public MainPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }
}
