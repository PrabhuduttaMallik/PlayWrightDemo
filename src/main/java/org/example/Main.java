package org.example;

import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Playwright playwright = Playwright.create();
//        1. using LaunchOptions()
//        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
//        launchOptions.setChannel("chrome");
//        launchOptions.setHeadless(false);
//        Browser browser = playwright.chromium().launch(launchOptions);

//        2. Other way
//        Browser browser = playwright.chromium().launch();
//
//        3. Another way
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();;

        browserContext.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        System.out.println("Page title is ---->>>>"+page.title());
        System.out.println("Page URL is ---->>>>"+page.url());
        page.pause();

        browser.close();
        playwright.close();
    }
}