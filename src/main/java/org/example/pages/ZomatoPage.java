package org.example.pages;

import com.microsoft.playwright.options.LoadState;

public class ZomatoPage extends BasePage{
    private final String searchBoxSelector = "input[placeholder='Search for restaurant, cuisine or a dish']";
    private final String firstResultSelector = "div[class*='sc-'] > div:nth-child(1) img[alt=\"Restaurant Image\"]";
    private final String restaurantName = "h1[class = 'sc-7kepeu-0 sc-iSDuPN fwzNdh']";

    public void searchForRestaurant(String restaurantName){
        page.fill(searchBoxSelector, restaurantName);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.click(searchBoxSelector);
    }

    public void selectFirstResult(){
        page.click(firstResultSelector);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public String getRestaurantName(){
        return page.textContent(restaurantName);
    }
}
