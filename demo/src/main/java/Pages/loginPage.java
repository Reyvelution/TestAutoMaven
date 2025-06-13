package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import io.qameta.allure.Step;

public class loginPage {

    private final Page p;
    private final Locator user;
    private final Locator pass;
    private final Locator clickButton;

    
    public loginPage(Page p) {
        this.p = p;
        user = p.locator("#user-name");
        pass = p.locator("#password");
        clickButton = p.locator("#login-button");
    }

    @Step("Login Page")
    public void login(String username, String password) {

        user.fill(username);
        pass.fill(password);
        clickButton.click();

    }
}
