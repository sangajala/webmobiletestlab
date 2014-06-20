package com.web.testlab;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyaccountPage {
    WebDriver driver = BrowserFactory.getDriver();
    public void editfullname(String fullname)
    {
        driver.findElement(By.id("fulnme")).clear();
        driver.findElement(By.id("fulnme")).sendKeys(fullname);
    }
    public void edituname(String uname)
    {
        driver.findElement(By.id("usrnme")).clear();
        driver.findElement(By.id("usrnme")).sendKeys(uname);
    }

    public void editpwd(String pwd) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pwd);
    }

    public void editconfpwd(String confpwd) {
        driver.findElement(By.id("cpass")).clear();
        driver.findElement(By.id("cpass")).sendKeys(confpwd);
    }

    public void editemail(String email) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void editfavplace(String favplace) {
        driver.findElement(By.id("favplace")).clear();
        driver.findElement(By.id("favplace")).sendKeys(favplace);
    }

    public void clicksave() {
        driver.findElement(By.xpath("/html/body/div[2]/div/form/div/button[1]")).click();
    }

    public void clickok() {
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button")).click();
    }
}

