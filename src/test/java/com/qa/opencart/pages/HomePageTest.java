package com.qa.opencart.pages;

import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest{


    @Test
    public void test_DoSearch() {
        String actualSearchHeader = homePage.doSearch("iphone");
        Assert.assertEquals(actualSearchHeader, "Search - iphone");

    }

}