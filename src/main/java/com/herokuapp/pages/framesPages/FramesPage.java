package com.herokuapp.pages.framesPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class FramesPage extends AbstractPage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesButton;
    @FindBy(linkText = "iFrame")
    private WebElement iFrameButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void clickIframe() {
        iFrameButton.click();
    }

    public void clickNestedFrames() {
        nestedFramesButton.click();
    }
}
