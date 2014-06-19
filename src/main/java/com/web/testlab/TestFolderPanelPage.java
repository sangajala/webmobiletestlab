package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Rajesh on 19/06/2014.
 */
public class TestFolderPanelPage {
    WebDriver driver = BrowserFactory.getDriver();
    public void  clickaddfolder()
    {
        driver.findElement(By.id("addfolder")).click();

    }

    public void enterfoldername(String foldername) {
        driver.findElement(By.id("adfoldr")).sendKeys(foldername);
    }

    public void clicksave()
    {
        driver.findElement(By.id("adfoldrsvebtn")).click();

    }
}
