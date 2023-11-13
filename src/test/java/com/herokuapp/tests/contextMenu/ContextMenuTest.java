package com.herokuapp.tests.contextMenu;

import com.herokuapp.pages.ContextMenuPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.contextMenu.model.ContextMenuTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContextMenuTest extends AbstractTest {

    private MainPage mainPage;
    private ContextMenuPage contextMenuPage;
    private ContextMenuTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.contextMenuPage = new ContextMenuPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, ContextMenuTestData.class);
    }

    @Test
    public void contextMenuTest() {
        mainPage.contextMenuClick();
        Assert.assertTrue(contextMenuPage.isAt());
        Assert.assertEquals(contextMenuPage.getHeader(), testData.header());
        contextMenuPage.rightClickButton();
        Assert.assertEquals(contextMenuPage.alertText(), testData.alertMessage());
        contextMenuPage.acceptAlert();
    }
}
