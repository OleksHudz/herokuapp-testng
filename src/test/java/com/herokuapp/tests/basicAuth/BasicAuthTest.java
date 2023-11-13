package com.herokuapp.tests.basicAuth;

import com.herokuapp.pages.BasicAuthPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.basicAuth.model.BasicAuthTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicAuthTest extends AbstractTest {

    private MainPage mainPage;
    private BasicAuthPage basicAuthPage;
    private BasicAuthTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.basicAuthPage = new BasicAuthPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, BasicAuthTestData.class);
    }

    @Test
    public void basicAuthTest() {
        mainPage.basicAuthClick();
        driver.get(testData.authUrl());
        Assert.assertTrue(basicAuthPage.isAt());
        Assert.assertEquals(basicAuthPage.getHeader(), testData.header());
        Assert.assertEquals(basicAuthPage.getMessage(), testData.message());
    }
}
