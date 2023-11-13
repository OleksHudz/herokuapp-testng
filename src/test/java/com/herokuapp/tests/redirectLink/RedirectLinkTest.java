package com.herokuapp.tests.redirectLink;

import com.google.common.util.concurrent.Uninterruptibles;
import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.redirectLinkPages.RedirectLinkPage;
import com.herokuapp.pages.redirectLinkPages.StatusCodesPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.redirectLink.model.RedirectLinkTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RedirectLinkTest extends AbstractTest {
    private MainPage mainPage;
    private RedirectLinkPage redirectLinkPage;
    private StatusCodesPage statusCodesPage;
    private RedirectLinkTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        redirectLinkPage = new RedirectLinkPage(driver);
        statusCodesPage = new StatusCodesPage(driver);
        testData = JsonUtil.getTestData(testDataPath, RedirectLinkTestData.class);
    }

    @Test
    public void redirectLinkTest() {
        mainPage.redirectLinkClick();
        Assert.assertTrue(redirectLinkPage.isAt());
        Assert.assertEquals(redirectLinkPage.getHeader(), testData.redirectionHeader());
        redirectLinkPage.clickClickHere();
        Assert.assertTrue(statusCodesPage.isAt());
        Assert.assertEquals(statusCodesPage.getHeader(), testData.statusCodesHeader());
        Assert.assertEquals(statusCodesPage.check200ResponseCode(), testData.link200());
        statusCodesPage.backToStatusCodes();
        Assert.assertEquals(statusCodesPage.check301ResponseCode(), testData.link301());
        statusCodesPage.backToStatusCodes();
        Assert.assertEquals(statusCodesPage.check404ResponseCode(), testData.link404());
        statusCodesPage.backToStatusCodes();
        Assert.assertEquals(statusCodesPage.check500ResponseCode(), testData.link500());
        statusCodesPage.backToStatusCodes();
        Assert.assertEquals(statusCodesPage.getHeader(), testData.statusCodesHeader());
    }
}
