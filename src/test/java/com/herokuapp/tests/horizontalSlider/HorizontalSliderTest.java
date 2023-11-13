package com.herokuapp.tests.horizontalSlider;

import com.herokuapp.pages.HorizontalSliderPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.horizontalSlider.model.HorizontalSliderTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends AbstractTest {

    private MainPage mainPage;
    private HorizontalSliderPage horizontalSliderPage;
    private HorizontalSliderTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        mainPage = new MainPage(driver);
        horizontalSliderPage = new HorizontalSliderPage(driver);
        testData = JsonUtil.getTestData(testDataPath, HorizontalSliderTestData.class);
    }

    @Test
    public void horizontalSliderTest() {
        mainPage.horizontalSliderClick();
        Assert.assertTrue(horizontalSliderPage.isAt());
        Assert.assertEquals(horizontalSliderPage.getHeader(), testData.header());
        horizontalSliderPage.moveSlider(testData.desiredValue());
        Assert.assertEquals(horizontalSliderPage.sliderValue(), testData.desiredValue());
    }
}
