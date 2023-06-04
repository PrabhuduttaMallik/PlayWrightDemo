package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathSelectorPracticePage {

    static Page page;
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        selectUser("Joe.Root");
        selectUser("Jasmine.Morgan");
        //page.pause();
        page.close();
        playwright.close();
    }

    public static void selectUser(String username){

        page.locator("input[type='checkbox']:left-of(:text('"+username+"'))").first().click();
    }
}
