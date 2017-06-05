package com.selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ChangePasswordPage extends MainPage {

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"OldPassword\"]")
    private WebElement oldPassword;

    @FindBy(xpath = "//*[@id=\"NewPassword\"]")
    private WebElement newPassword;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    private WebElement newPasswordConfirmation;

    @FindBy(xpath = "/html/body/div[2]/form/div[5]/div/input")
    private WebElement changePasswordButton;

    @Override
    protected void openPage() {
        // do nothing
    }

    @Override
    public boolean isPageOpened() {
        return "Zmień hasło.".equals(title.getText());
    }

    public ChangePasswordPage() {
        super(true);
    }

    private void insertOldPassword(String pass) {
        oldPassword.sendKeys(pass);
    }

    private void insertNewPassword(String pass) {
        newPassword.sendKeys(pass);
    }

    private void insertNewPasswordConfirmation(String pass) {
        newPasswordConfirmation.sendKeys(pass);
    }

    private void clickChangePassword() {
        changePasswordButton.click();
    }

    public void changePassword(String oldPassword, String newPassword) {
        insertOldPassword(oldPassword);
        insertNewPassword(newPassword);
        insertNewPasswordConfirmation(newPassword);

        clickChangePassword();
    }
}
