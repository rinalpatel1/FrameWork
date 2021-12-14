package com.demo.nopcommerce;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utilies.Constants;

import java.util.Properties;

public class RegisterPageTest {
    BasePage basePage;
    WebDriver driver;
    Properties prop;
    RegisterPage registerPage;

    @BeforeTest
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        driver.get(prop.getProperty("urlregister"));
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() throws InterruptedException {
        String regTitle = registerPage.getRegisterPageTitle();
        System.out.println(regTitle);
        Assert.assertEquals(regTitle, Constants.REG_PAGE_TITLE, "Loginpage title mismatched");
    }



    @Test (priority = 2)
    public void RegisterPageTest() throws InterruptedException {
         registerPage.DoRegister(prop.getProperty("FN"), prop.getProperty("LN"),
                prop.getProperty("day"), prop.getProperty("month"), prop.getProperty("year"),
                prop.getProperty("email"), prop.getProperty("cn"), prop.getProperty("pwd"),
                 prop.getProperty("CP") );

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
