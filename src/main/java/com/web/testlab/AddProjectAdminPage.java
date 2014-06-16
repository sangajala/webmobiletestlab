package com.web.testlab;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectAdminPage {
    WebDriver driver = BrowserFactory.getDriver();

        public void enterProjectAdmins(String fullname,String uname,String pwd,String confpwd,String email,String favplace,String project)
        {
            Utils.sleep(5);
            driver.findElement(By.id("fulnme")).sendKeys(fullname);
            driver.findElement(By.id("usrnme")).sendKeys(uname);
            driver.findElement(By.id("pass")).sendKeys(pwd);
            driver.findElement(By.id("cpass")).sendKeys(confpwd);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("favplace")).sendKeys(favplace);
            Utils.sleep(5);
            Utils.selectFromDropDown(By.id("projectid"), project);
            Utils.sleep(5);


        }
        public void saveProjectAdmins()
        {
            driver.findElement(By.xpath(".//*[@id='createprojectadmin']/div/button[2]")).click();
            Utils.sleep(5);

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


