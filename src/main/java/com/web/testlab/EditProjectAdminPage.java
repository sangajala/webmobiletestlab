package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

    public void Editproject(int index) {
        Utils.selectFromDropDown1(By.id("projectid"),index);
        Utils.sleep(5);

    }
    public void editProjectAdmins(String fullname,String uname,String pwd,String confpwd,String email,String favplace,int projectindex)
    {
        Utils.sleep(5);
        driver.findElement(By.id("fulnme")).clear();
        driver.findElement(By.id("fulnme")).sendKeys(fullname);
        driver.findElement(By.id("usrnme")).clear();
        driver.findElement(By.id("usrnme")).sendKeys(uname);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pwd);
        driver.findElement(By.id("cpass")).clear();
        driver.findElement(By.id("cpass")).sendKeys(confpwd);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("favplace")).clear();
        driver.findElement(By.id("favplace")).sendKeys(favplace);
       Select sel = new Select(driver.findElement(By.id("projectid")));
        sel.selectByIndex(projectindex);
     //   Utils.selectFromDropDown1(By.id("projectid"),projectindex);
        Utils.sleep(5);
        //Utils.sleep(5);
    }


}
