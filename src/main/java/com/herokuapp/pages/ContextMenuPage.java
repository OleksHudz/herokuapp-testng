package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class ContextMenuPage extends AbstractPage {

    Alert alert;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(id = "hot-spot")
    private WebElement button;

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void rightClickButton() {
        Actions action = new Actions(driver);
        action.contextClick(button).perform();
    }

    public String alertText() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        alert.accept();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }
}
