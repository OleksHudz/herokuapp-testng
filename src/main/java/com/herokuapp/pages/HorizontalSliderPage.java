package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class HorizontalSliderPage extends AbstractPage {

    Actions actions;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "input[type='range']")
    private WebElement slider;
    @FindBy(css = "span#range")
    private WebElement sliderValue;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public int sliderValue() {
        return Integer.parseInt(BrowserUtils.getText(sliderValue));
    }

    public void moveSlider(double desiredValue) {
        double minValue = 0;
        double maxValue = 5;
        int sliderWidth = slider.getSize().getWidth();
        int targetPosition = (int) ((desiredValue / maxValue) * sliderWidth);
        slider.click();
        actions.clickAndHold(slider).moveByOffset(targetPosition, 0).release().perform();
    }
}
