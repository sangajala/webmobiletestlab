package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectHomePage extends BasePage{
    WebDriver driver = BrowserFactory.getDriver();
    public void clickTesterTab() {driver.findElement(By.linkText("Testers")).click();
        Utils.sleep(5);}

    public void gotoAddProject() {
        driver.findElement(By.linkText("Add project")).click();
    }

    public boolean checkUserIsInHomePage() {
        return driver.findElement(By.tagName("body")).getText().contains("Welcome");
    }
}
