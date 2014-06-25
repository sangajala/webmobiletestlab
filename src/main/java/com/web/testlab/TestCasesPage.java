package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.acl.Owner;


public class TestCasesPage {
    WebDriver driver = BrowserFactory.getDriver();

    public void testcases(){

        driver.findElement(By.linkText("Test Cases")).click();
        Utils.sleep(5);
    }

    public void clickAddtestcase() {
     driver.findElement(By.id("adhdtestcsebtn")).click();
        Utils.sleep(5);
    }

    public void ClickEditTestCaselink() {
        driver.findElement(By.cssSelector("img[title=\"Edit Testcase\"]")).click();
    }

    public void AddTestCase(String Title, String Owner, String Description, String ExpectedResult) {
        driver.findElement(By.id("tc_title")).sendKeys(Title);
        Utils.selectFromDropDown(By.id("tc_owner"), Owner);
        driver.findElement(By.id("tc_description")).sendKeys(Description);
        driver.findElement(By.id("tc_expectedresult")).sendKeys(ExpectedResult);
    }

    public void EditTestCase(String Title,String Owner, String Description, String ExpectedResult) {
        driver.findElement(By.id("etc_title")).clear();
        driver.findElement(By.id("etc_title")).sendKeys(Title);
        Utils.selectFromDropDown(By.id("etc_owner"), Owner);
       driver.findElement(By.id("etc_description")).clear();
       driver.findElement(By.id("etc_description")).sendKeys(Description);
        driver.findElement(By.id("etc_expectedresult")).clear();
        driver.findElement(By.id("etc_expectedresult")).sendKeys(ExpectedResult);
    }

    public void SaveTestCase() {
        driver.findElement(By.xpath("//*[@id=\"createtestcase\"]/div/button[1]")).click();
    }

    public void SaveEditTestCase() {
        driver.findElement(By.xpath("//*[@id=\"edittestcase\"]/div/button[1]")).click();
    }

    public void deletebutton(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]")).getText();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[7]/img[2]")).click();

    }
    public void okbutton(){
        driver.findElement(By.xpath("/html/body/div[5]/div/div/form/div/button[1]"));
    }
    public void newtestfolder(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/ul/li[28]/div")).click();
    }
}


