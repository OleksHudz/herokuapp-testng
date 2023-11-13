package com.herokuapp.tests.hovers;

import com.herokuapp.pages.HoversPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.hovers.model.HoversTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HoversTest extends AbstractTest {

    private MainPage mainPage;
    private HoversPage hoversPage;
    private HoversTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        mainPage = new MainPage(driver);
        hoversPage = new HoversPage(driver);
        testData = JsonUtil.getTestData(testDataPath, HoversTestData.class);
    }

    @Test
    public void horizontalSliderTest() {
        mainPage.hoversClick();
        Assert.assertTrue(hoversPage.isAt());
        Assert.assertEquals(hoversPage.getHeader(), testData.header());
        Assert.assertEquals(hoversPage.hoverToUser1(), testData.username1());
        hoversPage.clickProfile1();
        Assert.assertEquals(hoversPage.hoverToUser2(), testData.username2());
        hoversPage.clickProfile2();
        Assert.assertEquals(hoversPage.hoverToUser3(), testData.username3());
        hoversPage.clickProfile3();
    }
}
