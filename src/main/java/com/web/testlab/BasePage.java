package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sriramangajala on 24/06/15.
 */
public class   BasePage {
    WebDriver driver = BrowserFactory.getDriver();

    public void gotobackPage() {

        driver.findElement(By.xpath("//button[text()='Back']")).click();
    }
}
