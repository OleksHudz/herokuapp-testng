package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.BrowserUtils;

public class HoversPage extends AbstractPage {

    Actions actions;

    public HoversPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(xpath = "(//div/img)[1]")
    private WebElement user1;
    @FindBy(xpath = "(//div/img)[2]")
    private WebElement user2;
    @FindBy(xpath = "(//div/img)[3]")
    private WebElement user3;
    @FindBy(xpath = "(//h5)[1]")
    private WebElement username1;
    @FindBy(xpath = "(//h5)[2]")
    private WebElement username2;
    @FindBy(xpath = "(//h5)[3]")
    private WebElement username3;
    @FindBy(xpath = "//a[@href='/users/1']")
    private WebElement viewProfile1Button;
    @FindBy(xpath = "//a[@href='/users/2']")
    private WebElement viewProfile2Button;
    @FindBy(xpath = "//a[@href='/users/3']")
    private WebElement viewProfile3Button;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public String hoverToUser1() {
        actions.moveToElement(user1).perform();
        return BrowserUtils.getText(username1);
    }

    public String hoverToUser2() {
        actions.moveToElement(user2).perform();
        return BrowserUtils.getText(username2);
    }

    public String hoverToUser3() {
        actions.moveToElement(user3).perform();
        return BrowserUtils.getText(username3);
    }

    public void clickProfile1() {
        viewProfile1Button.click();
        driver.navigate().back();
    }

    public void clickProfile2() {
        viewProfile2Button.click();
        driver.navigate().back();
    }

    public void clickProfile3() {
        viewProfile3Button.click();
        driver.navigate().back();
    }
}
