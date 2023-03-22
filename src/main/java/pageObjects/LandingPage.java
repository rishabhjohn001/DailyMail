package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    By acceptCookieCss = By.cssSelector("#cmpbntyestxt");
    By mainCategoryCss = By.cssSelector("[data-testid='menu-item']");
    By expandIconCss = By.cssSelector("[data-testid='ExpandMoreIcon']");
    By subCategoryCss = By.cssSelector("[data-testid='menu-dropdown-item-text'] span");


    public void acceptCookie(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookieCss)).click();

    }
    public void clickSubCategory(String mainCategoryText, String subCategoryText){
        List<WebElement> categories = driver.findElements(mainCategoryCss);
        for(int i=0; i<categories.size(); i++)
        {
            if(categories.get(i).getText().equalsIgnoreCase(mainCategoryText))
            {
                WebElement hoverable = categories.get(i).findElement(expandIconCss);
                Actions actions = new Actions(driver);
                actions.moveToElement(hoverable).perform();
                List<WebElement> subCategories = categories.get(i).findElements(subCategoryCss);
                for(int j=0;j< subCategories.size();j++)
                {
                    if(subCategories.get(j).getText().equalsIgnoreCase(subCategoryText))
                    {
                        subCategories.get(j).click();
                        break;
                    }
                }
                break;
            }
        }
    }
}
