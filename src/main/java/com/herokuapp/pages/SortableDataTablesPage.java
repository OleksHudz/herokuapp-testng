package com.herokuapp.pages;

import com.herokuapp.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesPage extends AbstractPage {

    public SortableDataTablesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(css = "table#table1 tr")
    private List<WebElement> table1Rows;

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }

    public String getHeader(){
        return BrowserUtils.getText(header);
    }

    public List<String> getTableData() {
        List<String> actualUserData = new ArrayList<>();
        for (int i = 0; i < table1Rows.size(); i++) {
            List<WebElement> cells = table1Rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j<cells.size()-1; j++){
                actualUserData.add(cells.get(j).getText());
            }
        }
        return actualUserData;
    }

    public List<String> getTableData2() {
        return table1Rows.stream()
                .skip(1) // Skip the first row (header)
                .map(row -> row.findElements(By.tagName("td")))
                .flatMap(cells -> cells.stream()
                        .limit(cells.size() - 1)
                        .map(WebElement::getText)
                )
                .collect(Collectors.toList());
    }
}
