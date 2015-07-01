package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectSettings {
    WebDriver driver = BrowserFactory.getDriver();

    public void HoldTestCase(){
        driver.findElement(By.xpath("//button[contains(text(),'Testcase Execution')]")).click();
    }

    public void ClickOk() {
        driver.findElement(By.xpath("//*[@id=\"holdtcexefrm\"]/div/button[1]")).click();

    }

    public void ClickCancel() {
        driver.findElement(By.xpath("//*[@id=\"holdtcexefrm\"]/div/button[2]")).click();

    }
    public void UnHoldTestCase(){
        driver.findElement(By.xpath("//button[contains(text(),'Testcase Execution')]")).click();
    }

    public void UnholdClickOk() {
        driver.findElement(By.xpath("//*[@id=\"unholdtcexefrm\"]/div/button[1]")).click();
    }
}
