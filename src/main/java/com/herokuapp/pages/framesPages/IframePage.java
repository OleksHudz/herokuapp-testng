package com.herokuapp.pages.framesPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class IframePage extends AbstractPage {

    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "body>p")
    private WebElement textInputArea;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void enterText(String text){
        driver.switchTo().frame("mce_0_ifr");
        textInputArea.clear();
        textInputArea.sendKeys(text);
    }

    public String getEnteredText(){
        return BrowserUtils.getText(textInputArea);
    }
}
