package org.example;

import com.microsoft.playwright.*;

public class BrowserContextConcept {

    public static void main(String[] args) {

        Playwright playwright  =Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page page = browserContext1.newPage();
        page.navigate("https://www.wikipedia.org/");
        System.out.println("Page title1 ----->>>"+page.title());

        BrowserContext browserContext2 = browser.newContext();
        Page page1 = browserContext2.newPage();
        page1.navigate("https://www.google.com");
        System.out.println("Page title2 ----->>>"+page1.title());

        BrowserContext browserContext3 = browser.newContext();
        Page page2 = browserContext3.newPage();
        page2.navigate("http://www.youtube.com");
        System.out.println("Page title3 ----->>>"+page2.title());

        page.close();
        browserContext1.close();

        page1.close();
        browserContext2.close();

        page2.close();
        browserContext3.close();
    }
}
