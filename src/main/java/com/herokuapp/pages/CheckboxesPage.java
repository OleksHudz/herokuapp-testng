package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckboxesPage extends AbstractPage {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> checkboxList;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public void deselectCheckedCheckboxes() {
        checkboxList.stream()
                .filter(WebElement::isSelected)
                .forEach(WebElement::click);
    }

    public void clickAllCheckboxes() {
        checkboxList.stream()
                .filter(box -> !box.isSelected())
                .forEach(WebElement::click);
    }

    public boolean checkboxVerification() {
        return checkboxList.stream()
                .allMatch(WebElement::isSelected);
    }
}