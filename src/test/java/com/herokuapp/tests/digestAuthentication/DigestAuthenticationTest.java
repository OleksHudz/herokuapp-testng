package com.herokuapp.tests.digestAuthentication;

import com.herokuapp.pages.ContextMenuPage;
import com.herokuapp.pages.DigestAuthenticationPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.contextMenu.model.ContextMenuTestData;
import com.herokuapp.tests.digestAuthentication.model.DigestAuthenticationTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DigestAuthenticationTest extends AbstractTest {

    private MainPage mainPage;
    private DigestAuthenticationPage digestAuthenticationPage;
    private DigestAuthenticationTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.digestAuthenticationPage = new DigestAuthenticationPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, DigestAuthenticationTestData.class);
    }

    @Test
    public void digestAuthTest() {
        mainPage.digestAuthenticationClick();
        driver.get(testData.digestAuthUrl());
        Assert.assertTrue(digestAuthenticationPage.isAt());
        Assert.assertEquals(digestAuthenticationPage.getHeader(), testData.header());
        Assert.assertEquals(digestAuthenticationPage.getMessage(), testData.message());
    }
}
