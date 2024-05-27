package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.utils.BrowserFactory;

public class BasePage {
    protected Page page;

    public BasePage (){
        this.page = BrowserFactory.getPage();
    }

    public void navigateTo(String url){
        page.navigate(url);
    }
}
