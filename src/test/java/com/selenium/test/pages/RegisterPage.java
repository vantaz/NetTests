package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vanitaz.
 */
public class RegisterPage extends MainPage {

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"Login\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    private WebElement passwordConfirmationInput;

    @FindBy(xpath = "/html/body/div[2]/form/div[6]/div/input")
    private WebElement registerButton;

    @FindBy(xpath = "/html/body/div[2]/form/div[1]/ul/li")
    private WebElement errorMsg;

    public RegisterPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        // do nothing
    }

    @Override
    public boolean isPageOpened() {
        return "Rejestracja".equals(title);
    }

    private void insertLogin(String login) {
        loginInput.sendKeys(login);
    }

    private void insertEmail(String email) {
        emailInput.sendKeys(email);
    }

    private void insertPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void insertPasswordConformation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    private void clickRegister() {
        registerButton.click();
    }

    public void register(String login, String email, String password, String passwordConfirmation) {
        insertLogin(login);
        insertEmail(email);
        insertPassword(password);
        insertPasswordConformation(passwordConfirmation);

        clickRegister();
    }

    public boolean isError() {
        return false;
    }

    public String getErrorMsg() {
        return isError() ? errorMsg.getText() : "";
    }


}
