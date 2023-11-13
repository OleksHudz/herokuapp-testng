package com.herokuapp.tests.abTesting;

import com.herokuapp.pages.ABTestingPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.abTesting.model.ABTestingTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ABTestingTest extends AbstractTest {

    private MainPage mainPage;
    private ABTestingPage abTestingPage;
    private ABTestingTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.abTestingPage = new ABTestingPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, ABTestingTestData.class);
    }

    @Test
    public void abTestingTest() {
        Assert.assertTrue(mainPage.isAt());
        mainPage.aBTestingClick();
        Assert.assertEquals(abTestingPage.getHeader(), testData.header());
    }
}
