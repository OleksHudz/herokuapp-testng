package com.herokuapp.tests.dynamicLoading;

import com.google.common.util.concurrent.Uninterruptibles;
import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.dynamicLoadingPages.DynamicLoadingPage;
import com.herokuapp.pages.dynamicLoadingPages.Example1Page;
import com.herokuapp.pages.dynamicLoadingPages.Example2Page;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.dynamicLoading.model.DynamicLoadingTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTest extends AbstractTest {

    private MainPage mainPage;
    private DynamicLoadingPage dynamicLoadingPage;
    private Example1Page example1Page;
    private Example2Page example2Page;
    private DynamicLoadingTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath){
        mainPage = new MainPage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        example1Page = new Example1Page(driver);
        example2Page = new Example2Page(driver);
        testData = JsonUtil.getTestData(testDataPath, DynamicLoadingTestData.class);
    }

    @Test
    public void dynamicLoadingExample1Test(){
        mainPage.dynamicLoadingClick();
        Assert.assertTrue(dynamicLoadingPage.isAt());
        Assert.assertEquals(dynamicLoadingPage.getHeader(), testData.header());
        dynamicLoadingPage.clickExample1();
        Assert.assertTrue(example1Page.isAt());
        Assert.assertEquals(example1Page.getHeader(), testData.header1());
        Assert.assertEquals(example1Page.clickStart(), testData.message());
    }

    @Test
    public void dynamicLoadingExample2Test(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        mainPage.dynamicLoadingClick();
        Assert.assertTrue(dynamicLoadingPage.isAt());
        Assert.assertEquals(dynamicLoadingPage.getHeader(), testData.header());
        dynamicLoadingPage.clickExample2();
        Assert.assertTrue(example2Page.isAt());
        Assert.assertEquals(example2Page.getHeader(), testData.header2());
        Assert.assertEquals(example2Page.clickStart(), testData.message());
    }
}
