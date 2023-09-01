package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.AuthorizationConfig;
import help.PhoneManagerHelper;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("steamMobile")
@Feature("Автотесты для Mobile")
@Owner("Катасонова Мария")
public class SteamAuthorizationMobileTest {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());

    @Test
    @Story("Авторизация в приложении")
    @DisplayName("Авторизация в приложении")
    void openApp() {
        Allure.step("Заполняем логин/пароль", () -> {
            Selenide.$$(AppiumBy.className("android.widget.EditText")).get(0).click();
            Selenide.$$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            Selenide.$$(AppiumBy.className("android.widget.EditText")).get(1).click();
            Selenide.$$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
        });
        Allure.step("Нажать кнопку 'Sign in'", () -> {
            Selenide.$$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
        });
        Allure.step("Проверить, что мы вошли в приложение и просвайпить до закрытия приветственных окон", () -> {
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(1).shouldHave(Condition.text("STEAM NOTIFICATIONS"));
            PhoneManagerHelper.swipeFromRightToLeft();
            PhoneManagerHelper.swipeFromRightToLeft();
        });
        Allure.step("Закрыть приветственные окна", () -> {
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(14).shouldHave(Condition.text("Done")).click();
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(4).shouldHave(Condition.text("Add authenticator")).click();
        });
        Allure.step("Перейти в профиль", () -> {
            Selenide.$$(AppiumBy.className("android.widget.ImageView")).get(0).shouldBe(Condition.visible).click();
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(0).shouldHave(Condition.text("katasonomasa").because("Не вошли в профиль"));
        });
        Allure.step("Разлогиниться из приложения", () -> {
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(20).shouldHave(Condition.text("Sign Out")).click();
            Selenide.$$(AppiumBy.className("android.widget.Button")).get(0).click();
            Selenide.$(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Forgot your account name or password?')]")).shouldHave(Condition.visible.because("Не вышли из приложения"));
        });
    }
}
