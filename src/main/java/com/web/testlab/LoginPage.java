package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver = BrowserFactory.getDriver();
    public boolean login(String username, String password)
    {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
        return true;
    }
    
  
}
