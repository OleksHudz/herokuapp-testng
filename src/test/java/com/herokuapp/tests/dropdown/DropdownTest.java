package com.herokuapp.tests.dropdown;

import com.herokuapp.pages.DropdownPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.dropdown.model.DropdownTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropdownTest extends AbstractTest {

    private MainPage mainPage;
    private DropdownPage dropdownPage;
    private DropdownTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.dropdownPage = new DropdownPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, DropdownTestData.class);
    }

    @Test
    public void dropdownListTest() {
        mainPage.dropdownListClick();
        Assert.assertTrue(dropdownPage.isAt());
        Assert.assertEquals(dropdownPage.getHeader(), testData.header());
        dropdownPage.selectOption(testData.option1());
        dropdownPage.selectOption(testData.option2());
    }
}
