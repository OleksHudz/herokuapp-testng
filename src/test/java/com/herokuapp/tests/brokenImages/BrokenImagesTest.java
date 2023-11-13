package com.herokuapp.tests.brokenImages;

import com.herokuapp.pages.BrokenImagesPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.brokenImages.model.BrokenImagesTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrokenImagesTest extends AbstractTest {

    private MainPage mainPage;
    private BrokenImagesPage brokenImagesPage;
    private BrokenImagesTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.brokenImagesPage = new BrokenImagesPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, BrokenImagesTestData.class);
    }

    @Test
    public void brokenImagesTest() {
        mainPage.brokenImagesClick();
        Assert.assertTrue(brokenImagesPage.isAt());
        Assert.assertEquals(brokenImagesPage.brokenLinks(), testData.numberOfLinks());
    }
}
