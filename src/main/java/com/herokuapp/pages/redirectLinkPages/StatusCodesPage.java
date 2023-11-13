package com.herokuapp.pages.redirectLinkPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;
import utils.LinkUtil;

public class StatusCodesPage extends AbstractPage {

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(linkText = "200")
    private WebElement button200;
    @FindBy(linkText = "301")
    private WebElement button301;
    @FindBy(linkText = "404")
    private WebElement button404;
    @FindBy(linkText = "500")
    private WebElement button500;
    @FindBy(css = "a[href='/status_codes']")
    private WebElement goBackToStatusCodes;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public void backToStatusCodes(){
        goBackToStatusCodes.click();
    }

    public int check200ResponseCode(){
        button200.click();
        return LinkUtil.getResponseCode(driver.getCurrentUrl());
    }

    public int check301ResponseCode(){
        button301.click();
        return LinkUtil.getResponseCode(driver.getCurrentUrl());
    }

    public int check404ResponseCode(){
        button404.click();
        return LinkUtil.getResponseCode(driver.getCurrentUrl());
    }

    public int check500ResponseCode(){
        button500.click();
        return LinkUtil.getResponseCode(driver.getCurrentUrl());
    }
}
