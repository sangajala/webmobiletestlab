    package com.web.testlab;



            import org.openqa.selenium.By;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.support.ui.Select;


    public class DefectPage {
        WebDriver driver = BrowserFactory.getDriver();


        public void navigateToAddDefectPage() {
            Utils.sleep(5);
            driver.findElement(By.xpath("//*[@id=\"addefect\"]")).click();
            Utils.sleep(5);
        }
        public void AddDefect(String Title, String Description, String ExpectedResult, String ActualResult,int index,int Owner) {
            driver.findElement(By.id("title")).sendKeys(Title);
            driver.findElement(By.id("description")).sendKeys(Description);
            driver.findElement(By.id("expectedresult")).sendKeys(ExpectedResult);
            //driver.findElement(By.id("steps")).sendKeys(Steps);
            driver.findElement(By.id("actualresult")).sendKeys(ActualResult);
            Utils.sleep(5);
            Select sel = new Select(driver.findElement(By.id("priority")));
            sel.selectByIndex(index);
            Utils.sleep(5);
            Select sel1 = new Select(driver.findElement(By.id("owner")));
            sel1.selectByIndex(Owner);
            Utils.sleep(5);
        }


        public void SaveDefect() {
            driver.findElement(By.xpath("//*[@id=\"adddefect\"]/div/button[1]")).click();
            Utils.sleep(5);
        }

        public void navigateToDefectviewPage() {
            driver.findElement(By.linkText("Defect Management")).click();
            Utils.sleep(5);
        }

        public void navigateToEditDefect() {
            driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[6]/a[1]/img")).click();
            Utils.sleep(5);
        }

        public void EditDefect(String Title, String Description, String ExpectedResult, String ActualResult,int index,int Owner) {
            driver.findElement(By.id("e_title")).clear();
            driver.findElement(By.id("e_title")).sendKeys(Title);
            driver.findElement(By.id("e_description")).clear();
            driver.findElement(By.id("e_description")).sendKeys(Description);
            driver.findElement(By.id("e_expectedresult")).clear();
            driver.findElement(By.id("e_expectedresult")).sendKeys(ExpectedResult);
            //driver.findElement(By.id("steps")).sendKeys(Steps);
            driver.findElement(By.id("e_actualresult")).clear();
            driver.findElement(By.id("e_actualresult")).sendKeys(ActualResult);
            Utils.sleep(5);
            Select sel = new Select(driver.findElement(By.id("e_priority")));
            sel.selectByIndex(index);
            Utils.sleep(5);
            Select sel1 = new Select(driver.findElement(By.id("e_owner")));
            sel1.selectByIndex(Owner);
            Utils.sleep(5);
        }
        public void SaveEditDefect() {
            driver.findElement(By.xpath("//*[@id=\"editdefect\"]/div/button[1]")).click();
            Utils.sleep(5);
        }

        public void Attachfile(String file) {
            driver.findElement(By.id("img")).sendKeys(file);
        }

        public void Attachfile_edit(String file) {
            driver.findElement(By.id("e_img")).sendKeys(file);
        }



    }