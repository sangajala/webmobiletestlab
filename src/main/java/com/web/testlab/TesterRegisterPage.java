package com.web.testlab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TesterRegisterPage {
    WebDriver driver = BrowserFactory.getDriver();


    public void signUp() {
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/span/a[1]")).click();
    }

    public void enterTesterFullname(String fullname) {
        driver.findElement(By.id("fulnme")).clear();
        driver.findElement(By.id("fulnme")).sendKeys(fullname);
    }

    public void enterTesterUsername(String username) {
        driver.findElement(By.id("usrnme")).clear();
        driver.findElement(By.id("usrnme")).sendKeys(username);
    }

    public void testerPassword(String password) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);

    }
    public void testerConfirmPassword(String password) {
        driver.findElement(By.id("cpass")).clear();
        driver.findElement(By.id("cpass")).sendKeys(password);
    }
    public void testeremail(String email) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
    }
    public void testerFavouritePlace(String FavouritePlace) {
        driver.findElement(By.id("favplace")).clear();
        driver.findElement(By.id("favplace")).sendKeys(FavouritePlace);}
    public void testerCommunity() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/table/tbody/tr[8]/td[2]/select/option[2]")).click();


    }
    public void testerSaveButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/button[1]")).click();
    }
    public void confirmMessage()
    {
        driver.findElement(By.xpath("/html/body/div[3]/div/div/p"));
    }

    public void okButton(){
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button")).click();
    }
}

