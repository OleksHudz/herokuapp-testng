package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class FormAuthenticationPage extends AbstractPage {

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private WebElement header;
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(tagName = "button")
    private WebElement loginButton;
    @FindBy(id = "flash-messages")
    private WebElement loginStatusMessage;
    @FindBy(xpath = "//i[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader() {
        return BrowserUtils.getText(header);
    }

    public String loginStatusMessage() {
        return BrowserUtils.getText(loginStatusMessage);
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void logout(){
        logoutButton.click();
    }
}
