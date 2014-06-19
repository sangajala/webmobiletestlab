package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProjectAdminPage {
    WebDriver driver = BrowserFactory.getDriver();

     public void Editfullname(String fullname) {
         driver.findElement(By.id("fulnme")).clear();
         driver.findElement(By.id("fulnme")).sendKeys(fullname);
}

    public void EdituserName(String uname) {
        driver.findElement(By.id("usrnme")).clear();
        driver.findElement(By.id("usrnme")).sendKeys(uname);
    }

    public void EditPassword(String pwd) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pwd);
    }
    public void EditConfirmPassword(String pwd) {
        driver.findElement(By.id("cpass")).clear();
        driver.findElement(By.id("cpass")).sendKeys(pwd);

    }
    public void EditEmail(String Email) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(Email);
    }
    public void EditFavouriteplace(String favplace) {
        driver.findElement(By.id("favplace")).clear();
        driver.findElement(By.id("favplace")).sendKeys(favplace);
    }
     public void Editproject(String project) {
         Utils.selectFromDropDown(By.id("projectid"), project);
         Utils.sleep(5);

     }

    }
