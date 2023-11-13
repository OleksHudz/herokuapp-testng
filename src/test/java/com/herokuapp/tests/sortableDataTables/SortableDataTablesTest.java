package com.herokuapp.tests.sortableDataTables;

import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.SortableDataTablesPage;
import com.herokuapp.pages.redirectLinkPages.RedirectLinkPage;
import com.herokuapp.pages.redirectLinkPages.StatusCodesPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.redirectLink.model.RedirectLinkTestData;
import com.herokuapp.tests.sortableDataTables.model.SortableDataTablesTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SortableDataTablesTest extends AbstractTest {

    private MainPage mainPage;
    private SortableDataTablesPage sortableDataTablesPage;
    private SortableDataTablesTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        sortableDataTablesPage = new SortableDataTablesPage(driver);
        testData = JsonUtil.getTestData(testDataPath, SortableDataTablesTestData.class);
    }

    @Test
    public void sortableDataTablesTest() {
        mainPage.sortableDataTablesClick();
        Assert.assertTrue(sortableDataTablesPage.isAt());
        Assert.assertEquals(sortableDataTablesPage.getHeader(), testData.header());
        for (int i = 0; i<testData.expectedTableData().size(); i++){
            Assert.assertEquals(sortableDataTablesPage.getTableData2().get(i), testData.expectedTableData().get(i));
        }
    }
}
