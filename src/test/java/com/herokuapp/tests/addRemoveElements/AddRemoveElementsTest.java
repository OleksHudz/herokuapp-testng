package com.herokuapp.tests.addRemoveElements;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.addRemoveElements.model.AddRemoveElementsTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends AbstractTest {

    private MainPage mainPage;
    private AddRemoveElementsPage addRemoveElementsPage;
    private AddRemoveElementsTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.addRemoveElementsPage = new AddRemoveElementsPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, AddRemoveElementsTestData.class);
    }

    @Test
    public void setAddRemoveElementsTest() {
        mainPage.addRemoveElementsClick();
        Assert.assertTrue(addRemoveElementsPage.isAt());
        Assert.assertEquals(addRemoveElementsPage.getHeader(), testData.header());
        addRemoveElementsPage.clickAddElement();
        addRemoveElementsPage.clickDelete();
    }
}
