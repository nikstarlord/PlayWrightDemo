package org.example.config;

import com.microsoft.playwright.BrowserType;

import java.util.HashMap;

public class Configuration {
    private static final String BROWSER_NAME = "chrome";
    private static final String BASE_URL = "https://zomato.com";
    private static final String AUTH_TOKEN = "";
    private static final boolean HEADLESS = false;

    public static BrowserType.LaunchOptions getBrowserOptions (){
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.headless = HEADLESS;
        return options;
    }

    public static String getBaseURL(){
        return BASE_URL;
    }

    public static String getAuthToken(){
        return AUTH_TOKEN;
    }

    public static String getBrowserName(){
        return BROWSER_NAME;
    }
}
