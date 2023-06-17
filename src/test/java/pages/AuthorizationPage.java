package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthorizationPage {
    public AuthorizationPage openSteam() {
        step("Открываем главную страницу", () -> {
            open("/");
        });
        return this;
    }


    private final SelenideElement
            in = $x("//a[@class='global_action_link']"),
            logins = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='text']"),
            passwords = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='password']"),
            sigIn = $x("//button[@type='submit']"),
            account = $x("//*[@id='account_pulldown']"),
            logout = $x("//a[@href='javascript:Logout();']");

    public AuthorizationPage openAuthorization(String login, String password) {
        step("Авторизуемся на сайте", () -> {
            in.click();
            logins.setValue(login);
            passwords.setValue(password);
            sigIn.click();
        });
        return this;
    }

    public AuthorizationPage logout() {
        step("Выход из учетной записи", () -> {
            account.click();
            logout.click();
        });
        return this;
    }
}


