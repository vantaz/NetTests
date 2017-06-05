package com.selenium.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddPage extends MainPage {

    @FindBy(xpath = "/html/body/div[2]/h2")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"Title\"]")
    private WebElement videoTitle;

    @FindBy(xpath = "//*[@id=\"Description\"]")
    private WebElement videoDesc;

    @FindBy(xpath = "//*[@id=\"ContentUrl\"]")
    private WebElement videoURL;

    @FindBy(xpath = "//*[@id=\"Drivers_0__Plate\"]")
    private WebElement driverPlate;

    @FindBy(xpath = "//*[@id=\"Drivers_0__Description\"]")
    private WebElement driverDesc;

    @FindBy(xpath = "/html/body/div[2]/div/form/div/div[5]/div/input")
    private WebElement addButton;

    @Override
    protected void openPage() {
        // do nothing
    }

    @Override
    public boolean isPageOpened() {
        return "Dodaj nowy materiał".equals(title.getText());
    }

    public AddPage() {
        super(true);
    }


    private void insertVideoTitle(String title) {
        videoTitle.sendKeys(title);
    }

    private void insertVideoDesc(String desc) {
        videoDesc.sendKeys(desc);
    }

    private void insertVideoURL(String url) {
        videoURL.sendKeys(url);
    }

    private void insertDriverPlate(String plate) {
        driverPlate.sendKeys(plate);
    }

    private void insertDriverDesc(String desc) {
        driverDesc.sendKeys(desc);
    }

    private void clickAdd() {
        addButton.click();
    }

    public void addVideo(String title, String desc, String url, String plate, String driverDesc) {
        insertVideoTitle(title);
        insertVideoDesc(desc);
        insertVideoURL(url);
        insertDriverPlate(plate);
        insertDriverDesc(driverDesc);

        clickAdd();
    }

}
