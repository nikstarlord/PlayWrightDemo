package org.example;

import org.example.config.Configuration;
import org.example.pages.ZomatoPage;
import org.example.utils.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderDishTest {
    ZomatoPage zomatoPage;

    @BeforeClass
    public void setup(){
        BrowserFactory.setup();
        zomatoPage = new ZomatoPage();
    }

    @Test
    public void orderDishFromRestaurant(){
        zomatoPage.navigateTo(Configuration.getBaseURL());
        zomatoPage.searchForRestaurant("Pizza Hut");
        zomatoPage.selectFirstResult();
        String expectedText = "Pizza Hut";
        String actualText = zomatoPage.getRestaurantName();
        Assert.assertEquals(actualText, expectedText, "Expected the restaurant name to be: " + expectedText + " But found: " + actualText);
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.tearDown();
    }
}
