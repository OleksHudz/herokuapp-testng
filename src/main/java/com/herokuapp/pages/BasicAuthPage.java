package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class BasicAuthPage extends AbstractPage {

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(xpath = "//div/p")
    private WebElement message;
    @FindBy(tagName = "body")
    private WebElement bodyText;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.isDisplayed();
    }

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public String getMessage(){
        return BrowserUtils.getText(message);
    }

    public String getBodyText(){
        return BrowserUtils.getText(bodyText);
    }
}
