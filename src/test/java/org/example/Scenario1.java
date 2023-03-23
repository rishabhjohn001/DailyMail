package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.TechTvPage;

import java.io.IOException;

public class Scenario1 extends Base {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws IOException {
            driver = initializeDriver();
            openUrl(url);
    }

    @AfterMethod
    public void tearDown()
    {
        closeBrowser();
    }

    @Test(timeOut = 50000)
    public void TC1()
    {
        LandingPage lp = new LandingPage(driver);
        lp.acceptCookie();
        lp.clickSubCategory("Tech", "TV");
        TechTvPage techTvPage = new TechTvPage(driver);
        Assert.assertTrue(techTvPage.isTechTvPageLoaded());
        Assert.assertTrue(techTvPage.isPageHeaderPresent());
        Assert.assertTrue(techTvPage.isPageDescriptionPresent());
        Assert.assertTrue(techTvPage.isArticleSectionPresent());
    }

}
