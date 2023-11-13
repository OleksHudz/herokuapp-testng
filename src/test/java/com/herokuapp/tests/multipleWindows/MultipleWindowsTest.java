package com.herokuapp.tests.multipleWindows;

import com.herokuapp.pages.JavaScriptAlertsPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.MultipleWindowsPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.javaScriptAlerts.model.JavaScriptAlertsTestData;
import com.herokuapp.tests.multipleWindows.model.MultipleWindowsTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends AbstractTest {

    private MainPage mainPage;
    private MultipleWindowsPage multipleWindowsPage;
    private MultipleWindowsTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        multipleWindowsPage = new MultipleWindowsPage(driver);
        testData = JsonUtil.getTestData(testDataPath, MultipleWindowsTestData.class);
    }

    @Test
    public void multipleWindowsTest() {
        mainPage.multipleWindowsClick();
        Assert.assertTrue(multipleWindowsPage.isAt());
        Assert.assertEquals(multipleWindowsPage.getHeader(), testData.header());
        multipleWindowsPage.clickClickHere();
        Assert.assertEquals(multipleWindowsPage.switchToWindow(testData.windowTitle()), testData.windowTitle());
    }
}
