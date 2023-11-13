package com.herokuapp.tests.fileUpload;

import com.herokuapp.pages.FileUploadPage;
import com.herokuapp.pages.MainPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.fileUpload.model.FileUploadTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileUploadTest extends AbstractTest {

    private MainPage mainPage;
    private FileUploadPage fileUploadPage;
    private FileUploadTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath){
        mainPage = new MainPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        testData = JsonUtil.getTestData(testDataPath, FileUploadTestData.class);
    }

    @Test
    public void fileUploadTest(){
        mainPage.fileUploadClick();
        Assert.assertTrue(fileUploadPage.isAt());
        Assert.assertEquals(fileUploadPage.getHeader(), testData.header());
        fileUploadPage.chooseFile(testData.filePath());
        fileUploadPage.clickUpload();
        Assert.assertEquals(fileUploadPage.getHeader(), testData.uploadConfirmHeader());
        Assert.assertEquals(fileUploadPage.getFileName(), testData.fileName());
    }
}
