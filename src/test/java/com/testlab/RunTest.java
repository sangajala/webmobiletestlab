package com.testlab;

import com.web.testlab.BrowserFactory;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@Cucumber.Options(
format = {"html:target/cucumber","json:target/cucumber-report.json"},
tags = {"@chandrika"})
public class RunTest{


    static WebDriver driver;
    @BeforeClass
    public static void start()
    {
        try {
            BrowserFactory.StartBrowser("firefox", "http://tvishitech.com/webdev/testlab/web/index.php");
            driver = BrowserFactory.driver;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public static void stop()
    {
        driver.quit();
        driver=null;
    }
}
