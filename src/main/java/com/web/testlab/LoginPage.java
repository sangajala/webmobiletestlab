package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage
{
    WebDriver driver = BrowserFactory.getDriver();
    public boolean login(String username, String password)
    {
        if(Utils.isElementPresent(By.id("username"))) {
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(password);


            (new Select(driver.findElement(By.id("choosetype")))).selectByVisibleText("Project Admin");
            driver.findElement(By.tagName("button")).click();
        }
        return true;
    }
    
  
}
