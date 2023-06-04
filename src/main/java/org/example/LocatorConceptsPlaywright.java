package org.example;

import com.microsoft.playwright.*;

public class LocatorConceptsPlaywright {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

        //the commented code also works
        //Locator textVal = page.locator("text= Platform").first();
//        textVal.hover();
//        textVal.click();
        String value = page.locator(".card-body>h2").textContent();
        System.out.println("the text here is ----> "+value);


        //page.locator("form div button:text = Login")
        page.pause();

        page.close();
        playwright.close();
    }
}
