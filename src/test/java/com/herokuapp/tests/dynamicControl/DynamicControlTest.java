package com.herokuapp.tests.dynamicControl;

import com.herokuapp.pages.DynamicControlsPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.dynamicControl.modal.DynamicControlTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicControlTest extends AbstractTest {

    private MainPage mainPage;
    private DynamicControlsPage dynamicControlsPage;
    private DynamicControlTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        testData = JsonUtil.getTestData(testDataPath, DynamicControlTestData.class);
    }

    @Test
    public void dynamicControlTest() {
        mainPage.dynamicControlClick();
        Assert.assertTrue(dynamicControlsPage.isAt());
        Assert.assertEquals(dynamicControlsPage.getHeader(), testData.header());
        Assert.assertEquals(dynamicControlsPage.removeCheckbox(), testData.message());
        dynamicControlsPage.enableInputField(testData.input());
    }
}
