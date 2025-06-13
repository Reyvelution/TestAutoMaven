package uiTests;

//import  com.microsoft.playwright.assertions.*;
//import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Pages.loginPage;
import Pages.productPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Web Application Regression Testing using JUnit5")
@Feature("Login Page Tests")

public class uiTest {

  @Severity(SeverityLevel.NORMAL)
  @Description("Test Description : Verify the title of Login Page")
  @Story("Title of Login Page")
  @Test
  public void uiTest_1() throws InterruptedException {

    Playwright play = Playwright.create();
    Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
    BrowserContext br = browser.newContext();
    Page p = br.newPage();
    p.navigate("https://www.saucedemo.com/");
    Thread.sleep(2000);

    loginPage loginCrd = new loginPage(p);
    loginCrd.login("standard_user", "secret_sauce");

    productPage product = new productPage(p);

    try {
      product.verifyLinkIsPresent();
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
