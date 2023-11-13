package com.herokuapp.pages.framesPages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.WebDriver;

public class NestedFramePage extends AbstractPage {

    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void nestedFramesFunctionality(){
        driver.switchTo().frame("frame-top");
        System.out.println("I am in the top frame");
        driver.switchTo().frame("frame-left");
        System.out.println("I am in the top-left frame");
        driver.switchTo().parentFrame();
        System.out.println("Went back to the top frame");
        driver.switchTo().frame("frame-middle");
        System.out.println("I am in the top-middle frame");
        driver.switchTo().parentFrame();
        System.out.println("Went back to the top frame");
        driver.switchTo().frame("frame-right");
        System.out.println("I am in the top-right frame");
        driver.switchTo().defaultContent().switchTo().frame("frame-bottom");
        System.out.println("I am in the bottom frame");
    }
}
