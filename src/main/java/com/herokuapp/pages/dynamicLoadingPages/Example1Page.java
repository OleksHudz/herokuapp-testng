package com.herokuapp.pages.dynamicLoadingPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class Example1Page extends AbstractPage {
    public Example1Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.example>h4")
    private WebElement header;
    @FindBy(css = "div>button")
    private WebElement startButton;
    @FindBy(css ="div#finish>h4")
    private WebElement message;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return header.getText().trim();
    }

    public String clickStart(){
        startButton.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        return BrowserUtils.getText(message);
    }
}
