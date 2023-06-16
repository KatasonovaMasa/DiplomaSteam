package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SteamAuthorizationPage {
    public SteamAuthorizationPage openSteam() {
        step("Открываем главную страницу", () -> {
            open("/");
        });
        return this;
    }
    private final SelenideElement
            in = $x("//a[@class='global_action_link']"),
            login = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='text']"),
            password = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='password']"),
            sigIn = $x("//button[@type='submit']"),
            account = $x("//*[@id='account_pulldown']"),
            logout = $x("//a[@href='javascript:Logout();']");
    public SteamAuthorizationPage openAuthorization() {
        step("Авторизуемся на сайте", () -> {
            in.click();
            login.setValue("Test_quru");
            password.setValue("Mgbb4gas!)");
            sigIn.click();
        });
        return this;
    }
        public SteamAuthorizationPage logout() {
        step("Выход из учетной записи", () -> {
            account.click();
            logout.click();
        });
        return this;
    }
}


