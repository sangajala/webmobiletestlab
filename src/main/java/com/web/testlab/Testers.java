package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Testers {
    WebDriver driver = BrowserFactory.getDriver();
    public void clickAddTesterButton() {driver.findElement(By.linkText("Add Tester")).click();}

    public void clickEditTester() {
        //driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[4]/a[1]")).click();
     // driver.findElement(By.xpath("/html/body/div[3]/div/div/table/tbody/tr/td[5]/a/img")).click();
        driver.findElement(By.cssSelector("img[title=\"Edit Tester\"]")).click();

       Utils.sleep(5);
    }
}
