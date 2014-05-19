package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver = BrowserFactory.getDriver();
    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.tagName("button")).click();
    }
    
  
}
