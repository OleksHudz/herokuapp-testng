package com.herokuapp.pages.dynamicLoadingPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends AbstractPage {

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(partialLinkText = "Example 1")
    private WebElement example1Button;
    @FindBy(partialLinkText = "Example 2")
    private WebElement example2Button;

    public void clickExample1() {
        example1Button.click();
    }

    public void clickExample2() {
        example2Button.click();
    }

    public String getHeader() {
        return header.getText().trim();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }
}
