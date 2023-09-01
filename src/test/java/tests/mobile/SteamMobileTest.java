package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.AuthorizationConfig;
import help.PhoneManagerHelper;
import help.W3cActions;
import io.appium.java_client.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static io.appium.java_client.touch.offset.PointOption.point;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;
import static java.time.temporal.ChronoUnit.MILLIS;

@Tag("steamMobile")
@Feature("Автотесты для Mobile")
@Owner("Катасонова Мария")
public class SteamMobileTest extends TestBaseMobile {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());




    @Test
    @Story("Раздел игр")
    @DisplayName("Кнопка поиска игр")
    void searchGames() {
        step("Авторизоваться", () -> {
            openApp();
        });
        step("Ввести название игры в поле поиска", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead");
        });
        step("Перейти в игру", () -> {
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
        });
        step("Проверка, что нашли нужную игру", () -> {
            $$(AppiumBy.className("android.view.View")).get(1).shouldHave(name("Cuphead - The Delicious Last Course")).shouldBe(visible.because("Игра не найдена"));
        });
    }

    @Test
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGames() {
        step("Авторизоваться", () -> {
            openApp();
        });
        step("Ввести название игры в поле поиска", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead");
        });
        step("Перейти в игру и проскролить вниз", () -> {
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
            sleep(1000);
            PhoneManagerHelper.swipeUpQuick(12000);
            PhoneManagerHelper.swipeUpQuick(12000);
        });
        step("Довать игру в корзину", () -> {
            $(AppiumBy.xpath("(//android.view.View[@content-desc=\"Add to Cart\"])[1]/android.widget.TextView")).click();
        });
        step("Проверка, что игра в корзине", () -> {
            $$(AppiumBy.className("android.view.View")).get(2).shouldHave(text("YOUR SHOPPING CART"));
        });
    }

    @Test
    @Story("Корзина")
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        step("Авторизоваться", () -> {
            openApp();
        });
        step("Ввести название игры в поле поиска", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead");
        });
        step("Перейти в игру и проскролить вниз", () -> {
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
            sleep(1000);
            PhoneManagerHelper.swipeUpQuick(12000);
            PhoneManagerHelper.swipeUpQuick(12000);
        });
        step("Довать игру в корзину", () -> {
            sleep(1000);
            $(AppiumBy.xpath("(//android.view.View[@content-desc=\"Add to Cart\"])[1]/android.widget.TextView")).click();
        });
        step("Удалить игру из корзины", () -> {

      //      $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"Remove\"]/android.widget.TextView")).click();
            $$(AppiumBy.className("android.view.View")).get(4).shouldHave(text("Your item has been removed!"));
        });
    }


    public static void openApp() {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            $$(AppiumBy.className("android.widget.TextView")).get(1).shouldHave(text("STEAM NOTIFICATIONS")).shouldBe(visible);
            PhoneManagerHelper.swipeFromRightToLeft();
            PhoneManagerHelper.swipeFromRightToLeft();
            PhoneManagerHelper.swipeFromRightToLeft();
            $$(AppiumBy.className("android.widget.TextView")).get(14).shouldHave(text("Done")).shouldBe(visible.because("Не нажали на 'Сделано'")).click();
            $$(AppiumBy.className("android.widget.TextView")).get(4).shouldHave(text("Add authenticator")).shouldBe(visible.because("Не вошли в профиль")).click();
            Selenide.$$(AppiumBy.className("android.widget.ImageView")).get(0).shouldBe(Condition.visible).click();
            Selenide.$$(AppiumBy.className("android.widget.TextView")).get(0).shouldHave(Condition.text("katasonomasa").because("Не вошли в профиль"));
            $$(AppiumBy.className("android.widget.TextView")).get(3).shouldHave(text("Games")).click();
            $$(AppiumBy.className("android.widget.TextView")).get(3).shouldHave(text("Browse the Store")).click();
    }
}
