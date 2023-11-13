package com.herokuapp.tests.frames;

import com.herokuapp.pages.framesPages.FramesPage;
import com.herokuapp.pages.framesPages.IframePage;
import com.herokuapp.pages.framesPages.NestedFramePage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.frames.model.FramesTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FramesTest extends AbstractTest {

    private MainPage mainPage;
    private FramesPage framesPage;
    private IframePage iframePage;
    private NestedFramePage nestedFramePage;
    private FramesTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        mainPage = new MainPage(driver);
        framesPage = new FramesPage(driver);
        iframePage = new IframePage(driver);
        nestedFramePage = new NestedFramePage(driver);
        testData = JsonUtil.getTestData(testDataPath, FramesTestData.class);
    }

    @Test
    public void iFrameTest() {
        mainPage.framesClick();
        Assert.assertTrue(framesPage.isAt());
        Assert.assertEquals(framesPage.getHeader(), testData.header());
        framesPage.clickIframe();
        Assert.assertTrue(iframePage.isAt());
        Assert.assertEquals(iframePage.getHeader(), testData.iFrameHeader());
        iframePage.enterText(testData.text());
        Assert.assertEquals(iframePage.getEnteredText(), testData.text());
    }

    @Test
    public void nestedFramesTest() {
        mainPage.framesClick();
        Assert.assertTrue(framesPage.isAt());
        framesPage.clickNestedFrames();
        Assert.assertEquals(nestedFramePage.getUrl(), testData.nestedFramesUrl());
        nestedFramePage.nestedFramesFunctionality();
    }
}
