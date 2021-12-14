package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    By gender = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By Day = By.name("DateOfBirthDay");
    By Month = By.name("DateOfBirthMonth");
    By Year = By.name("DateOfBirthYear");
    By emailId = By.id("Email");
    By companyName = By.id("Company");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");


    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getRegisterPageTitle() throws InterruptedException {
       return driver.getTitle();
    }

    public void DoRegister(String FN, String LN, String day,String month, String year,
                           String email, String cn, String pwd, String CP) throws InterruptedException {
        driver.findElement(gender).click();
        driver.findElement(firstName).sendKeys(FN);
        driver.findElement(lastName).sendKeys(LN);
        driver.findElement(Day).sendKeys(day);
        driver.findElement(Month).sendKeys(month);
        driver.findElement(Year).sendKeys(year);
        driver.findElement(emailId).sendKeys(email);
        driver.findElement(companyName).sendKeys(cn);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(CP);
        driver.findElement(registerButton).click();


    }

}

