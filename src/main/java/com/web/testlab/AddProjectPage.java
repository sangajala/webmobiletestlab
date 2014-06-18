package com.web.testlab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddProjectPage {
    WebDriver driver = BrowserFactory.getDriver();

        public void enterProjectname(String projname) {

            driver.findElement(By.name("projnme")).clear();
            driver.findElement(By.name("projnme")).sendKeys(projname);
    }

    public void enterProjectDesc(String desc) {

       driver.findElement(By.name("projnme")).isDisplayed();
        driver.findElement(By.name("projdesc")).clear();
        driver.findElement(By.id("projdesc")).sendKeys(desc);
    }

    public void clickSaveButton() {
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
            }
    public void clickBackButton() {

        driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
    }
    public void clickResetButton() {

        driver.findElement(By.cssSelector("button[type=\"reset\"]")).click();
    }
    }
