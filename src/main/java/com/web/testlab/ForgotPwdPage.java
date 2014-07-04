package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Rajesh on 15/05/2014.
 */
public class ForgotPwdPage {
    WebDriver driver = BrowserFactory.getDriver();
    public void click_on_forgot_password(){driver.findElement(By.xpath("/html/body/div/div/form/div[2]/a ")).click();}
    public void enterusername(String uname){driver.findElement(By.name("user")).sendKeys(uname);}
    public void enter_answer_as_london(String favplace){  driver.findElement(By.name("favplace")).sendKeys(favplace);}
    public void click_on_go_buton(){driver.findElement(By.xpath("/html/body/div/div/form[1]/div[3]/button[2]")).click();}
    public void enter_new_pwd(String pwd){driver.findElement(By.name("newpassword")).sendKeys(pwd);}
    public void enter_confirmpassword(String confpass){ driver.findElement(By.name("confpass")).sendKeys(confpass);}
    public void click_on_save(){ driver.findElement(By.xpath(".//*[@id='resetForm']/div[3]/button[1]")).click();}
    public void click_logout(){driver.findElement(By.linkText("Logout")).click();}
}
