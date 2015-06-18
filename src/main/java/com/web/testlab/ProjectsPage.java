package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProjectsPage {
    WebDriver driver = BrowserFactory.getDriver();

    public void EditProject() {
        driver.findElement(By.xpath("(//img[@title='Edit Project'])[1]")).click();
    }

    public void DeleteProject() {
        driver.findElement(By.xpath("(//img[@title='Delete Project'])[1]")).click();
    }


}
