package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectHomePage {
    WebDriver driver = BrowserFactory.getDriver();
    public void clickTesterTab() {driver.findElement(By.linkText("Testers")).click();
        Utils.sleep(5);}
}
