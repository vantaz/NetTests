package com.selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ManagementPage extends MainPage {

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement title;

    @FindBy(xpath = "/html/body/div[2]/div/dl/dd/a")
    private WebElement changePasswordLink;

    @Override
    protected void openPage() {
        // do nothing
    }

    @Override
    public boolean isPageOpened() {
        return "Zarządzaj kontem.".equals(title.getText());
    }

    public ManagementPage() {
        super(true);
    }

    public ChangePasswordPage goToChangePasswordPage() {
        changePasswordLink.click();
        return new ChangePasswordPage();
    }
}
