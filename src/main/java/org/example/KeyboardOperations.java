package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class KeyboardOperations {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext browserContext;
    static Page page;

    @BeforeTest
    public static void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public static void testMethod1(){

        page.navigate("https://the-internet.herokuapp.com/key_presses");
        page.click("#target");
        page.keyboard().type("prabhu");
        page.pause();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Some.png")));
    }

    @Test
    public static void jsHandleExample(){

        page.navigate("someUrl");
        JSHandle jsHandle = page.evaluateHandle("window.scrollTo(0,567)");
        System.out.println("The scrolling is --->>>"+jsHandle.jsonValue());
    }

    @AfterTest
    public static void tearDown() {

        page.close();
        playwright.close();
    }
}
