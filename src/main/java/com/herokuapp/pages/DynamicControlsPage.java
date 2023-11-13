package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class DynamicControlsPage extends AbstractPage {

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h4[.='Dynamic Controls']")
    private WebElement header;
    @FindBy(css = "button[onclick='swapCheckbox()']")
    private WebElement removeButton;
    @FindBy(css = "button[onclick='swapInput()']")
    private WebElement enableButton;
    @FindBy(id = "checkbox")
    private WebElement checkbox;
    @FindBy(css = "input[type='text']")
    private WebElement inputField;
    @FindBy(id = "message")
    private WebElement itsGoneMessage;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String removeCheckbox() {
        if (checkbox.isDisplayed())
            removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(itsGoneMessage));
        if (itsGoneMessage.isDisplayed())
            return BrowserUtils.getText(itsGoneMessage);
        return null;
    }

    public void enableInputField(String input){
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        inputField.sendKeys(input);
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }
}
