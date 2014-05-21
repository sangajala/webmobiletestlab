package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Testers {
    WebDriver driver = BrowserFactory.getDriver();
    public void clickAddTesterButton() {driver.findElement(By.linkText("Add Tester")).click();}

    public void clickEditTester() {driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[4]/a[1]")).click();
        Utils.sleep(5);
    }
}
