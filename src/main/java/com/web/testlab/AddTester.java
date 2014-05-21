package com.web.testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by abc on 5/20/2014.
 */
public class AddTester {
    WebDriver driver = BrowserFactory.getDriver();

    public void enterFullname(String fullname) { driver.findElement(By.name("fulnme")).sendKeys(fullname);
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("usrnme")).sendKeys(username);
    }

    public void Password(String password) {
        driver.findElement(By.name("pass")).sendKeys(password);
    }

    public void ConfirmPassword(String password) {
        driver.findElement(By.name("cpass")).sendKeys(password);
    }

    public void email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void FavouritePlace(String FavouritePlace) {
        driver.findElement(By.id("favplace")).sendKeys(FavouritePlace);}

    public void clickSaveButton() { driver.findElement(By.xpath("//*[@id=\"createtester\"]/div/button[2]")).click();
        Utils.sleep(5);}


    public void clickokButton() { driver.findElement(By.xpath("//*[@id=\"success_dialog\"]/div/div/div/button")).click();
        Utils.sleep(5);}

}
