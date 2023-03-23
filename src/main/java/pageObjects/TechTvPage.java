package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TechTvPage {

    WebDriver driver;
    WebDriverWait wait;
    public TechTvPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By articleSectionCss = By.cssSelector("[data-testid='articles-section-block']");
    By pageHeaderXpath = By.xpath("//div[@data-testid = 'articles-section-block']//parent::div//child::h1");
    By pageDescriptionXpath = By.xpath("//div[@data-testid = 'articles-section-block']//parent::div//child::p");


    public boolean isTechTvPageLoaded(){
        return (driver.getCurrentUrl().equalsIgnoreCase("https://www.dailymail.co.uk/best-buys/tech/tv/"));
    }

    public boolean isPageHeaderPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeaderXpath));
        return driver.findElement(pageHeaderXpath).isDisplayed();
    }
    public boolean  isPageDescriptionPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageDescriptionXpath));
        return driver.findElement(pageDescriptionXpath).isDisplayed();
    }
    public boolean isArticleSectionPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleSectionCss));
        return driver.findElement(articleSectionCss).isDisplayed();

    }
}
