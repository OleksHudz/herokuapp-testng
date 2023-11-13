package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class NotificationMessagesPage extends AbstractPage {

    public NotificationMessagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "div#flash")
    private WebElement notificationMessage;
    @FindBy(linkText = "Click here")
    private WebElement clickHereButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public String getNotificationMessage(){
        return BrowserUtils.getText(notificationMessage);
    }

    public void clickClickHere() {
        clickHereButton.click();
    }
}
