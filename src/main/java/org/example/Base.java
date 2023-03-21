package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.Properties;

public class Base {

    WebDriver driver;
    String url;
    String browserName;
    public WebDriver initializeDriver() throws IOException {
        InputStream fis = new BufferedInputStream(new FileInputStream(".//src/resource/data.properties"));
        Properties properties = new Properties();
        properties.load(fis);
        url = properties.getProperty("url");
        browserName = properties.getProperty("browserName");
        String seleniumDriverPath = properties.getProperty("seleniumDriverPath");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",seleniumDriverPath);
        driver = new ChromeDriver(options);
        return driver;
    }

    public void openUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.close();
    }
}
