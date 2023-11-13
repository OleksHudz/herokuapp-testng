package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class JavaScriptAlertsPage extends AbstractPage {

    Alert alert;

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "button[onclick='jsAlert()']")
    private WebElement jsAlertButton;
    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement jsConfirmButton;
    @FindBy(css = "button[onclick='jsPrompt()']")
    private WebElement jsPromptButton;
    @FindBy(css = "p#result")
    private WebElement resultMessage;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public String getResultMessage() {
        return BrowserUtils.getText(resultMessage);
    }

    public void handleJSAlert() {
        jsAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void handleJSConfirmAlert() {
        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void handleJSCancelAlert() {
        jsConfirmButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void handleJSPromptAlert(String promptMessage) {
        jsPromptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys(promptMessage);
        alert.accept();
    }
}
