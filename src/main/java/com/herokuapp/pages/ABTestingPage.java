package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ABTestingPage extends AbstractPage {

    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = ".example > p")
    private WebElement text;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return header.getText().trim();
    }

    public String getText() {
        return text.getText().trim();
    }
}
