package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class DigestAuthenticationPage extends AbstractPage {

    public DigestAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "div>p")
    private WebElement message;

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public String getMessage(){
        return BrowserUtils.getText(message);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }
}
