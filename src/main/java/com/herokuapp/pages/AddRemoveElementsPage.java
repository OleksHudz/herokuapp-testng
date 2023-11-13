package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddRemoveElementsPage extends AbstractPage {

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addElementButton;
    @FindBy(css = ".added-manually")
    private WebElement deleteButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(addElementButton));
        return addElementButton.isDisplayed();
    }

    public String getHeader() {
        return header.getText().trim();
    }

    public void clickAddElement() {
        addElementButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }
}
