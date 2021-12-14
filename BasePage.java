package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    public WebDriver initialiseDriver(String browserName){
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver","src/test/resources/BrowserDriver/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/BrowserDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println(browserName + "Browser is invalid,please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
    public Properties initialiseProperties(){
        prop = new Properties();
        try {
            file = new FileInputStream("C:\\Users\\rinal\\IdeaProjects\\POMFramework1\\src\\test\\resources\\config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            System.out.println("Config file is not found, please check...");
        }catch(IOException e) {
            System.out.println("Properties could not be loaded....");
            e.printStackTrace();
        }
        return prop;
        }


}
