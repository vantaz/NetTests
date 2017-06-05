package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by vanitaz.
 */
public class HomePage extends MainPage {

    private static final String PAGE_URL = "http://drivers4agh.ddns.net/";

    @FindBy(xpath = "//*[@id=\"rating-panel-2\"]/span[3]")
    private WebElement votePlus;

    @FindBy(xpath = "//*[@id=\"rating-panel-2\"]/span[2]")
    private WebElement voteCount;

    public HomePage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return PAGE_URL.equals(getDriver().getCurrentUrl()) && logo.isDisplayed();
    }


    public void clickVotePlus() {
        votePlus.click();
    }

    public boolean checkAlert() {
        String alertText = null;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (Exception e) {
        }
        return "Nie udało się zagłosować, spróbuj ponownie.".equals(alertText);
    }

    public int getVoteValue() {
        return Integer.parseInt(voteCount.getText());
    }

    public String getLoggedUserName() {
        String text = manageProfileLink.getText();
        return text.substring(6,text.length()-1);
    }
}
