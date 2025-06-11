package uiTests;

import org.testng.annotations.Test;
//import  com.microsoft.playwright.assertions.*;
//import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class uiTest {

  @Test
  public void uiTest_1() throws InterruptedException {

    Playwright play = Playwright.create();
    Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
    BrowserContext br = browser.newContext();
    Page p = br.newPage();
    p.navigate("https://www.saucedemo.com/");
    Thread.sleep(2000);

    p.locator("#user-name").fill("standard_user");
    p.locator("#password").fill("secret_sauce");
    p.locator("#login-button").click();

    // Locator link = p.getByRole(AriaRole.LINK, new
    // Page.GetByRoleOptions().setName("null"));

    try {
      assertThat(p.locator("text=Sauce Labs Backpack")).isVisible();
      System.out.println("Link is present");
    } catch (Exception e) {
      System.out.println(e.toString());
    }

    p.close();
    br.close();
    browser.close();
    play.close();

  }

}
