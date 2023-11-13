package com.herokuapp.tests.formAuthentication;

import com.herokuapp.pages.FormAuthenticationPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.formAuthentication.model.FormAuthenticationTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends AbstractTest {

    private MainPage mainPage;
    private FormAuthenticationPage formAuthenticationPage;
    private FormAuthenticationTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        mainPage = new MainPage(driver);
        formAuthenticationPage = new FormAuthenticationPage(driver);
        testData = JsonUtil.getTestData(testDataPath, FormAuthenticationTestData.class);
    }

    @Test
    public void formAuthenticationTestValidLogin() {
        mainPage.formAuthenticationClick();
        Assert.assertTrue(formAuthenticationPage.isAt());
        Assert.assertEquals(formAuthenticationPage.getHeader(), testData.header());
        formAuthenticationPage.login(testData.validUsername(), testData.password());
        Assert.assertEquals(formAuthenticationPage.loginStatusMessage(), testData.successLoginMessage());
        formAuthenticationPage.logout();
        Assert.assertEquals(formAuthenticationPage.loginStatusMessage(), testData.logoutMessage());
    }

    @Test
    public void formAuthenticationTestInvalidLogin() {
        mainPage.formAuthenticationClick();
        Assert.assertTrue(formAuthenticationPage.isAt());
        Assert.assertEquals(formAuthenticationPage.getHeader(), testData.header());
        formAuthenticationPage.login(testData.invalidUsername(), testData.password());
        Assert.assertEquals(formAuthenticationPage.loginStatusMessage(), testData.failLoginMessage());
    }
}
