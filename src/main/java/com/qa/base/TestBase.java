package com.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;
    static String configPath = "src/main/java/com/qa/configuration/config.properties";

    public TestBase() throws IOException {
        try {
            prop = new Properties();

            FileInputStream ip = new FileInputStream(configPath);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        if (driver == null) {
            String browsername = prop.getProperty("browser");
            if (browsername.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get((prop.getProperty("url")));
            } else {
                throw new IllegalStateException("Unnsupported name" + browsername);
            }
        }
    }

public void tearDown() {
    if (driver != null) {
        driver.quit();
        driver = null; // Reset the driver to avoid trying to use a null session
    }
}
}


