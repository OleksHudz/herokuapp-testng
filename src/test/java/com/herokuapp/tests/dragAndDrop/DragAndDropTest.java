package com.herokuapp.tests.dragAndDrop;

import com.herokuapp.pages.DragAndDropPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.dragAndDrop.model.DragAndDropTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragAndDropTest extends AbstractTest {

    private MainPage mainPage;
    private DragAndDropPage dragAndDropPage;
    private DragAndDropTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        this.mainPage = new MainPage(driver);
        this.dragAndDropPage = new DragAndDropPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, DragAndDropTestData.class);
    }

    @Test
    public void dragAndDropTest() {
        mainPage.dragAndDropClick();
        Assert.assertTrue(dragAndDropPage.isAt());
        dragAndDropPage.dragAtoB();
        dragAndDropPage.dragBtoA();
    }
}
