package org.example.utils;

import com.microsoft.playwright.*;
import org.example.config.Configuration;

public class BrowserFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static void setup(){
        playwright = Playwright.create();
        BrowserType browserType = switch (Configuration.getBrowserName()) {
            case "Firefox" -> playwright.firefox();
            case "Safari" -> playwright.webkit();
            default -> playwright.chromium();
        };
        browser = browserType.launch(Configuration.getBrowserOptions());
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.storageState = Configuration.getAuthToken();
        BrowserContext browserContext = browser.newContext(contextOptions);
        page = browserContext.newPage();
    }

    public static Page getPage(){
        if(page == null){
            setup();
        }
        return page;
    }

    public static void tearDown(){
        if(browser != null){
            browser.close();
            playwright.close();
        }
    }
}
