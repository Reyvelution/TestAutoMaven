package Pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class productPage {

    private final Page p;
    private final Locator verifyLink;

    public productPage(Page p) 
    {
        this.p=p;
        verifyLink=p.locator("text=Sauce Labs Backpack");
    
    }

    @Step("Verify the link is present")
    public void verifyLinkIsPresent()
    {
         assertThat(verifyLink).isVisible();

    }
}
