package com.web.testlab;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddProjectAdminPage {
    WebDriver driver = BrowserFactory.getDriver();

        public void enterProjectAdmins(String fullname,String uname,String pwd,String confpwd,String email,String favplace,int projectindex)
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

           Utils.sleep(5);
            Select sel = new Select(driver.findElement(By.id("projectid")));
            sel.selectByIndex(projectindex);
           // Utils.selectFromDropDown(By.id("projectid"), project);
           // Utils.sleep(5);


        }
        public void saveProjectAdmins()
        {
            driver.findElement(By.xpath(".//*[@id='createprojectadmin']/div/button[2]")).click();
            Utils.sleep(10);

        }

        public void clikok()
        {
            driver.findElement(By.xpath(".//*[@id='success_dialog']/div/div/div/button")).click();

        }



    public void resetFields()
    {
        driver.findElement(By.xpath(".//*[@id='createprojectadmin']/div/button[3]")).click();

    }

    public void back()
    {
        driver.findElement(By.xpath(".//*[@id='createprojectadmin']/div/button[1]")).click();
    }
}



