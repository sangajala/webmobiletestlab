package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddprojectAdminsPage {
	WebDriver driver = BrowserFactory.getDriver();
	public void enterProjectAdmins(String fullname,String username1,String password1,String confirmpwd,String email,String favplace,String project)
	{
		driver.findElement(By.id("fulnme")).sendKeys(fullname);
		driver.findElement(By.id("usrnme")).sendKeys(username1);
		driver.findElement(By.id("pass")).sendKeys(password1);
		driver.findElement(By.id("cpass")).sendKeys(confirmpwd);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("favplace")).sendKeys(favplace);
		Utils.selectFromDropDown(By.id("projectid"), project);
		
		

	}
	public void saveProjectAdmins()
	{
	driver.findElement(By.xpath(".//*[@id='createprojectadmin']/div/button[2]")).click();
	driver.findElement(By.xpath(".//*[@id='success_dialog']/div/div/div/button")).isDisplayed();
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
