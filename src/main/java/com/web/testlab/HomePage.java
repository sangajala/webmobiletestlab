package com.web.testlab;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver = BrowserFactory.getDriver();
	public void Logout()
	{
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isEnabled());
		driver.findElement(By.linkText("Logout")).click();
		//driver.findElement(By.xpath("html/body/div[1]/div/div/a")).click();
	}


	public void navigateToAddProjectAdmins()
	{
		driver.findElement(By.xpath("html/body/nav/ul/li[2]/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/a")).isDisplayed();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/a")).isEnabled();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/a")).click();
	}
    public void navigateToAddProject()
    {

        Utils.sleep(5);
          //driver.findElement(By.xpath("html/body/div[2]/div[2]/a")).click();

        driver.findElement(By.linkText("Add project")).click();
    }

    public void navigateToAddProjectAdminUser()
    {
        driver.findElement(By.linkText("Project Admins")).click();
        Utils.sleep(5);
        driver.findElement((By.linkText("Add project admin"))).click();
        Utils.sleep(5);
    }

    public void goToNextPage()
    {
        driver.findElement(By.id("myTable_next")).click();
    }

    //public void navigateToaddTestcase()

    public void navigateToTestCaseViewPanel() {
        driver.findElement(By.linkText("Test Cases")).click();
        driver.findElement(By.linkText("Expand All")).click();
        driver.findElement(By.id("255")).click();
        Utils.sleep(5);

    }
    public void navigatetotestcasepage()
     {
            driver.findElement(By.linkText("Test Cases")).click();
            Utils.sleep(5);
       }

    public void navigateToProjectsPage() {driver.findElement(By.linkText("Projects")).click();}

    public void navigateToTesterPage() {driver.findElement(By.linkText("Testers")).click();}
    public void NavigateProjectAdminspage() {
               driver.findElement(By.linkText("Project Admins")).click();
                Utils.sleep(5);
         }
      public void navigateToProjectSettings() {
                driver.findElement(By.linkText("Project Settings")).click();
            }

                public void navigateToReports() {
             driver.findElement(By.linkText("Reports")).click();
            }
    public void navigatetoaccountdetails(){
        driver.findElement(By.linkText("My Account")).click();
    }

}


