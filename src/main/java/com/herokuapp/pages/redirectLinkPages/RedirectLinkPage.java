package com.herokuapp.pages.redirectLinkPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class RedirectLinkPage extends AbstractPage {

    public RedirectLinkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "a#redirect")
    private WebElement clickHereButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public void clickClickHere(){
        clickHereButton.click();
    }
}
