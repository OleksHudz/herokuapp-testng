package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "A/B Testing")
    private WebElement abTestingBtn;
    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveElementsButton;
    @FindBy(linkText = "Basic Auth")
    private WebElement basicAuthButton;
    @FindBy(linkText = "Broken Images")
    private WebElement brokenImagesButton;
    @FindBy(linkText = "Challenging DOM")
    private WebElement challengingDomButton;
    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesButton;
    @FindBy(linkText = "Context Menu")
    private WebElement contextMenuButton;
    @FindBy(linkText = "Digest Authentication")
    private WebElement digestAuthenticationButton;
    @FindBy(linkText = "Disappearing Elements")
    private WebElement disappearingElementsButton;
    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDropButton;
    @FindBy(linkText = "Dropdown")
    private WebElement dropdownListButton;
    @FindBy(linkText = "Dynamic Content")
    private WebElement dynamicContentButton;
    @FindBy(linkText = "Dynamic Controls")
    private WebElement dynamicControlsButton;
    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingButton;
    @FindBy(linkText = "Entry Ad")
    private WebElement entryAdButton;
    @FindBy(linkText = "Exit Intent")
    private WebElement exitIntentButton;
    @FindBy(linkText = "File Download")
    private WebElement fileDownloadButton;
    @FindBy(linkText = "File Upload")
    private WebElement fileUploadButton;
    @FindBy(linkText = "Floating Menu")
    private WebElement floatingMenuButton;
    @FindBy(linkText = "Forgot Password")
    private WebElement forgotPasswordButton;
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationButton;
    @FindBy(linkText = "Frames")
    private WebElement framesButton;
    @FindBy(linkText = "Geolocation")
    private WebElement geolocationButton;
    @FindBy(linkText = "Horizontal Slider")
    private WebElement horizontalSliderButton;
    @FindBy(linkText = "Hovers")
    private WebElement hoversButton;
    @FindBy(linkText = "Infinite Scroll")
    private WebElement infiniteScrollButton;
    @FindBy(linkText = "Inputs")
    private WebElement inputsButton;
    @FindBy(linkText = "JQuery UI Menus")
    private WebElement jQueryUIMenusButton;
    @FindBy(linkText = "JavaScript Alerts")
    private WebElement javaScriptAlertsButton;
    @FindBy(linkText = "JavaScript onload event error")
    private WebElement javaScriptOnloadEventErrorButton;
    @FindBy(linkText = "Key Presses")
    private WebElement keyPressesButton;
    @FindBy(linkText = "Large & Deep DOM")
    private WebElement largeAndDeepDOMButton;
    @FindBy(linkText = "Multiple Windows")
    private WebElement multipleWindowsButton;
    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesButton;
    @FindBy(linkText = "Notification Messages")
    private WebElement notificationMessagesButton;
    @FindBy(linkText = "Redirect Link")
    private WebElement redirectLinkButton;
    @FindBy(linkText = "Secure File Download")
    private WebElement secureFileDownloadButton;
    @FindBy(linkText = "Shadow DOM")
    private WebElement shadowDOMButton;
    @FindBy(linkText = "Shifting Content")
    private WebElement shiftingContentButton;
    @FindBy(linkText = "Slow Resources")
    private WebElement slowResourcesButton;
    @FindBy(linkText = "Sortable Data Tables")
    private WebElement sortableDataTablesButton;
    @FindBy(linkText = "Status Codes")
    private WebElement statusCodesButton;
    @FindBy(linkText = "Typos")
    private WebElement typosButton;
    @FindBy(linkText = "WYSIWYG Editor")
    private WebElement wysIwygEditorButton;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.abTestingBtn));
        return this.abTestingBtn.isDisplayed();
    }

    public void aBTestingClick() {
        abTestingBtn.click();
    }

    public void addRemoveElementsClick() {
        addRemoveElementsButton.click();
    }

    public void basicAuthClick() {
        basicAuthButton.click();
    }

    public void brokenImagesClick() {
        brokenImagesButton.click();
    }

    public void checkboxesClick() {
        checkboxesButton.click();
    }

    public void contextMenuClick() {
        contextMenuButton.click();
    }

    public void digestAuthenticationClick() {
        digestAuthenticationButton.click();
    }

    public void dragAndDropClick() {
        dragAndDropButton.click();
    }

    public void dropdownListClick() {
        dropdownListButton.click();
    }

    public void dynamicControlClick() {
        dynamicControlsButton.click();
    }

    public void dynamicLoadingClick() {
        dynamicLoadingButton.click();
    }

    public void fileUploadClick() {
        fileUploadButton.click();
    }

    public void formAuthenticationClick() {
        formAuthenticationButton.click();
    }

    public void framesClick() {
        framesButton.click();
    }

    public void horizontalSliderClick() {
        horizontalSliderButton.click();
    }

    public void hoversClick() {
        hoversButton.click();
    }

    public void javaScriptAlertsClick() {
        javaScriptAlertsButton.click();
    }

    public void multipleWindowsClick() {
        multipleWindowsButton.click();
    }

    public void notificationMessagesClick() {
        notificationMessagesButton.click();
    }

    public void redirectLinkClick() {
        redirectLinkButton.click();
    }

    public void sortableDataTablesClick() {
        sortableDataTablesButton.click();
    }
}