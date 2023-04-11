package com.qa.opencart.pages;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private PlaywrightFactory pwFactory;
    private Page page;
    protected HomePage homePage;
    protected Properties prop;

    @Parameters({"browser"})
    @BeforeTest
    public void init(String browserNamefromParameters) throws IOException {

        pwFactory = new PlaywrightFactory();
        prop =pwFactory.initProperties();
        prop.setProperty("browser",browserNamefromParameters);
        pwFactory.initBrowser();


        page = pwFactory.initPage();
        homePage = new HomePage(page);
    }

    @BeforeMethod
    public void setUp() {
    }

    @AfterTest
    public void tearDown() {
        page.context().close();
    }
}
