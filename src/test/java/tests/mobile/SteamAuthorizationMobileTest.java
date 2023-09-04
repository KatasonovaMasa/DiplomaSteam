package tests.mobile;

import com.codeborne.selenide.Condition;
import config.AuthorizationConfig;
import help.PhoneManagerHelper;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

@Tag("steamMobile")
@Feature("Автотесты для Mobile")
@Owner("Катасонова Мария")
public class SteamAuthorizationMobileTest extends BrowserstackTestBaseMobile {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());

    @Test
    @Story("Авторизация в приложении")
    @DisplayName("Авторизация в приложении")
    void openApp() {
        step("Заполняем логин/пароль", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
        });
        step("Нажать кнопку 'Sign in'", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
        });
        step("Проверить, что мы вошли в приложение и просвайпить до закрытия приветственных окон", () -> {
            $$(AppiumBy.className("android.widget.TextView")).get(1).shouldHave(Condition.text("STEAM NOTIFICATIONS"));
            sleep(4000);
            PhoneManagerHelper.swipeFromRightToLeft();
            PhoneManagerHelper.swipeFromRightToLeft();
        });
        step("Закрыть приветственные окна", () -> {
            $$(AppiumBy.className("android.widget.TextView")).get(14).shouldHave(Condition.text("Done")).click();
            $$(AppiumBy.className("android.widget.TextView")).get(4).shouldHave(Condition.text("Add authenticator")).click();
        });
        step("Перейти в профиль", () -> {
            $$(AppiumBy.className("android.widget.ImageView")).get(0).shouldBe(Condition.visible).click();
            $$(AppiumBy.className("android.widget.TextView")).get(0).shouldHave(Condition.text("katasonomasa").because("Не вошли в профиль"));
        });
        step("Разлогиниться из приложения", () -> {
            $$(AppiumBy.className("android.widget.TextView")).get(20).shouldHave(Condition.text("Sign Out")).click();
            $$(AppiumBy.className("android.widget.Button")).get(0).click();
            $(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Forgot your account name or password?')]")).shouldHave(Condition.visible.because("Не вышли из приложения"));
        });


    }
}
