package com.herokuapp.tests.checkboxes;

import com.herokuapp.pages.CheckboxesPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxesTest extends AbstractTest {

    private MainPage mainPage;
    private CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void setPageObjects() {
        this.mainPage = new MainPage(driver);
        this.checkboxesPage = new CheckboxesPage(driver);
    }

    @Test
    public void checkboxesTest() {
        mainPage.checkboxesClick();
        checkboxesPage.deselectCheckedCheckboxes();
        checkboxesPage.clickAllCheckboxes();
        Assert.assertTrue(checkboxesPage.checkboxVerification());
    }
}
