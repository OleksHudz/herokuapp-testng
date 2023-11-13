package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class FileUploadPage extends AbstractPage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(id = "file-upload")
    private WebElement chooseFileButton;
    @FindBy(id = "file-submit")
    private WebElement uploadButton;
    @FindBy(id = "uploaded-files")
    private WebElement fileName;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void chooseFile(String filePath) {
        chooseFileButton.sendKeys(filePath);
    }

    public void clickUpload() {
        uploadButton.click();
    }

    public String getFileName() {
        return BrowserUtils.getText(fileName);
    }
}
