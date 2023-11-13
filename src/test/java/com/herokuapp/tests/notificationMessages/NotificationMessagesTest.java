package com.herokuapp.tests.notificationMessages;

import com.herokuapp.pages.MainPage;
import com.herokuapp.pages.NotificationMessagesPage;
import com.herokuapp.tests.AbstractTest;
import com.herokuapp.tests.notificationMessages.model.NotificationMessagesTestData;
import com.herokuapp.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class NotificationMessagesTest extends AbstractTest {

    private MainPage mainPage;
    private NotificationMessagesPage notificationMessagesPage;
    private NotificationMessagesTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) {
        mainPage = new MainPage(driver);
        notificationMessagesPage = new NotificationMessagesPage(driver);
        testData = JsonUtil.getTestData(testDataPath, NotificationMessagesTestData.class);
    }

    @Test
    public void notificationMessagesTest() {
        mainPage.notificationMessagesClick();
        Assert.assertTrue(notificationMessagesPage.isAt());
        notificationMessagesPage.clickClickHere();
        List<String> expectedMessages = testData.notificationMessages();
        String actualMessage = notificationMessagesPage.getNotificationMessage();
//        for (String expectedMessage : expectedMessages) {
//            if (actualMessage.equals(expectedMessage)) {
//                Assert.assertEquals(actualMessage, expectedMessage);
//                System.out.println("Match found: " + expectedMessage);
//                break;
//            }
//        }
        boolean isMatched = expectedMessages.stream()
                .anyMatch(message -> message.equals(actualMessage));
        Assert.assertTrue(isMatched, "Expected message not found: " + actualMessage);
    }
}
