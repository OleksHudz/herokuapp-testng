package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class DragAndDropPage extends AbstractPage {

    private Actions actions;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(id = "column-a")
    private WebElement columnA;
    @FindBy(id = "column-b")
    private WebElement columnB;

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public void dragAtoB(){
        actions.dragAndDrop(columnA, columnB).perform();
    }

    public void dragBtoA(){
        actions.dragAndDrop(columnB, columnA).perform();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }
}
