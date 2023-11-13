package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class MultipleWindowsPage extends AbstractPage {

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(linkText = "Click Here")
    private WebElement clickHereButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void clickClickHere() {
        clickHereButton.click();
    }

    public String switchToWindow(String windowTitle) {
        BrowserUtils.switchByTitle(driver, windowTitle);
        WebElement newHeader = driver.findElement(By.tagName("h3"));
        return BrowserUtils.getText(newHeader);
    }
}
