package com.herokuapp.tests.javaScriptAlerts;

import com.herokuapp.pages.JavaScriptAlertsPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.javaScriptAlerts.model.JavaScriptAlertsTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends AbstractTest {

    private MainPage mainPage;
    private JavaScriptAlertsPage javaScriptAlertsPage;
    private JavaScriptAlertsTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        testData = JsonUtil.getTestData(testDataPath, JavaScriptAlertsTestData.class);
    }

    @Test
    public void jsAlertsTest() {
        mainPage.javaScriptAlertsClick();
        Assert.assertTrue(javaScriptAlertsPage.isAt());
        Assert.assertEquals(javaScriptAlertsPage.getHeader(), testData.header());
        javaScriptAlertsPage.handleJSAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultMessage(), testData.jsAlertMessage());
        javaScriptAlertsPage.handleJSConfirmAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultMessage(), testData.jsConfirmMessage());
        javaScriptAlertsPage.handleJSCancelAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultMessage(), testData.jsCancelMessage());
        javaScriptAlertsPage.handleJSPromptAlert(testData.promptMessage());
        Assert.assertEquals(javaScriptAlertsPage.getResultMessage(), testData.jsPromptMessage());
    }
}
