package com.qa.opencart.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    private Browser browser;
    private Page page;
    private Properties properties;

    public Browser initBrowser() throws IOException {
        //properties = initProperties();
        boolean headlessMode = Boolean.parseBoolean(properties.getProperty("headless"));
        String browserName = properties.getProperty("browser");

        Playwright playwright = Playwright.create();

        switch (browserName){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(headlessMode));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(headlessMode));
                break;
            default:
                System.out.println("Incorrect browser name");
                break;
        }
        return browser;
    }
    public Page initPage(){
        page=browser.newContext().newPage();
        return page;
    }
    public Properties initProperties() throws IOException {
        properties= new Properties();
        try (var br = new BufferedReader(
                new FileReader("src/test/resources/config/config.properties"))){
            properties.load(br);
        }
        return properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
