package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private final String search= "input[name='search']";
    private final String searchIcon= "button.btn.btn-default.btn-lg";
    private final String searchPageHeader = "div#content h1";

    public HomePage(Page page) {
        this.page = page;
        this.page.navigate("https://naveenautomationlabs.com/opencart/");
    }
    public String doSearch(String product){
        page.locator(search).fill(product);
        page.locator(searchIcon).click();

        return page.textContent(searchPageHeader);
    }

}
