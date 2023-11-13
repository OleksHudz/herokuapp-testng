package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LinkUtil;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenImagesPage extends AbstractPage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div>img")
    private List<WebElement> imagesList;

    public int brokenLinks() {
        return (int) imagesList.stream()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .count();
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(imagesList.get(0)));
        return imagesList.get(0).isDisplayed();
    }
}
