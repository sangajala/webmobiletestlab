package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProjectsPage {
    WebDriver driver = BrowserFactory.getDriver();

    public void EditProject() {
        driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[4]/a[1]/img")).click();
    }

    public void DeleteProject() {
        driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[4]/a[2]/img")).click();
    }


}
