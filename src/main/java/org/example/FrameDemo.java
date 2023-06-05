package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class FrameDemo {

    static Playwright playwright;
    static Page page;
    static Browser browser;

    static FrameLocator frameLocator;

    @BeforeTest
    public void setUp(){

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test(enabled = false)
    public void frameTest() {
        try {

            /*
            How to navigate inside frame in playwright
             */
            page.navigate("https://the-internet.herokuapp.com/iframe");
            frameLocator = page.frameLocator("#mce_0_ifr");
            frameLocator.locator("#tinymce").fill("Inside Frame");
//            frameLocator.locator("#tinymce>p").dblclick();
//            frameLocator.locator("button[title='Bold']").click();


            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Some.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void nestedFrame(){

        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        for (Frame childFrames : page.mainFrame().childFrames()){
            System.out.println("The list of child frames are ::::"+childFrames.name());
            System.out.println("The frameElement of child frames are ::::"+childFrames.frameElement());
        }

        Frame frame = page.mainFrame();
        System.out.println("one"+frame.childFrames().get(0).name());
        System.out.println("two"+frame.childFrames().get(1).name());
    }

    @AfterTest
    public void tearDown(){

        page.close();
        playwright.close();
    }




}
